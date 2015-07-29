package com.betinvest.client.service.impl;

import com.betinvest.client.domain.*;
import com.betinvest.client.dto.*;
import com.betinvest.client.repository.*;
import com.betinvest.client.service.BindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BindingServiceImpl implements BindingService{

    @Autowired
    private SportRepository sportRepository;
    @Autowired
    private LeagueRepository leagueRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<IdPair> bindSports(List<SportDto> dtos) {
        List<IdPair> pairs = new ArrayList<>();
        for (SportDto dto : dtos) {
            Integer ourId = sportRepository.getIdByName(dto.getName());
            if (ourId != null) {
                pairs.add(new IdPair(dto.getId(), ourId));
            }
        }
        return pairs;
    }

    @Override
    public List<IdPair> bindCountries(List<CountryDto> dtos) {
        List<IdPair> pairs = new ArrayList<>();
        for (CountryDto dto : dtos) {
            Integer ourId = countryRepository.getIdByName(dto.getName());
            if (ourId != null) {
                pairs.add(new IdPair(dto.getId(), ourId));
            }
        }
        return pairs;
    }

    @Override
    public List<IdPair> bindLeagues(List<LeagueDto> dtos) {

        List<IdPair> pairs = new ArrayList<>();
        for (LeagueDto dto : dtos) {
            Integer ourId = leagueRepository.getIdByNameAndCountryIdAndSportId(dto.getName(), dto.getCountryId(), dto.getSportId());
            if (ourId != null) {
                pairs.add(new IdPair(dto.getId(), ourId));
            }
        }
        return pairs;
    }

    @Override
    public List<IdPair> bindTeams(List<TeamDto> dtos) {
        List<IdPair> pairs = new ArrayList<>();
        for (TeamDto dto : dtos) {
            Integer ourId = teamRepository.getIdByNameAndCountryIdAndSportId(dto.getName(), dto.getCountryId(), dto.getSportId());
            if (ourId != null) {
                pairs.add(new IdPair(dto.getId(), ourId));
            }
        }
        return pairs;
    }

    @Override
    public List<ClientEventDto> bindEvents(List<CompilerEventDto> compilerDtos) {
        List<ClientEventDto> clientDtos = new ArrayList<>();
        for (CompilerEventDto compilerDto : compilerDtos) {
            List<Event> events = eventRepository.findByLeagueIdAndDateTime(compilerDto.getLeagueId(), compilerDto.getDatetime());
            if (events.size() == 1) {
                Event event = events.get(0);
                ClientEventDto clientDto = new ClientEventDto();
                clientDto.setClientId(event.getId());
                clientDto.setCompilerId(compilerDto.getId());
                if (compilerDto.getTeam1Id() == null) {
                    clientDto.setTeam1Id(event.getTeam1().getId());
                }
                if (compilerDto.getTeam2Id() == null) {
                    clientDto.setTeam2Id(event.getTeam2().getId());
                }
                clientDtos.add(clientDto);
            } else {
                if (compilerDto.getTeam1Id() != null) {
                    for (Event event : events) {
                        ClientEventDto clientDto = lookForTeamId(event, compilerDto.getTeam1Id());
                        if (clientDto != null) {
                            clientDtos.add(clientDto);
                        }
                    }
                } else if (compilerDto.getTeam2Id() != null) {
                    for (Event event : events) {
                        ClientEventDto clientDto = lookForTeamId(event, compilerDto.getTeam2Id());
                        if (clientDto != null) {
                            clientDtos.add(clientDto);
                        }
                    }
                }
            }
        }
        return clientDtos;
    }

    private ClientEventDto lookForTeamId(Event event, Integer compilerTeamId) {
        ClientEventDto clientDto = null;
        if (event.getTeam1().getId().equals(compilerTeamId)) {
            clientDto = new ClientEventDto();
            clientDto.setClientId(event.getId());
            clientDto.setCompilerId(compilerTeamId);
            clientDto.setTeam1Id(event.getTeam1().getId());
        } else if (event.getTeam2().getId().equals(compilerTeamId)) {
            clientDto = new ClientEventDto();
            clientDto.setClientId(event.getId());
            clientDto.setCompilerId(compilerTeamId);
            clientDto.setTeam1Id(event.getTeam2().getId());
        }
        return clientDto;
    }
    @Override
    public List<SportDto> getSportBindingList(SportDto dto) {
        List<SportDto> dtos = new ArrayList<>();
        for (Sport sport : sportRepository.findByName(dto.getName())) {
            dtos.add(new SportDto(sport));
        }
        return dtos;
    }

    @Override
    public List<CountryDto> getCountryBindingList(CountryDto dto) {
        List<CountryDto> dtos = new ArrayList<>();
        for (Country country : countryRepository.findByName(dto.getName())) {
            dtos.add(new CountryDto(country));
        }
        return dtos;
    }

    @Override
    public List<LeagueDto> getLeagueBindingList(LeagueDto dto) {
        List<LeagueDto> dtos = new ArrayList<>();
        for (League league : leagueRepository.findByCountryIdAndSportId(dto.getCountryId(), dto.getSportId())) {
            dtos.add(new LeagueDto(league));
        }
        return dtos;
    }

    @Override
    public List<TeamDto> getTeamBindingList(TeamDto dto) {
        List<TeamDto> dtos = new ArrayList<>();
        for (Team team : teamRepository.findByCountryIdAndSportId(dto.getCountryId(), dto.getSportId())) {
            dtos.add(new TeamDto(team));
        }
        return dtos;
    }

    @Override
    public List<EventDto> getEventBindingList(CompilerEventDto compilerDto) {
        List<EventDto> dtos = new ArrayList<>();
        for (Event event : eventRepository.findByLeagueIdAndDateTime(compilerDto.getLeagueId(), compilerDto.getDatetime())) {
            EventDto eventDto = new EventDto(event);
            if (compilerDto.getTeam1Id() == null) {
                eventDto.setTeam1Id(event.getTeam1().getId());
                eventDto.setTeam1Name(event.getTeam1().getName());
            }
            if (compilerDto.getTeam2Id() == null) {
                eventDto.setTeam2Id(event.getTeam1().getId());
                eventDto.setTeam2Name(event.getTeam1().getName());
            }
            dtos.add(eventDto);
        }
        return dtos;
    }
}
