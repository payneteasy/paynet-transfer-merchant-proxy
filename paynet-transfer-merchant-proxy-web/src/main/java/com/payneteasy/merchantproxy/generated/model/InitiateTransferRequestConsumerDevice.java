package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * InitiateTransferRequestConsumerDevice
 */

public class InitiateTransferRequestConsumerDevice   {
  @JsonProperty("imei")
  private String imei = null;

  @JsonProperty("serialNumber")
  @NotEmpty
  private String serialNumber = null;

  public InitiateTransferRequestConsumerDevice imei(String imei) {
    this.imei = imei;
    return this;
  }

   /**
   * The consumer’s device international mobile equipment identity
   * @return imei
  **/
  @ApiModelProperty(value = "The consumer’s device international mobile equipment identity")
  public String getImei() {
    return imei;
  }

  public void setImei(String imei) {
    this.imei = imei;
  }

  public InitiateTransferRequestConsumerDevice serialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

   /**
   * The consumer's device serial number
   * @return serialNumber
  **/
  @ApiModelProperty(required = true, value = "The consumer's device serial number")
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
    InitiateTransferRequestConsumerDevice initiateTransferRequestConsumerDevice = (InitiateTransferRequestConsumerDevice) o;
    return Objects.equals(this.imei, initiateTransferRequestConsumerDevice.imei) &&
        Objects.equals(this.serialNumber, initiateTransferRequestConsumerDevice.serialNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imei, serialNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiateTransferRequestConsumerDevice {\n");
    
    sb.append("    imei: ").append(toIndentedString(imei)).append("\n");
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

