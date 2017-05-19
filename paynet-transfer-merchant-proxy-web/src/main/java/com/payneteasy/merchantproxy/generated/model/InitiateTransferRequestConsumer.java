package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
/**
 * InitiateTransferRequestConsumer
 */

public class InitiateTransferRequestConsumer   {
  @JsonProperty("device")
  @Valid
  @NotNull
  private InitiateTransferRequestConsumerDevice device = null;

  @JsonProperty("ipAddresses")
  private java.util.List<String> ipAddresses = null;

  public InitiateTransferRequestConsumer device(InitiateTransferRequestConsumerDevice device) {
    this.device = device;
    return this;
  }

   /**
   * Get device
   * @return device
  **/
  @ApiModelProperty(value = "")
  public InitiateTransferRequestConsumerDevice getDevice() {
    return device;
  }

  public void setDevice(InitiateTransferRequestConsumerDevice device) {
    this.device = device;
  }

  public InitiateTransferRequestConsumer ipAddresses(java.util.List<String> ipAddresses) {
    this.ipAddresses = ipAddresses;
    return this;
  }

  public InitiateTransferRequestConsumer addIpAddressesItem(String ipAddressesItem) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new java.util.ArrayList<String>();
    }
    this.ipAddresses.add(ipAddressesItem);
    return this;
  }

   /**
   * Consumer's IP addresses
   * @return ipAddresses
  **/
  @ApiModelProperty(value = "Consumer's IP addresses")
  public java.util.List<String> getIpAddresses() {
    return ipAddresses;
  }

  public void setIpAddresses(java.util.List<String> ipAddresses) {
    this.ipAddresses = ipAddresses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitiateTransferRequestConsumer initiateTransferRequestConsumer = (InitiateTransferRequestConsumer) o;
    return Objects.equals(this.device, initiateTransferRequestConsumer.device) &&
        Objects.equals(this.ipAddresses, initiateTransferRequestConsumer.ipAddresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(device, ipAddresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiateTransferRequestConsumer {\n");
    
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    ipAddresses: ").append(toIndentedString(ipAddresses)).append("\n");
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

