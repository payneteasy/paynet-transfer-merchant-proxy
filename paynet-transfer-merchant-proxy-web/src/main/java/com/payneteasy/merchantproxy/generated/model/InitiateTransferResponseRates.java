package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * InitiateTransferResponseRates
 */

public class InitiateTransferResponseRates   {
  @JsonProperty("min")
  private String min = null;

  @JsonProperty("max")
  private String max = null;

  public InitiateTransferResponseRates min(String min) {
    this.min = min;
    return this;
  }

   /**
   * Possible minimum commission amount
   * @return min
  **/
  @ApiModelProperty(value = "Possible minimum commission amount")
  public String getMin() {
    return min;
  }

  public void setMin(String min) {
    this.min = min;
  }

  public InitiateTransferResponseRates max(String max) {
    this.max = max;
    return this;
  }

   /**
   * Possible maximum commission amount
   * @return max
  **/
  @ApiModelProperty(value = "Possible maximum commission amount")
  public String getMax() {
    return max;
  }

  public void setMax(String max) {
    this.max = max;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitiateTransferResponseRates initiateTransferResponseRates = (InitiateTransferResponseRates) o;
    return Objects.equals(this.min, initiateTransferResponseRates.min) &&
        Objects.equals(this.max, initiateTransferResponseRates.max);
  }

  @Override
  public int hashCode() {
    return Objects.hash(min, max);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiateTransferResponseRates {\n");
    
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
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

