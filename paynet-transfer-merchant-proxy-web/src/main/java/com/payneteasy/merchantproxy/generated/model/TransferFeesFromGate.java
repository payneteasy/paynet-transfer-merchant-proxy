package com.payneteasy.merchantproxy.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TransferFeesFromGate {

    @JsonProperty("assignedId")
    @Valid
    @NotNull
    private String assignedId;

    @JsonProperty("commissionCentis")
    @Valid
    @NotNull
    private long commissionCentis;

    @JsonProperty("currency")
    @Valid
    @NotNull
    private String currency;

    TransferFeesFromGate(){
    }

    public TransferFeesFromGate(String assignedId, long commissionCentis, String currency) {
        this.assignedId = assignedId;
        this.commissionCentis = commissionCentis;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "TransferFeesFromGate{" +
                "assignedId='" + assignedId + '\'' +
                ", commissionCentis=" + commissionCentis +
                ", currency='" + currency + '\'' +
                '}';
    }

    public String getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(String assignedId) {
        this.assignedId = assignedId;
    }

    public long getCommissionCentis() {
        return commissionCentis;
    }

    public void setCommissionCentis(long commissionCentis) {
        this.commissionCentis = commissionCentis;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
