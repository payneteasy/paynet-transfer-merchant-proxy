package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RatesRequestConsumerDevice
 */

public class RatesRequestConsumerDevice {
  @JsonProperty("serialNumber")
  @NotEmpty
  private String serialNumber = null;

  public RatesRequestConsumerDevice serialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  /**
   * Consumer's device serial number
   *
   * @return serialNumber
   **/
  @ApiModelProperty(required = true, value = "Consumer's device serial number")

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
    RatesRequestConsumerDevice ratesRequestConsumerDevice = (RatesRequestConsumerDevice) o;
    return Objects.equals(this.serialNumber, ratesRequestConsumerDevice.serialNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serialNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RatesRequestConsumerDevice {\n");

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

