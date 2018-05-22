package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class NotificationResponse {

    @JsonProperty("invoiceId")
    private String invoiceId = null;

    @JsonProperty("session")
    private NotificationResponseSession session = null;


    @ApiModelProperty(value = "Transfer transaction identifier")
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public NotificationResponse session(NotificationResponseSession session) {
        this.session = session;
        return this;
    }

    @ApiModelProperty(value = "")
    public NotificationResponseSession getSession() {
        return session;
    }

    public void setSession(NotificationResponseSession session) {
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
        NotificationResponse obj = (NotificationResponse) o;
        return Objects.equals(this.invoiceId, obj.invoiceId) &&
                Objects.equals(this.session, obj.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, session);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationResponse {\n");

        sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
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
