package com.betinvest.client.web.rest;

import com.betinvest.client.dto.*;
import com.betinvest.client.service.BindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bind")
public class BindingController {

    @Autowired
    private BindingService bindingService;

    @RequestMapping(value = "/get-sports", method = RequestMethod.POST)
    @ResponseBody
    public List<IdPair> getSports(@RequestBody List<SportDto> sportDtos) {
        return bindingService.bindSports(sportDtos);
    }

    @RequestMapping(value = "/get-countries", method = RequestMethod.POST)
    @ResponseBody
    public List<IdPair> getCountries(@RequestBody List<CountryDto> countryDtos) {
        return bindingService.bindCountries(countryDtos);
    }

    @RequestMapping(value = "/get-leagues", method = RequestMethod.POST)
    @ResponseBody
    public List<IdPair> getLeagues(@RequestBody List<LeagueDto> leagueDtos) {
        return bindingService.bindLeagues(leagueDtos);
    }

    @RequestMapping(value = "/get-teams", method = RequestMethod.POST)
    @ResponseBody
    public List<IdPair> getTeams(@RequestBody List<TeamDto> teamDtos) {
        return bindingService.bindTeams(teamDtos);
    }

    @RequestMapping(value = "/get-events", method = RequestMethod.POST)
    @ResponseBody
    public List<ClientEventDto> getEvents(@RequestBody List<CompilerEventDto> compilerEventDtos) {
        return bindingService.bindEvents(compilerEventDtos);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@RequestBody String word){
        return word;
    }
}
