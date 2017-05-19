package com.payneteasy.merchantproxy.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.payneteasy.merchantproxy.model.TransferData;
import com.payneteasy.merchantproxy.config.AppConfig;
import com.payneteasy.merchantproxy.generated.model.CheckTransferRequest;
import com.payneteasy.merchantproxy.generated.model.CheckTransferResponse;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequest;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponse;
import com.payneteasy.merchantproxy.util.StrUtil;

import java.io.IOException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.payneteasy.merchantproxy.util.TestUtils.createMockCheckRequest;
import static com.payneteasy.merchantproxy.util.TestUtils.createMockCheckResponse;
import static com.payneteasy.merchantproxy.util.TestUtils.createMockInitiateRequest;
import static com.payneteasy.merchantproxy.util.TestUtils.createMockInitiateResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
@Rollback
public class TransferDataDaoTest {

  @Autowired
  private TransferDataDao transferDataDao;

  @Test
  public void testCreate() throws JsonProcessingException {
    final TransferData transferData = new TransferData();

    final InitiateTransferRequest initiateTransferRequest = createMockInitiateRequest();

    transferData.setInitiateTransferRequest(StrUtil.OBJECT_MAPPER.writeValueAsString(initiateTransferRequest));
    transferData.setInitiateDate(new Date());

    transferDataDao.create(transferData);
  }

  @Test
  public void testFind() throws IOException {
    final TransferData transferData = new TransferData();

    final InitiateTransferRequest initiateTransferRequest = createMockInitiateRequest();

    transferData.setInitiateTransferRequest(StrUtil.OBJECT_MAPPER.writeValueAsString(initiateTransferRequest));
    transferData.setInitiateDate(new Date());

    final long id = transferDataDao.create(transferData);

    final TransferData found = transferDataDao.findById(id);

    Assert.assertEquals(id, found.getId());
    Assert.assertEquals(transferData.getInitiateDate(), found.getInitiateDate());
    Assert.assertEquals(initiateTransferRequest, StrUtil.OBJECT_MAPPER.readValue(found.getInitiateTransferRequest(), InitiateTransferRequest.class));
    Assert.assertNull(found.getInvoiceId());
    Assert.assertNull(found.getInitiateTransferResponse());
    Assert.assertNull(found.getCheckDate());
    Assert.assertNull(found.getCheckTransferRequest());
    Assert.assertNull(found.getCheckTransferResponse());
    Assert.assertNull(found.isInitiateError());
    Assert.assertNull(found.isCheckError());
  }

  @Test
  public void testFindByInvoiceId() throws IOException {
    final TransferData transferData = new TransferData();

    final InitiateTransferRequest initiateTransferRequest = createMockInitiateRequest();

    transferData.setInitiateTransferRequest(StrUtil.OBJECT_MAPPER.writeValueAsString(initiateTransferRequest));
    transferData.setInitiateDate(new Date());
    transferData.setInvoiceId("someUuid");

    final long id = transferDataDao.create(transferData);

    final InitiateTransferResponse initiateTransferResponse = createMockInitiateResponse("someUuid");

    transferData.setInitiateTransferResponse(StrUtil.OBJECT_MAPPER.writeValueAsString(initiateTransferResponse));
    transferData.setInvoiceId(initiateTransferResponse.getInvoiceId());
    transferData.setInitiateError(false);

    transferDataDao.setInitiateTransferResponse(id, transferData.getInitiateTransferResponse(), false);

    final TransferData found = transferDataDao.findByInvoiceId(initiateTransferResponse.getInvoiceId());

    Assert.assertEquals(id, found.getId());
    Assert.assertEquals(transferData.getInitiateDate(), found.getInitiateDate());
    Assert.assertEquals(initiateTransferRequest, StrUtil.OBJECT_MAPPER.readValue(found.getInitiateTransferRequest(), InitiateTransferRequest.class));
    Assert.assertEquals(transferData.getInvoiceId(), found.getInvoiceId());
    Assert.assertEquals(initiateTransferResponse, StrUtil.OBJECT_MAPPER.readValue(found.getInitiateTransferResponse(), InitiateTransferResponse.class));
    Assert.assertNull(found.getCheckDate());
    Assert.assertNull(found.getCheckTransferRequest());
    Assert.assertNull(found.getCheckTransferResponse());
    Assert.assertFalse(found.isInitiateError());
    Assert.assertNull(found.isCheckError());
  }

