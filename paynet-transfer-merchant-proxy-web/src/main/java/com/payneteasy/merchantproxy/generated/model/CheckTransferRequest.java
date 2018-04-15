package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;
/**
 * CheckTransferRequest
 */

public class CheckTransferRequest   {
  @JsonProperty("consumer")
  @Valid
  @NotNull
  private RequestConsumer consumer = null;

  @JsonProperty("session")
  @Valid
  @NotNull
  private CheckTransferRequestSession session = null;

  @JsonProperty("sourceOfFunds")
  @Valid
  private CheckTransferRequestSourceOfFunds sourceOfFunds = null;

  @JsonProperty("destinationOfFunds")
  @Valid
  private CheckTransferRequestDestinationOfFunds destinationOfFunds = null;

  public CheckTransferRequest consumer(RequestConsumer consumer) {
    this.consumer = consumer;
    return this;
  }

   /**
   * Get consumer
   * @return consumer
  **/
  @ApiModelProperty(value = "")
  public RequestConsumer getConsumer() {
    return consumer;
  }

  public void setConsumer(RequestConsumer consumer) {
    this.consumer = consumer;
  }

  public CheckTransferRequest session(CheckTransferRequestSession session) {
    this.session = session;
    return this;
  }

   /**
   * Get session
   * @return session
  **/
  @ApiModelProperty(value = "")
  public CheckTransferRequestSession getSession() {
    return session;
  }

  public void setSession(CheckTransferRequestSession session) {
    this.session = session;
  }

  public CheckTransferRequest sourceOfFunds(CheckTransferRequestSourceOfFunds sourceOfFunds) {
    this.sourceOfFunds = sourceOfFunds;
    return this;
  }

   /**
   * Get sourceOfFunds
   * @return sourceOfFunds
  **/
  @ApiModelProperty(value = "")
  public CheckTransferRequestSourceOfFunds getSourceOfFunds() {
    return sourceOfFunds;
  }

  public void setSourceOfFunds(CheckTransferRequestSourceOfFunds sourceOfFunds) {
    this.sourceOfFunds = sourceOfFunds;
  }

  public CheckTransferRequest destinationOfFunds(CheckTransferRequestDestinationOfFunds destinationOfFunds) {
    this.destinationOfFunds = destinationOfFunds;
    return this;
  }

   /**
   * Get destinationOfFunds
   * @return destinationOfFunds
  **/
  @ApiModelProperty(value = "")
  public CheckTransferRequestDestinationOfFunds getDestinationOfFunds() {
    return destinationOfFunds;
  }

  public void setDestinationOfFunds(CheckTransferRequestDestinationOfFunds destinationOfFunds) {
    this.destinationOfFunds = destinationOfFunds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckTransferRequest checkTransferRequest = (CheckTransferRequest) o;
    return Objects.equals(this.consumer, checkTransferRequest.consumer) &&
        Objects.equals(this.session, checkTransferRequest.session) &&
        Objects.equals(this.sourceOfFunds, checkTransferRequest.sourceOfFunds) &&
        Objects.equals(this.destinationOfFunds, checkTransferRequest.destinationOfFunds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumer, session, sourceOfFunds, destinationOfFunds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferRequest {\n");
    
    sb.append("    consumer: ").append(toIndentedString(consumer)).append("\n");
    sb.append("    session: ").append(toIndentedString(session)).append("\n");
    sb.append("    sourceOfFunds: ").append(toIndentedString(sourceOfFunds)).append("\n");
    sb.append("    destinationOfFunds: ").append(toIndentedString(destinationOfFunds)).append("\n");
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

