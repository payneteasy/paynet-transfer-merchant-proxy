package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.payneteasy.merchantproxy.generated.model.RatesRequestConsumerDevice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RatesRequestConsumer
 */

public class RatesRequestConsumer   {
  @JsonProperty("device")
  @Valid
  @NotNull
  private RatesRequestConsumerDevice device = null;

  public RatesRequestConsumer device(RatesRequestConsumerDevice device) {
    this.device = device;
    return this;
  }

   /**
   * Get device
   * @return device
  **/
  @ApiModelProperty(value = "")

  public RatesRequestConsumerDevice getDevice() {
    return device;
  }

  public void setDevice(RatesRequestConsumerDevice device) {
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
    RatesRequestConsumer ratesRequestConsumer = (RatesRequestConsumer) o;
    return Objects.equals(this.device, ratesRequestConsumer.device);
  }

  @Override
  public int hashCode() {
    return Objects.hash(device);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RatesRequestConsumer {\n");
    
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

