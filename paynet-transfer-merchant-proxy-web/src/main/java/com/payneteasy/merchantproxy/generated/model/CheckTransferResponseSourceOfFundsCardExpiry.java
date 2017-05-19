package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CheckTransferResponseSourceOfFundsCardExpiry
 */

public class CheckTransferResponseSourceOfFundsCardExpiry   {
  @JsonProperty("month")
  private Integer month = null;

  @JsonProperty("year")
  private Integer year = null;

  public CheckTransferResponseSourceOfFundsCardExpiry month(Integer month) {
    this.month = month;
    return this;
  }

   /**
   * Get month
   * @return month
  **/
  @ApiModelProperty(value = "")
  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public CheckTransferResponseSourceOfFundsCardExpiry year(Integer year) {
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @ApiModelProperty(value = "")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckTransferResponseSourceOfFundsCardExpiry checkTransferResponseSourceOfFundsCardExpiry = (CheckTransferResponseSourceOfFundsCardExpiry) o;
    return Objects.equals(this.month, checkTransferResponseSourceOfFundsCardExpiry.month) &&
        Objects.equals(this.year, checkTransferResponseSourceOfFundsCardExpiry.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(month, year);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferResponseSourceOfFundsCardExpiry {\n");
    
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
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

