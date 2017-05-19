package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CheckTransferRequestSession
 */

public class CheckTransferRequestSession   {
  @JsonProperty("accessToken")
  @NotEmpty
  private String accessToken = null;

  @JsonProperty("nonce")
  @NotEmpty
  private String nonce = null;

  @JsonProperty("signature")
  @NotEmpty
  private String signature = null;

  @JsonProperty("token")
  @NotEmpty
  private String token = null;

  public CheckTransferRequestSession accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

   /**
   * The consumer’s access token key
   * @return accessToken
  **/
  @ApiModelProperty(required = true, value = "The consumer’s access token key")
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public CheckTransferRequestSession nonce(String nonce) {
    this.nonce = nonce;
    return this;
  }

   /**
   * Value received by client within initial transfer response
   * @return nonce
  **/
  @ApiModelProperty(required = true, value = "Value received by client within initial transfer response")
  public String getNonce() {
    return nonce;
  }

  public void setNonce(String nonce) {
    this.nonce = nonce;
  }

  public CheckTransferRequestSession signature(String signature) {
    this.signature = signature;
    return this;
  }

   /**
   * Value received by client within initial transfer response
   * @return signature
  **/
  @ApiModelProperty(required = true, value = "Value received by client within initial transfer response")
  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public CheckTransferRequestSession token(String token) {
    this.token = token;
    return this;
  }

   /**
   * The session token of transfer transaction
   * @return token
  **/
  @ApiModelProperty(required = true, value = "The session token of transfer transaction")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckTransferRequestSession checkTransferRequestSession = (CheckTransferRequestSession) o;
    return Objects.equals(this.accessToken, checkTransferRequestSession.accessToken) &&
        Objects.equals(this.nonce, checkTransferRequestSession.nonce) &&
        Objects.equals(this.signature, checkTransferRequestSession.signature) &&
        Objects.equals(this.token, checkTransferRequestSession.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, nonce, signature, token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferRequestSession {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    nonce: ").append(toIndentedString(nonce)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

