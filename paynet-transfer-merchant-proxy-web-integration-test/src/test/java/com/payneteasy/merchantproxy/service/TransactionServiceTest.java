package com.payneteasy.merchantproxy.service;

import com.payneteasy.merchantproxy.model.TransferData;
import com.payneteasy.merchantproxy.config.AppConfig;
import com.payneteasy.merchantproxy.dao.TransferDataDao;
import com.payneteasy.merchantproxy.generated.model.CheckTransferRequest;
import com.payneteasy.merchantproxy.generated.model.CheckTransferResponse;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequest;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponse;
import com.payneteasy.merchantproxy.util.CacheUtil;
import com.payneteasy.merchantproxy.util.StrUtil;
import com.payneteasy.merchantproxy.util.TestUtils;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
@Rollback
public class TransactionServiceTest {

  @Autowired
  private TransferDataDao transferDataDao;

  @Autowired
  private TransactionService transactionService;

  @Test
  public void testInitiateTransaction() throws GeneralSecurityException, IOException {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();

    CacheUtil.putAccessTokenSerialNumber(initiateTransferRequest.getSession().getAccessToken(), initiateTransferRequest.getConsumer().getDevice().getSerialNumber());

    final InitiateTransferResponse initiateTransferResponse = transactionService.initiateTransaction(initiateTransferRequest);

    final TransferData transferData = transferDataDao.findByInvoiceId(initiateTransferResponse.getInvoiceId());

    Assert.assertNotNull(transferData);
    Assert.assertEquals(initiateTransferRequest, StrUtil.OBJECT_MAPPER.readValue(transferData.getInitiateTransferRequest(), InitiateTransferRequest.class));
    Assert.assertEquals(initiateTransferResponse.getInvoiceId(), transferData.getInvoiceId());
    Assert.assertFalse(transferData.isInitiateError());
    Assert.assertNotNull(transferData.getInitiateDate());
    Assert.assertNull(transferData.getCheckTransferRequest());
    Assert.assertNull(transferData.getCheckTransferResponse());
    Assert.assertNull(transferData.getCheckDate());
    Assert.assertNull(transferData.isCheckError());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitiateTransactionBadAccessToken() throws GeneralSecurityException, IOException {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    transactionService.initiateTransaction(initiateTransferRequest);
  }

  @Test
  public void testCheckTransfer() throws GeneralSecurityException, IOException {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    final InitiateTransferResponse initiateTransferResponse = transactionService.initiateTransaction(initiateTransferRequest);

    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    final String nonce = initiateTransferResponse.getSession().getNonce();
    checkTransferRequest.getSession().setNonce(nonce);
    final String signature = initiateTransferResponse.getSession().getSignature();
    checkTransferRequest.getSession().setSignature(signature);

    final CheckTransferResponse checkTransferResponse = transactionService.checkTransfer(initiateTransferResponse.getInvoiceId(), checkTransferRequest);

    Assert.assertEquals(initiateTransferResponse.getInvoiceId(), checkTransferResponse.getInvoiceId());

    final TransferData transferData = transferDataDao.findByInvoiceId(initiateTransferResponse.getInvoiceId());

    Assert.assertNotNull(transferData);
    Assert.assertEquals(initiateTransferRequest, StrUtil.OBJECT_MAPPER.readValue(transferData.getInitiateTransferRequest(), InitiateTransferRequest.class));
    Assert.assertEquals(initiateTransferResponse.getInvoiceId(), transferData.getInvoiceId());
    Assert.assertFalse(transferData.isInitiateError());
    Assert.assertNotNull(transferData.getInitiateDate());
    Assert.assertEquals(checkTransferRequest, StrUtil.OBJECT_MAPPER.readValue(transferData.getCheckTransferRequest(), CheckTransferRequest.class));
    Assert.assertEquals(checkTransferResponse, StrUtil.OBJECT_MAPPER.readValue(transferData.getCheckTransferResponse(), CheckTransferResponse.class));
    Assert.assertNotNull(transferData.getCheckDate());
    Assert.assertTrue(!transferData.getInitiateDate().after(transferData.getCheckDate()));
    Assert.assertFalse(transferData.isCheckError());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckTransferBadAccessToken() throws GeneralSecurityException, IOException {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    final InitiateTransferResponse initiateTransferResponse = transactionService.initiateTransaction(initiateTransferRequest);

    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    final String accessToken = initiateTransferRequest.getSession().getAccessToken();
    checkTransferRequest.getSession().setAccessToken(accessToken + "abcd");

    transactionService.checkTransfer(initiateTransferResponse.getInvoiceId(), checkTransferRequest);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckTransferBadNonce() throws GeneralSecurityException, IOException {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    final InitiateTransferResponse initiateTransferResponse = transactionService.initiateTransaction(initiateTransferRequest);

    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    final String nonce = initiateTransferResponse.getSession().getNonce();
    checkTransferRequest.getSession().setNonce(nonce + "abcd");

    transactionService.checkTransfer(initiateTransferResponse.getInvoiceId(), checkTransferRequest);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckTransferBadSignature() throws GeneralSecurityException, IOException {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    final InitiateTransferResponse initiateTransferResponse = transactionService.initiateTransaction(initiateTransferRequest);

    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    final String signature = initiateTransferResponse.getSession().getSignature();
    checkTransferRequest.getSession().setSignature(signature + "abcd");

    transactionService.checkTransfer(initiateTransferResponse.getInvoiceId(), checkTransferRequest);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckTransferBadSerialNumber() throws GeneralSecurityException, IOException {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    final InitiateTransferResponse initiateTransferResponse = transactionService.initiateTransaction(initiateTransferRequest);

    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    final String serialNumber = initiateTransferRequest.getConsumer().getDevice().getSerialNumber();
    checkTransferRequest.getConsumer().getDevice().setSerialNumber(serialNumber + "abcd");

    transactionService.checkTransfer(initiateTransferResponse.getInvoiceId(), checkTransferRequest);
  }
}
