package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
/**
 * InitiateTransferRequestTransaction
 */

public class InitiateTransferRequestTransaction   {
  @JsonProperty("amountCentis")
  @NotNull
  @Min(1)
  private Long amountCentis = null;

  @JsonProperty("currency")
  @NotEmpty
  @Pattern(regexp = "^[A-Z]{3}$")
  private String currency = null;

  public InitiateTransferRequestTransaction amountCentis(Long amountCentis) {
    this.amountCentis = amountCentis;
    return this;
  }

   /**
   * Transaction amount, 1.00 EUR = 100 centis
   * @return amountCentis
  **/
  @ApiModelProperty(required = true, value = "Transaction amount, 1.00 EUR = 100 centis")
  public Long getAmountCentis() {
    return amountCentis;
  }

  public void setAmountCentis(Long amountCentis) {
    this.amountCentis = amountCentis;
  }

  public InitiateTransferRequestTransaction currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Transaction currency, upper case letters (ISO 4217 alpha code)
   * @return currency
  **/
  @ApiModelProperty(required = true, value = "Transaction currency, upper case letters (ISO 4217 alpha code)")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitiateTransferRequestTransaction initiateTransferRequestTransaction = (InitiateTransferRequestTransaction) o;
    return Objects.equals(this.amountCentis, initiateTransferRequestTransaction.amountCentis) &&
        Objects.equals(this.currency, initiateTransferRequestTransaction.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amountCentis, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiateTransferRequestTransaction {\n");
    
    sb.append("    amountCentis: ").append(toIndentedString(amountCentis)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
