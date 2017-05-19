package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;
/**
 * CheckTransferRequestConsumer
 */

public class CheckTransferRequestConsumer   {
  @JsonProperty("device")
  @Valid
  @NotNull
  private CheckTransferRequestConsumerDevice device = null;

  public CheckTransferRequestConsumer device(CheckTransferRequestConsumerDevice device) {
    this.device = device;
    return this;
  }

   /**
   * Get device
   * @return device
  **/
  @ApiModelProperty(value = "")
  public CheckTransferRequestConsumerDevice getDevice() {
    return device;
  }

  public void setDevice(CheckTransferRequestConsumerDevice device) {
    this.device = device;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckTransferRequestConsumer checkTransferRequestConsumer = (CheckTransferRequestConsumer) o;
    return Objects.equals(this.device, checkTransferRequestConsumer.device);
  }

  @Override
  public int hashCode() {
    return Objects.hash(device);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferRequestConsumer {\n");
    
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
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

