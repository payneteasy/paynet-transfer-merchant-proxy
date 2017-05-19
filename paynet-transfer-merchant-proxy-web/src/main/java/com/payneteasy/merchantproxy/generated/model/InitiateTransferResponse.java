package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * InitiateTransferResponse
 */

public class InitiateTransferResponse   {
  @JsonProperty("endpointId")
  private String endpointId = null;

  @JsonProperty("invoiceId")
  private String invoiceId = null;

  @JsonProperty("rates")
  private InitiateTransferResponseRates rates = null;

  @JsonProperty("session")
  private InitiateTransferResponseSession session = null;

  public InitiateTransferResponse endpointId(String endpointId) {
    this.endpointId = endpointId;
    return this;
  }

   /**
   * Entry point identifier for transfer transaction
   * @return endpointId
  **/
  @ApiModelProperty(value = "Entry point identifier for transfer transaction")
  public String getEndpointId() {
    return endpointId;
  }

  public void setEndpointId(String endpointId) {
    this.endpointId = endpointId;
  }

  public InitiateTransferResponse invoiceId(String invoiceId) {
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

  public InitiateTransferResponse rates(InitiateTransferResponseRates rates) {
    this.rates = rates;
    return this;
  }

   /**
   * Get rates
   * @return rates
  **/
  @ApiModelProperty(value = "")
  public InitiateTransferResponseRates getRates() {
    return rates;
  }

  public void setRates(InitiateTransferResponseRates rates) {
    this.rates = rates;
  }

  public InitiateTransferResponse session(InitiateTransferResponseSession session) {
    this.session = session;
    return this;
  }

   /**
   * Get session
   * @return session
  **/
  @ApiModelProperty(value = "")
  public InitiateTransferResponseSession getSession() {
    return session;
  }

  public void setSession(InitiateTransferResponseSession session) {
    this.session = session;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitiateTransferResponse initiateTransferResponse = (InitiateTransferResponse) o;
    return Objects.equals(this.endpointId, initiateTransferResponse.endpointId) &&
        Objects.equals(this.invoiceId, initiateTransferResponse.invoiceId) &&
        Objects.equals(this.rates, initiateTransferResponse.rates) &&
        Objects.equals(this.session, initiateTransferResponse.session);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpointId, invoiceId, rates, session);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiateTransferResponse {\n");
    
    sb.append("    endpointId: ").append(toIndentedString(endpointId)).append("\n");
    sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
    sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
    sb.append("    session: ").append(toIndentedString(session)).append("\n");
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

