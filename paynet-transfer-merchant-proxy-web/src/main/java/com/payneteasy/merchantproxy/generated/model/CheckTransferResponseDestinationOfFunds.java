package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CheckTransferResponseDestinationOfFunds
 */

public class CheckTransferResponseDestinationOfFunds   {
  @JsonProperty("card")
  private CheckTransferResponseDestinationOfFundsCard card = null;

  @JsonProperty("reference")
  private CheckTransferResponseDestinationOfFundsReference reference = null;

  public CheckTransferResponseDestinationOfFunds card(CheckTransferResponseDestinationOfFundsCard card) {
    this.card = card;
    return this;
  }

   /**
   * Get card
   * @return card
  **/
  @ApiModelProperty(value = "")
  public CheckTransferResponseDestinationOfFundsCard getCard() {
    return card;
  }

  public void setCard(CheckTransferResponseDestinationOfFundsCard card) {
    this.card = card;
  }

  public CheckTransferResponseDestinationOfFunds reference(CheckTransferResponseDestinationOfFundsReference reference) {
    this.reference = reference;
    return this;
  }

   /**
   * Get reference
   * @return reference
  **/
  @ApiModelProperty(value = "")
  public CheckTransferResponseDestinationOfFundsReference getReference() {
    return reference;
  }

  public void setReference(CheckTransferResponseDestinationOfFundsReference reference) {
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
    CheckTransferResponseDestinationOfFunds checkTransferResponseDestinationOfFunds = (CheckTransferResponseDestinationOfFunds) o;
    return Objects.equals(this.card, checkTransferResponseDestinationOfFunds.card) &&
        Objects.equals(this.reference, checkTransferResponseDestinationOfFunds.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(card, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferResponseDestinationOfFunds {\n");
    
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

