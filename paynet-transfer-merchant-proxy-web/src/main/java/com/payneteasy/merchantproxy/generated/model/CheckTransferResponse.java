package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CheckTransferResponse
 */

public class CheckTransferResponse   {
  @JsonProperty("consumer")
  private CheckTransferResponseConsumer consumer = null;

  @JsonProperty("destinationOfFunds")
  private CheckTransferResponseDestinationOfFunds destinationOfFunds = null;

  @JsonProperty("invoiceId")
  private String invoiceId = null;

  @JsonProperty("session")
  private CheckTransferResponseSession session = null;

  @JsonProperty("sourceOfFunds")
  private CheckTransferResponseSourceOfFunds sourceOfFunds = null;

  public CheckTransferResponse consumer(CheckTransferResponseConsumer consumer) {
    this.consumer = consumer;
    return this;
  }

   /**
   * Get consumer
   * @return consumer
  **/
  @ApiModelProperty(value = "")
  public CheckTransferResponseConsumer getConsumer() {
    return consumer;
  }

  public void setConsumer(CheckTransferResponseConsumer consumer) {
    this.consumer = consumer;
  }

  public CheckTransferResponse destinationOfFunds(CheckTransferResponseDestinationOfFunds destinationOfFunds) {
    this.destinationOfFunds = destinationOfFunds;
    return this;
  }

   /**
   * Get destinationOfFunds
   * @return destinationOfFunds
  **/
  @ApiModelProperty(value = "")
  public CheckTransferResponseDestinationOfFunds getDestinationOfFunds() {
    return destinationOfFunds;
  }

  public void setDestinationOfFunds(CheckTransferResponseDestinationOfFunds destinationOfFunds) {
    this.destinationOfFunds = destinationOfFunds;
  }

  public CheckTransferResponse invoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
    return this;
  }

   /**
   * Transfer transaction identifier
   * @return invoiceId
  **/
  @ApiModelProperty(value = "Transfer transaction identifier")
  public String getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
  }

  public CheckTransferResponse session(CheckTransferResponseSession session) {
    this.session = session;
    return this;
  }

   /**
   * Get session
   * @return session
  **/
  @ApiModelProperty(value = "")
  public CheckTransferResponseSession getSession() {
    return session;
  }

  public void setSession(CheckTransferResponseSession session) {
    this.session = session;
  }

  public CheckTransferResponse sourceOfFunds(CheckTransferResponseSourceOfFunds sourceOfFunds) {
    this.sourceOfFunds = sourceOfFunds;
    return this;
  }

   /**
   * Get sourceOfFunds
   * @return sourceOfFunds
  **/
  @ApiModelProperty(value = "")
  public CheckTransferResponseSourceOfFunds getSourceOfFunds() {
    return sourceOfFunds;
  }

  public void setSourceOfFunds(CheckTransferResponseSourceOfFunds sourceOfFunds) {
    this.sourceOfFunds = sourceOfFunds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckTransferResponse checkTransferResponse = (CheckTransferResponse) o;
    return Objects.equals(this.consumer, checkTransferResponse.consumer) &&
        Objects.equals(this.destinationOfFunds, checkTransferResponse.destinationOfFunds) &&
        Objects.equals(this.invoiceId, checkTransferResponse.invoiceId) &&
        Objects.equals(this.session, checkTransferResponse.session) &&
        Objects.equals(this.sourceOfFunds, checkTransferResponse.sourceOfFunds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumer, destinationOfFunds, invoiceId, session, sourceOfFunds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferResponse {\n");
    
    sb.append("    consumer: ").append(toIndentedString(consumer)).append("\n");
    sb.append("    destinationOfFunds: ").append(toIndentedString(destinationOfFunds)).append("\n");
    sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
    sb.append("    session: ").append(toIndentedString(session)).append("\n");
    sb.append("    sourceOfFunds: ").append(toIndentedString(sourceOfFunds)).append("\n");
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

