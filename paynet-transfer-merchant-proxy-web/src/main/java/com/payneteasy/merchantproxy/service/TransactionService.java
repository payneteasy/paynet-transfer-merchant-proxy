package com.payneteasy.merchantproxy.service;


import com.payneteasy.merchantproxy.generated.model.CheckTransferRequest;
import com.payneteasy.merchantproxy.generated.model.CheckTransferResponse;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequest;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponse;

import java.math.BigDecimal;
import java.security.GeneralSecurityException;

public interface TransactionService {
  BigDecimal calcRate(long amountCentis, String fromBin, String toBin);
  BigDecimal calcRate(long amountCentis);
  InitiateTransferResponse initiateTransaction(InitiateTransferRequest request);
  CheckTransferResponse checkTransfer(String invoiceId, CheckTransferRequest request) throws GeneralSecurityException;
}
