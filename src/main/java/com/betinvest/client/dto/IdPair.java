package com.betinvest.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IdPair {

    @JsonProperty("compiler_id")
    private Integer compilerId;

    @JsonProperty("client_id")
    private Integer clientId;

    public IdPair(Integer compilerId, Integer clientId) {
        this.compilerId = compilerId;
        this.clientId = clientId;
    }

    public Integer getCompilerId() {
        return compilerId;
    }

    public void setCompilerId(Integer compilerId) {
        this.compilerId = compilerId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
