package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * CheckTransferRequestConsumerDevice
 */

public class CheckTransferRequestConsumerDevice   {
  @JsonProperty("serialNumber")
  @Valid
  @NotEmpty
  private String serialNumber = null;

  public CheckTransferRequestConsumerDevice serialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

   /**
   * The consumer’s device serial number
   * @return serialNumber
  **/
  @ApiModelProperty(required = true, value = "The consumer’s device serial number")
  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckTransferRequestConsumerDevice checkTransferRequestConsumerDevice = (CheckTransferRequestConsumerDevice) o;
    return Objects.equals(this.serialNumber, checkTransferRequestConsumerDevice.serialNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serialNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferRequestConsumerDevice {\n");
    
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
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

