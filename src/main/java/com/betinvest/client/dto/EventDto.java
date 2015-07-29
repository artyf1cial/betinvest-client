package com.betinvest.client.dto;

import com.betinvest.client.domain.Event;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class EventDto {

    private int id;
    private Timestamp datetime;

    @JsonProperty("league_id")
    private int leagueId;

    @JsonProperty("team1_id")
    private Integer team1Id;

    @JsonProperty("team2_id")
    private Integer team2Id;

    @JsonProperty("team1_name")
    private String team1Name;

    @JsonProperty("team2_name")
    private String team2Name;

    public EventDto(Event event) {
        this.id = event.getId();
        this.datetime = event.getDateTime();
        this.leagueId = event.getLeague().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
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

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }
}
