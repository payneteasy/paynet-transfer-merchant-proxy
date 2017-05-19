package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CheckTransferResponseSourceOfFundsReference
 */

public class CheckTransferResponseSourceOfFundsReference   {
  @JsonProperty("serverCardId")
  private String serverCardId = null;

  public CheckTransferResponseSourceOfFundsReference serverCardId(String serverCardId) {
    this.serverCardId = serverCardId;
    return this;
  }

   /**
   * Get serverCardId
   * @return serverCardId
  **/
  @ApiModelProperty(value = "")
  public String getServerCardId() {
    return serverCardId;
  }

  public void setServerCardId(String serverCardId) {
    this.serverCardId = serverCardId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckTransferResponseSourceOfFundsReference checkTransferResponseSourceOfFundsReference = (CheckTransferResponseSourceOfFundsReference) o;
    return Objects.equals(this.serverCardId, checkTransferResponseSourceOfFundsReference.serverCardId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serverCardId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferResponseSourceOfFundsReference {\n");
    
    sb.append("    serverCardId: ").append(toIndentedString(serverCardId)).append("\n");
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

