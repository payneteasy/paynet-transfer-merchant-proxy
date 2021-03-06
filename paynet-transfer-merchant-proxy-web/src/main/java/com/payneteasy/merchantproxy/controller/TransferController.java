package com.payneteasy.merchantproxy.controller;

import com.payneteasy.merchantproxy.generated.controller.TransferApi;
import com.payneteasy.merchantproxy.generated.model.CheckTransferRequest;
import com.payneteasy.merchantproxy.generated.model.CheckTransferResponse;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequest;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponse;
import com.payneteasy.merchantproxy.generated.model.RatesRequest;
import com.payneteasy.merchantproxy.generated.model.RatesResponse;
import com.payneteasy.merchantproxy.service.TransactionService;
import com.payneteasy.merchantproxy.util.CacheUtil;

import java.math.BigDecimal;
import java.security.GeneralSecurityException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;

@Controller
@CrossOrigin
public class TransferController implements TransferApi {

  private final Logger logger = LoggerFactory.getLogger(TransferController.class);

  private final TransactionService transactionService;

  private final BigDecimal rate;
  private final BigDecimal rateMin;
  private final BigDecimal limitMin;
  private final BigDecimal limitMax;

  @Autowired
  public TransferController(final TransactionService transactionService,
                            final @Value("${paynet.rate}") BigDecimal rate,
                            final @Value("${paynet.rateMin}") BigDecimal rateMin,
                            final @Value("${paynet.limitMin}") BigDecimal limitMin,
                            final @Value("${paynet.limitMax}") BigDecimal limitMax) {
    this.transactionService = transactionService;

    this.rate = rate;
    this.rateMin = rateMin;
    this.limitMin = limitMin;
    this.limitMax = limitMax;
  }

  @Override
  public ResponseEntity<Object> transferGetRatePost(final @ApiParam(value = "Session info" ,required=true )  @Valid @RequestBody RatesRequest sessionData) {
    CacheUtil.putAccessTokenSerialNumber(sessionData.getSession().getAccessToken(), sessionData.getConsumer().getDevice().getSerialNumber());

    final RatesResponse response = new RatesResponse()
        .rateInterest(rate.doubleValue())
        .rateMin(rateMin.doubleValue())
        .limitMin(limitMin.doubleValue())
        .limitMax(limitMax.doubleValue());

    return new ResponseEntity<>(response, HttpStatus.OK);
  }


  @Override
  public ResponseEntity<Object> transferInitiateTransferPost(@ApiParam(value = "Device info, location data, session info, amount", required = true) final @Valid @RequestBody InitiateTransferRequest initiateTransferData) {
    logger.info("Initiate transfer, request is {}", initiateTransferData.toString());

    final InitiateTransferResponse initiateTransactionResponse;
    try {
      initiateTransactionResponse = transactionService.initiateTransaction(initiateTransferData);
    } catch (final IllegalArgumentException e) {
      logger.error("Error initiating transfer: {}", e.getMessage());
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    } catch (final ApplicationException e) {
      throw e;
    } catch (final Exception e) {
      logger.error("Exception caught:", e);
      throw new ApplicationException(e, null, ApplicationException.RequestType.TRANSFER_INITIATE);
    }

    logger.info("Transfer initiated, response: {}", initiateTransactionResponse);

    return new ResponseEntity<>(initiateTransactionResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Object> transferInvoiceIdCheckPost(@ApiParam(value = "Previously generated transfer transaction identifier", required = true) final @PathVariable("invoiceId") String invoiceId,
                                                           final @ApiParam(value = "Transaction data to check", required = true) @Valid @RequestBody CheckTransferRequest checkRequestData) {
    logger.info("Transfer check request: {}", checkRequestData.toString());

    final CheckTransferResponse checkTransferResponse;
    try {
      checkTransferResponse = transactionService.checkTransfer(invoiceId, checkRequestData);
    } catch (final IllegalArgumentException e) {
      logger.error("Error on transfer check", e);
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    } catch (final ApplicationException e) {
      throw e;
    } catch (final Exception e) {
      logger.error("Exception caught:", e);
      throw new ApplicationException(e, null, ApplicationException.RequestType.TRANSFER_CHECK);
    }

    logger.info("Transfer check result: {}", checkTransferResponse.toString());

    return new ResponseEntity<>(checkTransferResponse, HttpStatus.OK);
  }
}
