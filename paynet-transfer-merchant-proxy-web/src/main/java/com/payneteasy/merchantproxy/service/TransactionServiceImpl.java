package com.payneteasy.merchantproxy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.payneteasy.merchantproxy.model.TransferData;
import com.payneteasy.merchantproxy.controller.ApplicationException;
import com.payneteasy.merchantproxy.dao.TransferDataDao;
import com.payneteasy.merchantproxy.generated.model.CheckTransferRequest;
import com.payneteasy.merchantproxy.generated.model.CheckTransferResponse;
import com.payneteasy.merchantproxy.generated.model.CheckTransferResponseSession;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequest;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequestTransaction;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponse;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponseRates;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponseSession;
import com.payneteasy.merchantproxy.util.CacheUtil;
import com.payneteasy.merchantproxy.util.StrUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

  private final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

  private static final int NONCE_LENGTH = 64;

  private final BigDecimal TEN_THOUSAND = BigDecimal.valueOf(10000);

  private final TransferDataDao transferDataDao;

  private final String endpointId;
  private final BigDecimal rate;
  private final BigDecimal rateMin;
  private final String controlKey;

  @Autowired
  public TransactionServiceImpl(final TransferDataDao transferDataDao,
                                final @Value("${paynet.rate}") BigDecimal rate,
                                final @Value("${paynet.rateMin}") BigDecimal rateMin) {
    this.transferDataDao = transferDataDao;

    this.endpointId = System.getenv("MERCHANT_PROXY_ENDPOINT_ID");
    this.rate = rate;
    this.rateMin = rateMin;
    this.controlKey = System.getenv("MERCHANT_PROXY_CONTROL_KEY");

    if (endpointId == null) {
      logger.error("Environment variable MERCHANT_PROXY_ENDPOINT_ID must be set");
      throw new IllegalArgumentException("Environment variable MERCHANT_PROXY_ENDPOINT_ID must be set");
    }

    if (controlKey == null) {
      logger.error("Environment variable MERCHANT_PROXY_CONTROL_KEY must be set");
      throw new IllegalArgumentException("Environment variable MERCHANT_PROXY_CONTROL_KEY must be set");
    }
  }

  @Override
  public BigDecimal calcRate(final long amountCentis, final String fromBin, final String toBin) {
    final BigDecimal calculatedRate = BigDecimal.valueOf(amountCentis).multiply(rate).divide(TEN_THOUSAND, 2, RoundingMode.HALF_UP);
    return calculatedRate.compareTo(rateMin) < 0 ? rateMin : calculatedRate;
  }

  @Override
  public BigDecimal calcRate(final long amountCentis) {
    final BigDecimal calculatedRate = BigDecimal.valueOf(amountCentis).multiply(rate).divide(TEN_THOUSAND, 2, RoundingMode.HALF_UP);
    return calculatedRate.compareTo(rateMin) < 0 ? rateMin : calculatedRate;
  }

  @Override
  @Transactional(noRollbackFor = ApplicationException.class)
  public InitiateTransferResponse initiateTransaction(final InitiateTransferRequest request) {
    final String expectedSerialNumber = CacheUtil.getAccessTokenSerialNumber(request.getSession().getAccessToken());

    if (!Objects.equals(expectedSerialNumber, request.getConsumer().getDevice().getSerialNumber())) {
      logger.warn("Invalid initiate transfer request, access token '{}' is invalid", request.getSession().getAccessToken());
      throw new IllegalArgumentException("Invalid device serial number for access token or unknown access token");
    }

    logger.info("Registering initiate transfer request: {}", request);
    final TransferData transferData = new TransferData();
    try {
      transferData.setInitiateTransferRequest(StrUtil.OBJECT_MAPPER.writeValueAsString(request));
    } catch (final JsonProcessingException e) {
      logger.error("Exception caught: ", e);
      throw new ApplicationException(e, null, ApplicationException.RequestType.TRANSFER_INITIATE);
    }

    transferData.setInitiateDate(new Date());
    final String invoiceId = UUID.randomUUID().toString();
    transferData.setInvoiceId(invoiceId);
    final long id = transferDataDao.create(transferData);

    final InitiateTransferResponse response = new InitiateTransferResponse();
    response.setEndpointId(endpointId);

    final InitiateTransferResponseRates rates = new InitiateTransferResponseRates();
    final InitiateTransferRequestTransaction transaction = request.getTransaction();
    rates.min(calcRate(transaction.getAmountCentis()).toPlainString());
    rates.max(rates.getMin());
    response.setRates(rates);

    response.setInvoiceId(invoiceId);

    final InitiateTransferResponseSession session = new InitiateTransferResponseSession();
    final String nonce = StrUtil.generateRandomString(NONCE_LENGTH);
    session.setNonce(nonce);
    response.setSession(session);

    final String key = controlKey.replace("-", "");
    final String strToHash = request.getSession().getAccessToken() + request.getConsumer().getDevice().getSerialNumber() +
        endpointId + nonce + invoiceId + transaction.getAmountCentis() + transaction.getCurrency();

    try {
      session.setSignature(StrUtil.calcShaHash(strToHash.getBytes(StandardCharsets.UTF_8), key));
    } catch (final GeneralSecurityException e) {
      logger.error("Exception caught generating response for invoiceId={}", invoiceId, e);
      throw new ApplicationException(e, id, ApplicationException.RequestType.TRANSFER_INITIATE);
    }

    try {
      transferDataDao.setInitiateTransferResponse(transferData.getId(), StrUtil.OBJECT_MAPPER.writeValueAsString(response), false);
    } catch (final JsonProcessingException e) {
      logger.error("Exception caught: ", e);
      throw new ApplicationException(e, transferData.getId(), ApplicationException.RequestType.TRANSFER_INITIATE);
    }

    return response;
  }

  @Override
  @Transactional(noRollbackFor = ApplicationException.class)
  public CheckTransferResponse checkTransfer(final String invoiceId, final CheckTransferRequest request) {
    final String expectedSerialNumber = CacheUtil.getAccessTokenSerialNumber(request.getSession().getAccessToken());
    final String actualSerialNumber = request.getConsumer().getDevice().getSerialNumber();

    if (!Objects.equals(expectedSerialNumber, actualSerialNumber)) {
      logger.warn("Invalid check transfer request, access token '{}' is invalid", request.getSession().getAccessToken());
      throw new IllegalArgumentException("Invalid device serial number for access token or unknown access token");
    }

    final TransferData transferData = transferDataDao.findByInvoiceId(invoiceId);

    if (transferData == null) {
      logger.warn("Invalid invoiceId '{}'", invoiceId);
      throw new IllegalArgumentException("Invalid invoiceId '" + invoiceId + "'");
    }

    final InitiateTransferResponse initiateTransferResponse;

    try {
      initiateTransferResponse = StrUtil.OBJECT_MAPPER.readValue(transferData.getInitiateTransferResponse(), InitiateTransferResponse.class);
    } catch (final IOException e) {
      logger.error("Exception caught: ", e);
      throw new ApplicationException(e, transferData.getId(), ApplicationException.RequestType.TRANSFER_CHECK);
    }

    final String expectedNonce = initiateTransferResponse.getSession().getNonce();
    final String expectedSignature = initiateTransferResponse.getSession().getSignature();
    final String actualNonce = request.getSession().getNonce();
    final String actualSignature = request.getSession().getSignature();

    if (!Objects.equals(expectedNonce, actualNonce)) {
      logger.warn("Invalid check transfer request, session nonce '{}' is invalid", actualNonce);
      throw new IllegalArgumentException("Invalid session nonce");
    }

    if (!Objects.equals(expectedSignature, actualSignature)) {
      logger.warn("Invalid check transfer request, session signature '{}' is invalid", actualSignature);
      throw new IllegalArgumentException("Invalid session signature");
    }

    logger.info("Registering check transfer request for invoiceId={}, {}", invoiceId, request);

    try {
      transferDataDao.setCheckTransferRequest(transferData.getId(), StrUtil.OBJECT_MAPPER.writeValueAsString(request), new Date());
    } catch (final JsonProcessingException e) {
      logger.error("Exception caught: ", e);
      throw new ApplicationException(e, transferData.getId(), ApplicationException.RequestType.TRANSFER_CHECK);
    }

    final CheckTransferResponse response = new CheckTransferResponse();
    response.setInvoiceId(invoiceId);

    final CheckTransferResponseSession session = new CheckTransferResponseSession();
    session.setNonce(actualNonce);
    session.setToken(request.getSession().getToken());

    final String key = controlKey.replace("-", "");
    final String strToHash = actualSerialNumber + actualNonce + endpointId + invoiceId;
    try {
      session.setCheckSignature(StrUtil.calcShaHash(strToHash.getBytes(StandardCharsets.UTF_8), key));
    } catch (final GeneralSecurityException e) {
      logger.error("Exception caught generating response for invoiceId={}", invoiceId, e);
      throw new ApplicationException(e, transferData.getId(), ApplicationException.RequestType.TRANSFER_CHECK);
    }

    response.setSession(session);

    try {
      transferDataDao.setCheckTransferResponse(transferData.getId(), StrUtil.OBJECT_MAPPER.writeValueAsString(response), false);
    } catch (final JsonProcessingException e) {
      logger.error("Exception caught: ", e);
      throw new ApplicationException(e, transferData.getId(), ApplicationException.RequestType.TRANSFER_CHECK);
    }

    return response;
  }
}
