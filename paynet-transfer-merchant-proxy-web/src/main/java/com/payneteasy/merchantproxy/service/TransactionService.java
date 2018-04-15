package com.payneteasy.merchantproxy.service;


import com.payneteasy.merchantproxy.generated.model.*;

import java.math.BigDecimal;
import java.security.GeneralSecurityException;

public interface TransactionService {
  BigDecimal calcRate(long amountCentis, String fromBin, String toBin);
  BigDecimal calcRate(long amountCentis);
  InitiateTransferResponse initiateTransaction(InitiateTransferRequest request);
  CheckTransferResponse checkTransfer(String invoiceId, CheckTransferRequest request) throws GeneralSecurityException;
  NotificationResponse notificationStart(String invoiceId, NotificationRequest request);
}
