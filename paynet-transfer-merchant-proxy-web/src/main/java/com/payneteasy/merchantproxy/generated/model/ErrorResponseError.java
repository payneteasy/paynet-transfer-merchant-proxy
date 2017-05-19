package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ErrorResponseError
 */

public class ErrorResponseError   {
  /**
   * The cause of the error, possible values: FILTERED, INVALID_REQUEST, SERVER_FAILED, SERVER_UNAVAILABLE
   */
  public enum CauseEnum {
    FILTERED("FILTERED"),
    
    INVALID_REQUEST("INVALID_REQUEST"),
    
    SERVER_FAILED("SERVER_FAILED"),
    
    SERVER_UNAVAILABLE("SERVER_UNAVAILABLE");

    private String value;

    CauseEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CauseEnum fromValue(String text) {
      for (CauseEnum b : CauseEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("cause")
  private CauseEnum cause = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("message")
  private String message = null;

  public ErrorResponseError cause(CauseEnum cause) {
    this.cause = cause;
    return this;
  }

   /**
   * The cause of the error, possible values: FILTERED, INVALID_REQUEST, SERVER_FAILED, SERVER_UNAVAILABLE
   * @return cause
  **/
  @ApiModelProperty(value = "The cause of the error, possible values: FILTERED, INVALID_REQUEST, SERVER_FAILED, SERVER_UNAVAILABLE")
  public CauseEnum getCause() {
    return cause;
  }

  public void setCause(CauseEnum cause) {
    this.cause = cause;
  }

  public ErrorResponseError code(String code) {
    this.code = code;
    return this;
  }

   /**
   * The unique error code
   * @return code
  **/
  @ApiModelProperty(value = "The unique error code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorResponseError message(String message) {
    this.message = message;
    return this;
  }

   /**
   * the description of the error
   * @return message
  **/
  @ApiModelProperty(value = "the description of the error")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponseError errorResponseError = (ErrorResponseError) o;
    return Objects.equals(this.cause, errorResponseError.cause) &&
        Objects.equals(this.code, errorResponseError.code) &&
        Objects.equals(this.message, errorResponseError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cause, code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponseError {\n");
    
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

