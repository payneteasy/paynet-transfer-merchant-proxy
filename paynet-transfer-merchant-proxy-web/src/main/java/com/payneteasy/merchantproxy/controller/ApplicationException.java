package com.payneteasy.merchantproxy.controller;

public class ApplicationException extends RuntimeException {

  public enum RequestType { TRANSFER_INITIATE, TRANSFER_CHECK, TRANSFER_NOTIFICATION }

  private final Long id;
  private final RequestType requestType;


  public ApplicationException(final Throwable cause, final Long id, final RequestType requestType) {
    super(cause);
    this.id = id;
    this.requestType = requestType;
  }

  public Long getId() {
    return id;
  }

  public RequestType getRequestType() {
    return requestType;
  }
}
