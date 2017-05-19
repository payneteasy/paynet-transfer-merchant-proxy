package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccessTokenResponse
 */

public class AccessTokenResponse   {
  @JsonProperty("session")
  @Valid
  private AccessTokenResponseSession session = null;

  public AccessTokenResponse session(AccessTokenResponseSession session) {
    this.session = session;
    return this;
  }

   /**
   * Get session
   * @return session
  **/
  @ApiModelProperty(value = "")
  public AccessTokenResponseSession getSession() {
    return session;
  }

  public void setSession(AccessTokenResponseSession session) {
    this.session = session;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessTokenResponse accessTokenResponse = (AccessTokenResponse) o;
    return Objects.equals(this.session, accessTokenResponse.session);
  }

  @Override
  public int hashCode() {
    return Objects.hash(session);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessTokenResponse {\n");
    
    sb.append("    session: ").append(toIndentedString(session)).append("\n");
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

