package com.payneteasy.merchantproxy.util;

import com.payneteasy.merchantproxy.generated.model.AccessTokenResponseSession;
import com.payneteasy.merchantproxy.generated.model.CheckTransferRequest;
import com.payneteasy.merchantproxy.generated.model.CheckTransferRequestConsumer;
import com.payneteasy.merchantproxy.generated.model.CheckTransferRequestConsumerDevice;
import com.payneteasy.merchantproxy.generated.model.CheckTransferRequestSession;
import com.payneteasy.merchantproxy.generated.model.CheckTransferResponse;
import com.payneteasy.merchantproxy.generated.model.CheckTransferResponseSession;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequest;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequestConsumer;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequestConsumerDevice;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequestTransaction;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponse;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponseRates;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponseSession;

import java.util.UUID;

public class TestUtils {

  private TestUtils() {
  }

  public static InitiateTransferRequest createMockInitiateRequest() {
    final InitiateTransferRequestConsumerDevice initiateTransferRequestConsumerDevice = new InitiateTransferRequestConsumerDevice();
    initiateTransferRequestConsumerDevice.setSerialNumber("abcd");

    final InitiateTransferRequestConsumer initiateTransferRequestConsumer = new InitiateTransferRequestConsumer();
    initiateTransferRequestConsumer.setDevice(initiateTransferRequestConsumerDevice);

    final AccessTokenResponseSession initiateTransferRequestSession = new AccessTokenResponseSession();
    final String accessToken = "123456789012345678901234567890123456789012345678901234567890abcd";
    initiateTransferRequestSession.setAccessToken(accessToken);

    final InitiateTransferRequestTransaction initiateTransferRequestTransaction = new InitiateTransferRequestTransaction();
    initiateTransferRequestTransaction.setAmountCentis(1000L);
    initiateTransferRequestTransaction.setCurrency("RUB");

    final InitiateTransferRequest initiateTransferRequest = new InitiateTransferRequest();
    initiateTransferRequest.setConsumer(initiateTransferRequestConsumer);
    initiateTransferRequest.setSession(initiateTransferRequestSession);
    initiateTransferRequest.setTransaction(initiateTransferRequestTransaction);

    return initiateTransferRequest;
  }

  public static CheckTransferRequest createMockCheckRequest() {
    final CheckTransferRequestConsumerDevice checkTransferRequestConsumerDevice = new CheckTransferRequestConsumerDevice();
    checkTransferRequestConsumerDevice.setSerialNumber("abcd");

    final CheckTransferRequestConsumer checkTransferRequestConsumer = new CheckTransferRequestConsumer();
    checkTransferRequestConsumer.setDevice(checkTransferRequestConsumerDevice);

    final CheckTransferRequestSession checkTransferRequestSession = new CheckTransferRequestSession();
    checkTransferRequestSession.setAccessToken("123456789012345678901234567890123456789012345678901234567890abcd");
    checkTransferRequestSession.setNonce("5678xyz");
    checkTransferRequestSession.setSignature("1234abcd");
    checkTransferRequestSession.setToken("qwerty");

    final CheckTransferRequest checkTransferRequest = new CheckTransferRequest();
    checkTransferRequest.setSession(checkTransferRequestSession);
    checkTransferRequest.setConsumer(checkTransferRequestConsumer);

    return checkTransferRequest;
  }

  public static InitiateTransferResponse createMockInitiateResponse(final String invoiceId) {
    final InitiateTransferResponse initiateTransferResponse = new InitiateTransferResponse();

    final InitiateTransferResponseSession initiateTransferResponseSession = new InitiateTransferResponseSession();
    initiateTransferResponseSession.setSignature("1234abcd");
    initiateTransferResponseSession.setNonce("5678xyz");

    final InitiateTransferResponseRates initiateTransferResponseRates = new InitiateTransferResponseRates();
    initiateTransferResponseRates.setMin("39");
    initiateTransferResponseRates.setMax("39");

    initiateTransferResponse.setSession(initiateTransferResponseSession);
    initiateTransferResponse.setEndpointId("1234");
    initiateTransferResponse.setInvoiceId(invoiceId);
    initiateTransferResponse.setRates(initiateTransferResponseRates);

    return initiateTransferResponse;
  }

  public static CheckTransferResponse createMockCheckResponse(final String invoiceId) {
    final CheckTransferResponse checkTransferResponse = new CheckTransferResponse();

    final CheckTransferResponseSession checkTransferResponseSession = new CheckTransferResponseSession();
    checkTransferResponseSession.setCheckSignature("abcd1234xyz");
    checkTransferResponseSession.setNonce("5678xyz");
    checkTransferResponseSession.setToken("qwerty");

    checkTransferResponse.setSession(checkTransferResponseSession);
    checkTransferResponse.setInvoiceId(invoiceId);

    return checkTransferResponse;
  }
}
