package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

/**
 * CheckTransferRequestSourceOfFunds
 */

public class CheckTransferRequestSourceOfFunds   {
  @JsonProperty("reference")
  @Valid
  private CheckTransferRequestSourceOfFundsReference reference = null;

  public CheckTransferRequestSourceOfFunds reference(CheckTransferRequestSourceOfFundsReference reference) {
    this.reference = reference;
    return this;
  }

   /**
   * Get reference
   * @return reference
  **/
  @ApiModelProperty(value = "")
  public CheckTransferRequestSourceOfFundsReference getReference() {
    return reference;
  }

  public void setReference(CheckTransferRequestSourceOfFundsReference reference) {
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
    CheckTransferRequestSourceOfFunds checkTransferRequestSourceOfFunds = (CheckTransferRequestSourceOfFunds) o;
    return Objects.equals(this.reference, checkTransferRequestSourceOfFunds.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferRequestSourceOfFunds {\n");
    
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

