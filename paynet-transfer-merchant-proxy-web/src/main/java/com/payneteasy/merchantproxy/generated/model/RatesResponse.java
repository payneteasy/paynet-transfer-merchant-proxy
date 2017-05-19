package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RatesResponse
 */

public class RatesResponse   {
  @JsonProperty("rateInterest")
  private Double rateInterest = null;

  @JsonProperty("rateMin")
  private Double rateMin = null;

  @JsonProperty("limitMin")
  private Double limitMin = null;

  @JsonProperty("limitMax")
  private Double limitMax = null;

  public RatesResponse rateInterest(Double rateInterest) {
    this.rateInterest = rateInterest;
    return this;
  }

   /**
   * Transfer rate interest (percent)
   * @return rateInterest
  **/
  @ApiModelProperty(value = "Transfer rate interest (percent)")
  public Double getRateInterest() {
    return rateInterest;
  }

  public void setRateInterest(Double rateInterest) {
    this.rateInterest = rateInterest;
  }

  public RatesResponse rateMin(Double rateMin) {
    this.rateMin = rateMin;
    return this;
  }

   /**
   * Minimum commission amount
   * @return rateMin
  **/
  @ApiModelProperty(value = "Minimum commission amount")
  public Double getRateMin() {
    return rateMin;
  }

  public void setRateMin(Double rateMin) {
    this.rateMin = rateMin;
  }

  public RatesResponse limitMin(Double limitMin) {
    this.limitMin = limitMin;
    return this;
  }

   /**
   * Minimum transfer amount
   * @return limitMin
  **/
  @ApiModelProperty(value = "Minimum transfer amount")
  public Double getLimitMin() {
    return limitMin;
  }

  public void setLimitMin(Double limitMin) {
    this.limitMin = limitMin;
  }

  public RatesResponse limitMax(Double limitMax) {
    this.limitMax = limitMax;
    return this;
  }

   /**
   * Maximum transfer amount
   * @return limitMax
  **/
  @ApiModelProperty(value = "Maximum transfer amount")
  public Double getLimitMax() {
    return limitMax;
  }

  public void setLimitMax(Double limitMax) {
    this.limitMax = limitMax;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RatesResponse ratesResponse = (RatesResponse) o;
    return Objects.equals(this.rateInterest, ratesResponse.rateInterest) &&
        Objects.equals(this.rateMin, ratesResponse.rateMin) &&
        Objects.equals(this.limitMin, ratesResponse.limitMin) &&
        Objects.equals(this.limitMax, ratesResponse.limitMax);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rateInterest, rateMin, limitMin, limitMax);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RatesResponse {\n");
    
    sb.append("    rateInterest: ").append(toIndentedString(rateInterest)).append("\n");
    sb.append("    rateMin: ").append(toIndentedString(rateMin)).append("\n");
    sb.append("    limitMin: ").append(toIndentedString(limitMin)).append("\n");
    sb.append("    limitMax: ").append(toIndentedString(limitMax)).append("\n");
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

