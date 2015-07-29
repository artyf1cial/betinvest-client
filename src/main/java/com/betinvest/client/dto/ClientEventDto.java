package com.betinvest.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientEventDto {

    @JsonProperty("compiler_id")
    private int compilerId;

    @JsonProperty("client_id")
    private int clientId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("team1_id")
    private Integer team1Id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("team2_id")
    private Integer team2Id;

    public int getCompilerId() {
        return compilerId;
    }

    public void setCompilerId(int compilerId) {
        this.compilerId = compilerId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Integer getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(Integer team1Id) {
        this.team1Id = team1Id;
    }

    public Integer getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(Integer team2Id) {
        this.team2Id = team2Id;
    }
}
