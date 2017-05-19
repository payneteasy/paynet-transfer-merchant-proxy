package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CheckTransferResponseSourceOfFundsCard
 */

public class CheckTransferResponseSourceOfFundsCard   {
  @JsonProperty("expiry")
  private CheckTransferResponseSourceOfFundsCardExpiry expiry = null;

  @JsonProperty("holder")
  private CheckTransferResponseSourceOfFundsCardHolder holder = null;

  @JsonProperty("number")
  private String number = null;

  public CheckTransferResponseSourceOfFundsCard expiry(CheckTransferResponseSourceOfFundsCardExpiry expiry) {
    this.expiry = expiry;
    return this;
  }

   /**
   * Get expiry
   * @return expiry
  **/
  @ApiModelProperty(value = "")
  public CheckTransferResponseSourceOfFundsCardExpiry getExpiry() {
    return expiry;
  }

  public void setExpiry(CheckTransferResponseSourceOfFundsCardExpiry expiry) {
    this.expiry = expiry;
  }

  public CheckTransferResponseSourceOfFundsCard holder(CheckTransferResponseSourceOfFundsCardHolder holder) {
    this.holder = holder;
    return this;
  }

   /**
   * Get holder
   * @return holder
  **/
  @ApiModelProperty(value = "")
  public CheckTransferResponseSourceOfFundsCardHolder getHolder() {
    return holder;
  }

  public void setHolder(CheckTransferResponseSourceOfFundsCardHolder holder) {
    this.holder = holder;
  }

  public CheckTransferResponseSourceOfFundsCard number(String number) {
    this.number = number;
    return this;
  }

   /**
   * Get number
   * @return number
  **/
  @ApiModelProperty(value = "")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckTransferResponseSourceOfFundsCard checkTransferResponseSourceOfFundsCard = (CheckTransferResponseSourceOfFundsCard) o;
    return Objects.equals(this.expiry, checkTransferResponseSourceOfFundsCard.expiry) &&
        Objects.equals(this.holder, checkTransferResponseSourceOfFundsCard.holder) &&
        Objects.equals(this.number, checkTransferResponseSourceOfFundsCard.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expiry, holder, number);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferResponseSourceOfFundsCard {\n");
    
    sb.append("    expiry: ").append(toIndentedString(expiry)).append("\n");
    sb.append("    holder: ").append(toIndentedString(holder)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
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

