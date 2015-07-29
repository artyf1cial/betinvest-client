package com.betinvest.client.dto;

import com.betinvest.client.domain.Sport;

public class SportDto {

    private int id;
    private String name;

    public SportDto(Sport sport) {
        this.id = sport.getId();
        this.name = sport.getName();
    }

    public SportDto() {
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
}
