package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;

public class NotificationRequestCard {

    @JsonProperty("reference")
    @Valid
    private NotificationRequestCardReference reference = null;

    public NotificationRequestCard reference(NotificationRequestCardReference reference) {
        this.reference = reference;
        return this;
    }

    @JsonProperty("bin")
    @Valid
    private Integer bin = null;

    public NotificationRequestCard bin(Integer bin) {
        this.bin = bin;
        return this;
    }

    @ApiModelProperty(value = "")
    public NotificationRequestCardReference getReference() {
        return reference;
    }
    @ApiModelProperty(value = "")
    public Integer getBin() {
        return bin;
    }

    public void setReference(NotificationRequestCardReference reference) {
        this.reference = reference;
    }
    public void setBin(Integer bin) {
        this.bin = bin;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotificationRequestCard obj = (NotificationRequestCard) o;
        return Objects.equals(this.reference, obj.reference) && Objects.equals(this.bin, obj.bin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, bin);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationRequestCard {\n");

        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    bin: ").append(toIndentedString(bin)).append("\n");
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
