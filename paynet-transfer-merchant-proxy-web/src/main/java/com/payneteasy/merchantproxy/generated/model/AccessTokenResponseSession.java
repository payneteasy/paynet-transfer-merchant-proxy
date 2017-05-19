package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * AccessTokenResponseSession
 */

public class AccessTokenResponseSession   {
  @JsonProperty("accessToken")
  @NotEmpty
  private String accessToken = null;

  public AccessTokenResponseSession accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

   /**
   * Access token key
   * @return accessToken
  **/
  @ApiModelProperty(value = "Access token key")
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessTokenResponseSession accessTokenResponseSession = (AccessTokenResponseSession) o;
    return Objects.equals(this.accessToken, accessTokenResponseSession.accessToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessTokenResponseSession {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
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

