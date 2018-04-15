package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class NotificationRequest {

    @JsonProperty("consumer")
    @Valid
    @NotNull
    private RequestConsumer consumer = null;

    @JsonProperty("session")
    @Valid
    @NotNull
    private NotificationRequestSession session = null;

    @JsonProperty("sourceCard")
    @Valid
    private NotificationRequestCard sourceCard = null;

    @JsonProperty("destinationCard")
    @Valid
    private NotificationRequestCard destinationCard = null;

    public NotificationRequest consumer(RequestConsumer consumer) {
        this.consumer = consumer;
        return this;
    }

    @ApiModelProperty(value = "")
    public RequestConsumer getConsumer() {
        return consumer;
    }

    public void setConsumer(RequestConsumer consumer) {
        this.consumer = consumer;
    }

    public NotificationRequest session(NotificationRequestSession session) {
        this.session = session;
        return this;
    }

    @ApiModelProperty(value = "")
    public NotificationRequestSession getSession() {
        return session;
    }

    public void setSession(NotificationRequestSession session) {
        this.session = session;
    }

    public NotificationRequest sourceCard(NotificationRequestCard sourceCard) {
        this.sourceCard = sourceCard;
        return this;
    }

    @ApiModelProperty(value = "")
    public NotificationRequestCard getSourceCard() {
        return sourceCard;
    }

    public void setSourceCard(NotificationRequestCard sourceCard) {
        this.sourceCard = sourceCard;
    }

    public NotificationRequest destinationOfFunds(NotificationRequestCard destinationCard) {
        this.destinationCard = destinationCard;
        return this;
    }

    @ApiModelProperty(value = "")
    public NotificationRequestCard getDestinationCard() {
        return destinationCard;
    }

    public void setDestinationCard(NotificationRequestCard destinationCard) {
        this.destinationCard = destinationCard;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotificationRequest obj = (NotificationRequest) o;
        return Objects.equals(this.consumer, obj.consumer) &&
                Objects.equals(this.session, obj.session) &&
                Objects.equals(this.sourceCard, obj.sourceCard) &&
                Objects.equals(this.destinationCard, obj.destinationCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumer, session, sourceCard, destinationCard);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationRequest {\n");

        sb.append("    consumer: ").append(toIndentedString(consumer)).append("\n");
        sb.append("    session: ").append(toIndentedString(session)).append("\n");
        sb.append("    sourceCard: ").append(toIndentedString(sourceCard)).append("\n");
        sb.append("    destinationCard: ").append(toIndentedString(destinationCard)).append("\n");
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
