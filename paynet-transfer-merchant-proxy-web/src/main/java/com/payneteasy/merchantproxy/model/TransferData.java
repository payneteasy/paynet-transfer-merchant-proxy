package com.payneteasy.merchantproxy.model;

import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class TransferData {

  private long id;
  private String invoiceId;
  private Date initiateDate;
  private Date checkDate;
  private String initiateTransferRequest;
  private String initiateTransferResponse;
  private String checkTransferRequest;
  private String checkTransferResponse;
  private Boolean isInitiateError;
  private Boolean isCheckError;

  public static final String QUERY = "select ID, INVOICE_ID, INITIATE_DATE, CHECK_DATE, INITIATE_TRANSFER_REQUEST, INITIATE_TRANSFER_RESPONSE, " +
      " CHECK_TRANSFER_REQUEST, CHECK_TRANSFER_RESPONSE, IS_INITIATE_ERROR, IS_CHECK_ERROR from TRANSFERDATA";

  public static RowMapper<TransferData> getRowMapper() {
    return ROW_MAPPER;
  }

  private static final RowMapper<TransferData> ROW_MAPPER = ((rs, rowNum) -> {
    final TransferData transferData = new TransferData();
    transferData.setId(rs.getLong(1));
    transferData.setInvoiceId(rs.getString(2));
    transferData.setInitiateDate(rs.getTimestamp(3));
    transferData.setCheckDate(rs.getTimestamp(4));
    transferData.setInitiateTransferRequest(rs.getString(5));
    transferData.setInitiateTransferResponse(rs.getString(6));
    transferData.setCheckTransferRequest(rs.getString(7));
    transferData.setCheckTransferResponse(rs.getString(8));
    final boolean resInitiateError = rs.getBoolean(9);
    if (rs.wasNull()) {
      transferData.setInitiateError(null);
    } else {
      transferData.setInitiateError(resInitiateError);
    }
    final boolean resCheckError = rs.getBoolean(10);
    if (rs.wasNull()) {
      transferData.setCheckError(null);
    } else {
      transferData.setCheckError(resCheckError);
    }

    return transferData;
  });

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
  }

  public Date getInitiateDate() {
    return initiateDate;
  }

  public void setInitiateDate(Date initiateDate) {
    this.initiateDate = initiateDate;
  }

  public Date getCheckDate() {
    return checkDate;
  }

  public void setCheckDate(Date checkDate) {
    this.checkDate = checkDate;
  }

  public String getInitiateTransferRequest() {
    return initiateTransferRequest;
  }

  public void setInitiateTransferRequest(String initiateTransferRequest) {
    this.initiateTransferRequest = initiateTransferRequest;
  }

  public String getInitiateTransferResponse() {
    return initiateTransferResponse;
  }

  public void setInitiateTransferResponse(String initiateTransferResponse) {
    this.initiateTransferResponse = initiateTransferResponse;
  }

  public String getCheckTransferRequest() {
    return checkTransferRequest;
  }

  public void setCheckTransferRequest(String checkTransferRequest) {
    this.checkTransferRequest = checkTransferRequest;
  }

  public String getCheckTransferResponse() {
    return checkTransferResponse;
  }

  public void setCheckTransferResponse(String checkTransferResponse) {
    this.checkTransferResponse = checkTransferResponse;
  }

  public Boolean isInitiateError() {
    return isInitiateError;
  }

  public void setInitiateError(Boolean initiateError) {
    isInitiateError = initiateError;
  }

  public Boolean isCheckError() {
    return isCheckError;
  }

  public void setCheckError(Boolean checkError) {
    isCheckError = checkError;
  }
}
