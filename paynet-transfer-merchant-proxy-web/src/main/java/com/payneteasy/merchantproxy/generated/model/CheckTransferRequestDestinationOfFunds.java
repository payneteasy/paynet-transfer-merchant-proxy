package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

/**
 * CheckTransferRequestDestinationOfFunds
 */

public class CheckTransferRequestDestinationOfFunds   {
  @JsonProperty("reference")
  @Valid
  private CheckTransferRequestDestinationOfFundsReference reference = null;

  public CheckTransferRequestDestinationOfFunds reference(CheckTransferRequestDestinationOfFundsReference reference) {
    this.reference = reference;
    return this;
  }

   /**
   * Get reference
   * @return reference
  **/
  @ApiModelProperty(value = "")
  public CheckTransferRequestDestinationOfFundsReference getReference() {
    return reference;
  }

  public void setReference(CheckTransferRequestDestinationOfFundsReference reference) {
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
    CheckTransferRequestDestinationOfFunds checkTransferRequestDestinationOfFunds = (CheckTransferRequestDestinationOfFunds) o;
    return Objects.equals(this.reference, checkTransferRequestDestinationOfFunds.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferRequestDestinationOfFunds {\n");
    
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

