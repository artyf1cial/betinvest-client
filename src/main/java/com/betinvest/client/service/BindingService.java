package com.betinvest.client.service;

import com.betinvest.client.dto.*;

import java.util.List;

public interface BindingService {

    List<IdPair> bindSports(List<SportDto> dtos);

    List<IdPair> bindCountries(List<CountryDto> dtos);

    List<IdPair> bindLeagues(List<LeagueDto> dtos);

    List<IdPair> bindTeams(List<TeamDto> dtos);

    List<ClientEventDto> bindEvents(List<CompilerEventDto> compilerDtos);

    List<SportDto> getSportBindingList(SportDto sport);

    List<CountryDto> getCountryBindingList(CountryDto country);

    List<LeagueDto> getLeagueBindingList(LeagueDto league);

    List<TeamDto> getTeamBindingList(TeamDto team);

    List<EventDto> getEventBindingList(CompilerEventDto event);

}
