package com.payneteasy.merchantproxy.dao;

import com.payneteasy.merchantproxy.model.TransferData;

import java.util.Date;

public interface TransferDataDao {

  long create(TransferData transferData);

  void setInitiateTransferResponse(long id, String initiateTransferResponse, boolean isError);

  void setCheckTransferRequest(long id, String checkTransferRequest, Date date);

  void setCheckTransferResponse(long id, String checkTransferResponse, boolean isError);

  TransferData findById(long id);

  TransferData findByInvoiceId(String invoiceId);
}