  @Test
  public void testAddCheckRequest() throws IOException {
    final TransferData transferData = new TransferData();

    final InitiateTransferRequest initiateTransferRequest = createMockInitiateRequest();

    transferData.setInitiateTransferRequest(StrUtil.OBJECT_MAPPER.writeValueAsString(initiateTransferRequest));
    transferData.setInitiateDate(new Date());
    transferData.setInvoiceId("someUuid");

    final long id = transferDataDao.create(transferData);

    final InitiateTransferResponse initiateTransferResponse = createMockInitiateResponse("someUuid");

    transferData.setInitiateTransferResponse(StrUtil.OBJECT_MAPPER.writeValueAsString(initiateTransferResponse));
    transferData.setInvoiceId(initiateTransferResponse.getInvoiceId());
    transferData.setInitiateError(false);

    transferDataDao.setInitiateTransferResponse(id, transferData.getInitiateTransferResponse(), false);

    final CheckTransferRequest checkTransferRequest = createMockCheckRequest();

    transferData.setCheckTransferRequest(StrUtil.OBJECT_MAPPER.writeValueAsString(checkTransferRequest));
    transferData.setCheckDate(new Date());

    transferDataDao.setCheckTransferRequest(id, transferData.getCheckTransferRequest(), transferData.getCheckDate());

    final TransferData found = transferDataDao.findByInvoiceId(initiateTransferResponse.getInvoiceId());

    Assert.assertEquals(id, found.getId());
    Assert.assertEquals(transferData.getInitiateDate(), found.getInitiateDate());
    Assert.assertEquals(initiateTransferRequest, StrUtil.OBJECT_MAPPER.readValue(found.getInitiateTransferRequest(), InitiateTransferRequest.class));
    Assert.assertEquals(transferData.getInvoiceId(), found.getInvoiceId());
    Assert.assertEquals(initiateTransferResponse, StrUtil.OBJECT_MAPPER.readValue(found.getInitiateTransferResponse(), InitiateTransferResponse.class));
    Assert.assertEquals(transferData.getCheckDate(), found.getCheckDate());
    Assert.assertEquals(checkTransferRequest, StrUtil.OBJECT_MAPPER.readValue(found.getCheckTransferRequest(), CheckTransferRequest.class));
    Assert.assertNull(found.getCheckTransferResponse());
    Assert.assertFalse(found.isInitiateError());
    Assert.assertNull(found.isCheckError());
  }

  @Test
  public void testAddCheckResponse() throws IOException {
    final TransferData transferData = new TransferData();

    final InitiateTransferRequest initiateTransferRequest = createMockInitiateRequest();
    transferData.setInitiateTransferRequest(StrUtil.OBJECT_MAPPER.writeValueAsString(initiateTransferRequest));
    transferData.setInitiateDate(new Date());
    transferData.setInvoiceId("someUuid");

    final long id = transferDataDao.create(transferData);

    final InitiateTransferResponse initiateTransferResponse = createMockInitiateResponse("someUuid");
    transferData.setInitiateTransferResponse(StrUtil.OBJECT_MAPPER.writeValueAsString(initiateTransferResponse));
    transferData.setInvoiceId(initiateTransferResponse.getInvoiceId());
    transferData.setInitiateError(false);

    transferDataDao.setInitiateTransferResponse(id, transferData.getInitiateTransferResponse(), false);

    final CheckTransferRequest checkTransferRequest = createMockCheckRequest();
    transferData.setCheckTransferRequest(StrUtil.OBJECT_MAPPER.writeValueAsString(checkTransferRequest));
    transferData.setCheckDate(new Date());

    transferDataDao.setCheckTransferRequest(id, transferData.getCheckTransferRequest(), transferData.getCheckDate());

    final CheckTransferResponse checkTransferResponse = createMockCheckResponse(transferData.getInvoiceId());
    transferData.setCheckTransferResponse(StrUtil.OBJECT_MAPPER.writeValueAsString(checkTransferResponse));

    transferDataDao.setCheckTransferResponse(id, transferData.getCheckTransferResponse(), false);

    final TransferData found = transferDataDao.findByInvoiceId(initiateTransferResponse.getInvoiceId());

    Assert.assertEquals(id, found.getId());
    Assert.assertEquals(transferData.getInitiateDate(), found.getInitiateDate());
    Assert.assertEquals(initiateTransferRequest, StrUtil.OBJECT_MAPPER.readValue(found.getInitiateTransferRequest(), InitiateTransferRequest.class));
    Assert.assertEquals(transferData.getInvoiceId(), found.getInvoiceId());
    Assert.assertEquals(initiateTransferResponse, StrUtil.OBJECT_MAPPER.readValue(found.getInitiateTransferResponse(), InitiateTransferResponse.class));
    Assert.assertEquals(transferData.getCheckDate(), found.getCheckDate());
    Assert.assertEquals(checkTransferRequest, StrUtil.OBJECT_MAPPER.readValue(found.getCheckTransferRequest(), CheckTransferRequest.class));
    Assert.assertEquals(checkTransferResponse, StrUtil.OBJECT_MAPPER.readValue(found.getCheckTransferResponse(), CheckTransferResponse.class));
    Assert.assertFalse(found.isInitiateError());
    Assert.assertFalse(found.isCheckError());
  }
}
