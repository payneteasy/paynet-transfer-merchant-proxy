package com.payneteasy.merchantproxy.util;

import com.payneteasy.merchantproxy.generated.model.*;

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
    final CheckRequestConsumerDevice checkRequestConsumerDevice = new CheckRequestConsumerDevice();
    checkRequestConsumerDevice.setSerialNumber("abcd");

    final RequestConsumer requestConsumer = new RequestConsumer();
    requestConsumer.setDevice(checkRequestConsumerDevice);

    final CheckTransferRequestSession checkTransferRequestSession = new CheckTransferRequestSession();
    checkTransferRequestSession.setAccessToken("123456789012345678901234567890123456789012345678901234567890abcd");
    checkTransferRequestSession.setNonce("5678xyz");
    checkTransferRequestSession.setSignature("1234abcd");
    checkTransferRequestSession.setToken("qwerty");

    final CheckTransferRequest checkTransferRequest = new CheckTransferRequest();
    checkTransferRequest.setSession(checkTransferRequestSession);
    checkTransferRequest.setConsumer(requestConsumer);

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

  public static NotificationResponse createMockNotificationResponse(final String invoiceId) {
    final NotificationResponse notificationResponse = new NotificationResponse();

    final NotificationResponseSession notificationResponseSession = new NotificationResponseSession();
    notificationResponseSession.setCheckSignature("abcd1234xyz");
    notificationResponseSession.setNonce("5678xyz");
    notificationResponseSession.setToken("qwerty");

    notificationResponse.setSession(notificationResponseSession);
    notificationResponse.setInvoiceId(invoiceId);

    return notificationResponse;
  }

  public static NotificationRequest createMockNotificationRequest() {
    final CheckRequestConsumerDevice checkRequestConsumerDevice = new CheckRequestConsumerDevice();
    checkRequestConsumerDevice.setSerialNumber("abcd");

    final RequestConsumer requestConsumer = new RequestConsumer();
    requestConsumer.setDevice(checkRequestConsumerDevice);

    final NotificationRequestSession session = new NotificationRequestSession();
    session.setAccessToken("123456789012345678901234567890123456789012345678901234567890abcd");
    session.setToken("qwerty");

    final NotificationRequest request = new NotificationRequest();
    request.setSession(session);
    request.setConsumer(requestConsumer);

    return request;
  }

}
