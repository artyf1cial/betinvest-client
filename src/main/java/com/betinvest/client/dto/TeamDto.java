package com.betinvest.client.dto;

import com.betinvest.client.domain.Team;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamDto {

    private int id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("sport_id")
    private int sportId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("country_id")
    private int countryId;

    public TeamDto(Team team) {
        this.id = team.getId();
        this.name = team.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
