package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CheckTransferRequestDestinationOfFundsReference
 */

public class CheckTransferRequestDestinationOfFundsReference   {
  @JsonProperty("clientCardId")
  private String clientCardId = null;

  public CheckTransferRequestDestinationOfFundsReference clientCardId(String clientCardId) {
    this.clientCardId = clientCardId;
    return this;
  }

   /**
   * The destination card reference identifier (on client side)
   * @return clientCardId
  **/
  @ApiModelProperty(value = "The destination card reference identifier (on client side)")
  public String getClientCardId() {
    return clientCardId;
  }

  public void setClientCardId(String clientCardId) {
    this.clientCardId = clientCardId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckTransferRequestDestinationOfFundsReference checkTransferRequestDestinationOfFundsReference = (CheckTransferRequestDestinationOfFundsReference) o;
    return Objects.equals(this.clientCardId, checkTransferRequestDestinationOfFundsReference.clientCardId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientCardId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferRequestDestinationOfFundsReference {\n");
    
    sb.append("    clientCardId: ").append(toIndentedString(clientCardId)).append("\n");
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

