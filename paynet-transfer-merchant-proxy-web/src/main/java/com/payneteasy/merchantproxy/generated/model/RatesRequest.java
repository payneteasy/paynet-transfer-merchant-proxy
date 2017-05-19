package com.payneteasy.merchantproxy.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.payneteasy.merchantproxy.generated.model.RatesRequestConsumer;
import com.payneteasy.merchantproxy.generated.model.RatesRequestSession;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RatesRequest
 */

public class RatesRequest   {
  @JsonProperty("consumer")
  @Valid
  @NotNull
  private RatesRequestConsumer consumer = null;

  @JsonProperty("session")
  @Valid
  @NotNull
  private RatesRequestSession session = null;

  public RatesRequest consumer(RatesRequestConsumer consumer) {
    this.consumer = consumer;
    return this;
  }

   /**
   * Get consumer
   * @return consumer
  **/
  @ApiModelProperty(value = "")

  public RatesRequestConsumer getConsumer() {
    return consumer;
  }

  public void setConsumer(RatesRequestConsumer consumer) {
    this.consumer = consumer;
  }

  public RatesRequest session(RatesRequestSession session) {
    this.session = session;
    return this;
  }

   /**
   * Get session
   * @return session
  **/
  @ApiModelProperty(value = "")

  public RatesRequestSession getSession() {
    return session;
  }

  public void setSession(RatesRequestSession session) {
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
    RatesRequest ratesRequest = (RatesRequest) o;
    return Objects.equals(this.consumer, ratesRequest.consumer) &&
        Objects.equals(this.session, ratesRequest.session);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumer, session);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RatesRequest {\n");
    
    sb.append("    consumer: ").append(toIndentedString(consumer)).append("\n");
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

