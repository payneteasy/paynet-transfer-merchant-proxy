package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Objects;

public class NotificationRequestSession {
    @JsonProperty("accessToken")
    @NotEmpty
    private String accessToken = null;

    @JsonProperty("token")
    @NotEmpty
    private String token = null;

    public NotificationRequestSession accessToken(String accessToken) {
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
        NotificationRequestSession notificationRequestSession = (NotificationRequestSession) o;
        return Objects.equals(this.accessToken, notificationRequestSession.accessToken) &&
                Objects.equals(this.token, notificationRequestSession.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, token);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationRequestSession {\n");

        sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
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
