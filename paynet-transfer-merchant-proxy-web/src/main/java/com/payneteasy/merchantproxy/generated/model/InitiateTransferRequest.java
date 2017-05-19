package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * InitiateTransferRequest
 */

public class InitiateTransferRequest   {
  @JsonProperty("consumer")
  @Valid
  @NotNull
  private InitiateTransferRequestConsumer consumer = null;

  @JsonProperty("location")
  @Valid
  private InitiateTransferRequestLocation location = null;

  @JsonProperty("session")
  @Valid
  private AccessTokenResponseSession session = null;

  @JsonProperty("transaction")
  @Valid
  @NotNull
  private InitiateTransferRequestTransaction transaction = null;

  public InitiateTransferRequest consumer(InitiateTransferRequestConsumer consumer) {
    this.consumer = consumer;
    return this;
  }

   /**
   * Get consumer
   * @return consumer
  **/
  @ApiModelProperty(value = "")
  public InitiateTransferRequestConsumer getConsumer() {
    return consumer;
  }

  public void setConsumer(InitiateTransferRequestConsumer consumer) {
    this.consumer = consumer;
  }

  public InitiateTransferRequest location(InitiateTransferRequestLocation location) {
    this.location = location;
    return this;
  }

   /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")
  public InitiateTransferRequestLocation getLocation() {
    return location;
  }

  public void setLocation(InitiateTransferRequestLocation location) {
    this.location = location;
  }

  public InitiateTransferRequest session(AccessTokenResponseSession session) {
    this.session = session;
    return this;
  }

   /**
   * Get session
   * @return session
  **/
  @ApiModelProperty(value = "")
  public AccessTokenResponseSession getSession() {
    return session;
  }

  public void setSession(AccessTokenResponseSession session) {
    this.session = session;
  }

  public InitiateTransferRequest transaction(InitiateTransferRequestTransaction transaction) {
    this.transaction = transaction;
    return this;
  }

   /**
   * Get transaction
   * @return transaction
  **/
  @ApiModelProperty(value = "")
  public InitiateTransferRequestTransaction getTransaction() {
    return transaction;
  }

  public void setTransaction(InitiateTransferRequestTransaction transaction) {
    this.transaction = transaction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitiateTransferRequest initiateTransferRequest = (InitiateTransferRequest) o;
    return Objects.equals(this.consumer, initiateTransferRequest.consumer) &&
        Objects.equals(this.location, initiateTransferRequest.location) &&
        Objects.equals(this.session, initiateTransferRequest.session) &&
        Objects.equals(this.transaction, initiateTransferRequest.transaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumer, location, session, transaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiateTransferRequest {\n");

    sb.append("    consumer: ").append(toIndentedString(consumer)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    session: ").append(toIndentedString(session)).append("\n");
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

