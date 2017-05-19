package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CheckTransferResponseSourceOfFunds
 */

public class CheckTransferResponseSourceOfFunds   {
  @JsonProperty("card")
  private CheckTransferResponseSourceOfFundsCard card = null;

  @JsonProperty("reference")
  private CheckTransferResponseSourceOfFundsReference reference = null;

  public CheckTransferResponseSourceOfFunds card(CheckTransferResponseSourceOfFundsCard card) {
    this.card = card;
    return this;
  }

   /**
   * Get card
   * @return card
  **/
  @ApiModelProperty(value = "")
  public CheckTransferResponseSourceOfFundsCard getCard() {
    return card;
  }

  public void setCard(CheckTransferResponseSourceOfFundsCard card) {
    this.card = card;
  }

  public CheckTransferResponseSourceOfFunds reference(CheckTransferResponseSourceOfFundsReference reference) {
    this.reference = reference;
    return this;
  }

   /**
   * Get reference
   * @return reference
  **/
  @ApiModelProperty(value = "")
  public CheckTransferResponseSourceOfFundsReference getReference() {
    return reference;
  }

  public void setReference(CheckTransferResponseSourceOfFundsReference reference) {
    this.reference = reference;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckTransferResponseSourceOfFunds checkTransferResponseSourceOfFunds = (CheckTransferResponseSourceOfFunds) o;
    return Objects.equals(this.card, checkTransferResponseSourceOfFunds.card) &&
        Objects.equals(this.reference, checkTransferResponseSourceOfFunds.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(card, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferResponseSourceOfFunds {\n");
    
    sb.append("    card: ").append(toIndentedString(card)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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

