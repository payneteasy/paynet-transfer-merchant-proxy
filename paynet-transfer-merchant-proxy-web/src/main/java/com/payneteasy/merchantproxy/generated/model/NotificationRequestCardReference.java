package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class NotificationRequestCardReference {

    @JsonProperty("serverCardId")
    private String serverCardId = null;

    @JsonProperty("uniqueReferenceCardId")
    private Integer uniqueReferenceCardId = null;

    public NotificationRequestCardReference serverCardId(String serverCardId) {
        this.serverCardId = serverCardId;
        return this;
    }

    public NotificationRequestCardReference uniqueReferenceCardId(Integer uniqueReferenceCardId) {
        this.uniqueReferenceCardId = uniqueReferenceCardId;
        return this;
    }


    @ApiModelProperty(value = "The source card reference identifier (on server side)")
    public String getServerCardId(){
        return serverCardId;
    }

    @ApiModelProperty(value = "The source card reference unique identifier (on server side)")
    public Integer getUniqueReferenceCardId(){
        return uniqueReferenceCardId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotificationRequestCardReference notificationRequestCardReference = (NotificationRequestCardReference) o;
        return Objects.equals(this.serverCardId, notificationRequestCardReference.serverCardId) && Objects.equals(this.uniqueReferenceCardId, notificationRequestCardReference.uniqueReferenceCardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverCardId, uniqueReferenceCardId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationRequestCardReference {\n");

        sb.append("    serverCardId: ").append(toIndentedString(serverCardId)).append("\n");
        sb.append("    uniqueReferenceCardId: ").append(toIndentedString(uniqueReferenceCardId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
