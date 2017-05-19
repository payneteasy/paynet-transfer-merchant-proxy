package com.payneteasy.merchantproxy.controller;

import com.payneteasy.merchantproxy.generated.model.CheckTransferRequest;
import com.payneteasy.merchantproxy.generated.model.CheckTransferResponse;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequest;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponse;
import com.payneteasy.merchantproxy.generated.model.RatesRequest;
import com.payneteasy.merchantproxy.generated.model.RatesRequestConsumer;
import com.payneteasy.merchantproxy.generated.model.RatesRequestConsumerDevice;
import com.payneteasy.merchantproxy.generated.model.RatesRequestSession;
import com.payneteasy.merchantproxy.service.TransactionService;
import com.payneteasy.merchantproxy.util.CacheUtil;
import com.payneteasy.merchantproxy.util.StrUtil;
import com.payneteasy.merchantproxy.util.TestUtils;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class TransferControllerTest extends BaseControllerTest {

  @Value("${paynet.rate}")
  private double rate;

  @Value("${paynet.rateMin}")
  private double rateMin;

  @Value("${paynet.limitMin}")
  private double limitMin;

  @Value("${paynet.limitMax}")
  private double limitMax;

  @Autowired
  private TransactionService transactionServiceMock;

  @Test
  public void testGetRate() throws Exception {
    final RatesRequestSession ratesRequestSession = new RatesRequestSession();
    ratesRequestSession.setAccessToken("abcd");

    final RatesRequestConsumerDevice ratesRequestConsumerDevice = new RatesRequestConsumerDevice();
    ratesRequestConsumerDevice.setSerialNumber("12345abcd");

    final RatesRequestConsumer ratesRequestConsumer = new RatesRequestConsumer();
    ratesRequestConsumer.setDevice(ratesRequestConsumerDevice);

    final RatesRequest ratesRequest = new RatesRequest();
    ratesRequest.setSession(ratesRequestSession);
    ratesRequest.setConsumer(ratesRequestConsumer);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(ratesRequest);

    mockMvc.perform(post("/transfer/get-rate").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.rateInterest").isNumber())
        .andExpect(jsonPath("$.rateInterest").value(rate))
        .andExpect(jsonPath("$.rateMin").isNumber())
        .andExpect(jsonPath("$.rateMin").value(rateMin))
        .andExpect(jsonPath("$.limitMin").isNumber())
        .andExpect(jsonPath("$.limitMin").value(limitMin))
        .andExpect(jsonPath("$.limitMax").isNumber())
        .andExpect(jsonPath("$.limitMax").value(limitMax))
    ;
  }

  @Test
  public void testGetRateNoAccessToken() throws Exception {
    final RatesRequestSession ratesRequestSession = new RatesRequestSession();
    ratesRequestSession.setAccessToken(null);

    final RatesRequestConsumerDevice ratesRequestConsumerDevice = new RatesRequestConsumerDevice();
    ratesRequestConsumerDevice.setSerialNumber("12345abcd");

    final RatesRequestConsumer ratesRequestConsumer = new RatesRequestConsumer();
    ratesRequestConsumer.setDevice(ratesRequestConsumerDevice);

    final RatesRequest ratesRequest = new RatesRequest();
    ratesRequest.setSession(ratesRequestSession);
    ratesRequest.setConsumer(ratesRequestConsumer);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(ratesRequest);

    mockMvc.perform(post("/transfer/get-rate").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testGetRateNoSession() throws Exception {

    final RatesRequestConsumerDevice ratesRequestConsumerDevice = new RatesRequestConsumerDevice();
    ratesRequestConsumerDevice.setSerialNumber("12345abcd");

    final RatesRequestConsumer ratesRequestConsumer = new RatesRequestConsumer();
    ratesRequestConsumer.setDevice(ratesRequestConsumerDevice);

    final RatesRequest ratesRequest = new RatesRequest();
    ratesRequest.setSession(null);
    ratesRequest.setConsumer(ratesRequestConsumer);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(ratesRequest);

    mockMvc.perform(post("/transfer/get-rate").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testGetRateNoSerialNumber() throws Exception {
    final RatesRequestSession ratesRequestSession = new RatesRequestSession();
    ratesRequestSession.setAccessToken("abcd");

    final RatesRequestConsumerDevice ratesRequestConsumerDevice = new RatesRequestConsumerDevice();
    ratesRequestConsumerDevice.setSerialNumber(null);

    final RatesRequestConsumer ratesRequestConsumer = new RatesRequestConsumer();
    ratesRequestConsumer.setDevice(ratesRequestConsumerDevice);

    final RatesRequest ratesRequest = new RatesRequest();
    ratesRequest.setSession(ratesRequestSession);
    ratesRequest.setConsumer(ratesRequestConsumer);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(ratesRequest);

    mockMvc.perform(post("/transfer/get-rate").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testGetRateNoDevice() throws Exception {
    final RatesRequestSession ratesRequestSession = new RatesRequestSession();
    ratesRequestSession.setAccessToken("abcd");

    final RatesRequestConsumer ratesRequestConsumer = new RatesRequestConsumer();
    ratesRequestConsumer.setDevice(null);

    final RatesRequest ratesRequest = new RatesRequest();
    ratesRequest.setSession(ratesRequestSession);
    ratesRequest.setConsumer(ratesRequestConsumer);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(ratesRequest);

    mockMvc.perform(post("/transfer/get-rate").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testGetRateNoConsumer() throws Exception {
    final RatesRequestSession ratesRequestSession = new RatesRequestSession();
    ratesRequestSession.setAccessToken("abcd");

    final RatesRequestConsumerDevice ratesRequestConsumerDevice = new RatesRequestConsumerDevice();
    ratesRequestConsumerDevice.setSerialNumber("12345abcd");

    final RatesRequest ratesRequest = new RatesRequest();
    ratesRequest.setSession(ratesRequestSession);
    ratesRequest.setConsumer(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(ratesRequest);

    mockMvc.perform(post("/transfer/get-rate").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testInitiateTransfer() throws Exception {

    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(initiateTransferRequest);

    expect(transactionServiceMock.initiateTransaction(initiateTransferRequest))
        .andReturn(INITIATE_TRANSFER_MOCK_RESPONSE).once();

    replay(transactionServiceMock);

    mockMvc.perform(post("/transfer/initiate-transfer").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.endpointId").isString())
        .andExpect(jsonPath("$.endpointId").value(INITIATE_TRANSFER_MOCK_RESPONSE.getEndpointId()))
        .andExpect(jsonPath("$.rates").isMap())
        .andExpect(jsonPath("$.rates.min").isString())
        .andExpect(jsonPath("$.rates.min").value(INITIATE_TRANSFER_MOCK_RESPONSE.getRates().getMin()))
        .andExpect(jsonPath("$.rates.max").isString())
        .andExpect(jsonPath("$.rates.max").value(INITIATE_TRANSFER_MOCK_RESPONSE.getRates().getMax()))
        .andExpect(jsonPath("$.session").isMap())
        .andExpect(jsonPath("$.session.nonce").isString())
        .andExpect(jsonPath("$.session.nonce").value(INITIATE_TRANSFER_MOCK_RESPONSE.getSession().getNonce()))
        .andExpect(jsonPath("$.session.signature").isString())
        .andExpect(jsonPath("$.session.signature").value(INITIATE_TRANSFER_MOCK_RESPONSE.getSession().getSignature()))
    ;

    verify(transactionServiceMock);

    reset(transactionServiceMock);
  }

  @Test
  public void testInitiateTransferNoSerialNumber() throws Exception {

    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    initiateTransferRequest.getConsumer().getDevice().setSerialNumber(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(initiateTransferRequest);

    mockMvc.perform(post("/transfer/initiate-transfer").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testInitiateTransferNoDevice() throws Exception {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    initiateTransferRequest.getConsumer().setDevice(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(initiateTransferRequest);

    mockMvc.perform(post("/transfer/initiate-transfer").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testInitiateTransferNoConsumer() throws Exception {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    initiateTransferRequest.setConsumer(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(initiateTransferRequest);

    mockMvc.perform(post("/transfer/initiate-transfer").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testInitiateTransferNoAccessToken() throws Exception {

    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    initiateTransferRequest.getSession().setAccessToken(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(initiateTransferRequest);

    mockMvc.perform(post("/transfer/initiate-transfer").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testInitiateTransferNoAmount() throws Exception {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    initiateTransferRequest.getTransaction().setAmountCentis(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(initiateTransferRequest);

    mockMvc.perform(post("/transfer/initiate-transfer").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testInitiateTransferNoCurrency() throws Exception {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    initiateTransferRequest.getTransaction().setCurrency(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(initiateTransferRequest);

    mockMvc.perform(post("/transfer/initiate-transfer").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testInitiateTransferInvalidCurrency() throws Exception {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    initiateTransferRequest.getTransaction().setCurrency("RU1");

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(initiateTransferRequest);

    mockMvc.perform(post("/transfer/initiate-transfer").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testInitiateTransferNoTransaction() throws Exception {
    final InitiateTransferRequest initiateTransferRequest = TestUtils.createMockInitiateRequest();
    initiateTransferRequest.setTransaction(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(initiateTransferRequest);

    mockMvc.perform(post("/transfer/initiate-transfer").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testCheckTransfer() throws Exception {
    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();

    expect(transactionServiceMock.checkTransfer("someUuid", checkTransferRequest))
        .andReturn(CHECK_TRANSFER_MOCK_RESPONSE)
        .once();

    replay(transactionServiceMock);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(checkTransferRequest);

    mockMvc.perform(post("/transfer/someUuid/check").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.session").isMap())
        .andExpect(jsonPath("$.session.checkSignature").isString())
        .andExpect(jsonPath("$.session.checkSignature").value(CHECK_TRANSFER_MOCK_RESPONSE.getSession().getCheckSignature()))
        .andExpect(jsonPath("$.session.nonce").isString())
        .andExpect(jsonPath("$.session.nonce").value(CHECK_TRANSFER_MOCK_RESPONSE.getSession().getNonce()))
        .andExpect(jsonPath("$.session.token").isString())
        .andExpect(jsonPath("$.session.token").value(CHECK_TRANSFER_MOCK_RESPONSE.getSession().getToken()))
        .andExpect(jsonPath("$.invoiceId").isString())
        .andExpect(jsonPath("$.invoiceId").value(CHECK_TRANSFER_MOCK_RESPONSE.getInvoiceId()))
    ;

    verify(transactionServiceMock);

    reset(transactionServiceMock);
  }

  @Test
  public void testCheckTransferNoSerialNumber() throws Exception {
    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    checkTransferRequest.getConsumer().getDevice().setSerialNumber(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(checkTransferRequest);

    mockMvc.perform(post("/transfer/someUuid/check").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testCheckTransferNoDevice() throws Exception {
    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    checkTransferRequest.getConsumer().setDevice(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(checkTransferRequest);

    mockMvc.perform(post("/transfer/someUuid/check").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testCheckTransferNoConsumer() throws Exception {
    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    checkTransferRequest.setConsumer(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(checkTransferRequest);

    mockMvc.perform(post("/transfer/someUuid/check").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testCheckTransferNoAccessToken() throws Exception {
    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    checkTransferRequest.getSession().setAccessToken(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(checkTransferRequest);

    mockMvc.perform(post("/transfer/someUuid/check").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testCheckTransferNoNonce() throws Exception {
    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    checkTransferRequest.getSession().setNonce(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(checkTransferRequest);

    mockMvc.perform(post("/transfer/someUuid/check").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testCheckTransferNoSignature() throws Exception {
    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    checkTransferRequest.getSession().setSignature(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(checkTransferRequest);

    mockMvc.perform(post("/transfer/someUuid/check").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testCheckTransferNoToken() throws Exception {
    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    checkTransferRequest.getSession().setToken(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(checkTransferRequest);

    mockMvc.perform(post("/transfer/someUuid/check").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  @Test
  public void testCheckTransferNoSession() throws Exception {
    final CheckTransferRequest checkTransferRequest = TestUtils.createMockCheckRequest();
    checkTransferRequest.setSession(null);

    final byte[] content = StrUtil.OBJECT_MAPPER.writeValueAsBytes(checkTransferRequest);

    mockMvc.perform(post("/transfer/someUuid/check").content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").isMap())
        .andExpect(jsonPath("$.error.cause").isString())
        .andExpect(jsonPath("$.error.cause").value("INVALID_REQUEST"))
    ;
  }

  private static final InitiateTransferResponse INITIATE_TRANSFER_MOCK_RESPONSE = TestUtils.createMockInitiateResponse("someUuid");

  private static final CheckTransferResponse CHECK_TRANSFER_MOCK_RESPONSE = TestUtils.createMockCheckResponse("someUuid");
}
