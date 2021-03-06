package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CheckTransferResponseSession
 */

public class CheckTransferResponseSession   {
  @JsonProperty("checkSignature")
  private String checkSignature = null;

  @JsonProperty("nonce")
  private String nonce = null;

  @JsonProperty("token")
  private String token = null;

  public CheckTransferResponseSession checkSignature(String checkSignature) {
    this.checkSignature = checkSignature;
    return this;
  }

   /**
   * Checksum generated by hmac-sha1 of concatenate serialNumber + nonce + destinationOfFunds.reference.serverCardId (if present) + endpointId + invoiceId + sourceOfFunds.reference.serverCardId (if present)
   * @return checkSignature
  **/
  @ApiModelProperty(value = "Checksum generated by hmac-sha1 of concatenate serialNumber + nonce + destinationOfFunds.reference.serverCardId (if present) + endpointId + invoiceId + sourceOfFunds.reference.serverCardId (if present)")
  public String getCheckSignature() {
    return checkSignature;
  }

  public void setCheckSignature(String checkSignature) {
    this.checkSignature = checkSignature;
  }

  public CheckTransferResponseSession nonce(String nonce) {
    this.nonce = nonce;
    return this;
  }

   /**
   * Random string, uniquely generated by the proxy
   * @return nonce
  **/
  @ApiModelProperty(value = "Random string, uniquely generated by the proxy")
  public String getNonce() {
    return nonce;
  }

  public void setNonce(String nonce) {
    this.nonce = nonce;
  }

  public CheckTransferResponseSession token(String token) {
    this.token = token;
    return this;
  }

   /**
   * Get token
   * @return token
  **/
  @ApiModelProperty(value = "")
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
    CheckTransferResponseSession checkTransferResponseSession = (CheckTransferResponseSession) o;
    return Objects.equals(this.checkSignature, checkTransferResponseSession.checkSignature) &&
        Objects.equals(this.nonce, checkTransferResponseSession.nonce) &&
        Objects.equals(this.token, checkTransferResponseSession.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checkSignature, nonce, token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckTransferResponseSession {\n");
    
    sb.append("    checkSignature: ").append(toIndentedString(checkSignature)).append("\n");
    sb.append("    nonce: ").append(toIndentedString(nonce)).append("\n");
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

