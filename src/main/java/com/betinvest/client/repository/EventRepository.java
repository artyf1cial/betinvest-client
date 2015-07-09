package com.betinvest.client.repository;

import com.betinvest.client.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findAll();

    List<Event>findByLeagueId(int leagueId);

    List<Event>findByLeagueIdIn(Set<Integer> leagueIdSet);

    @Query(" select e.id from Event e")
    Set<Integer> getIdSet();
}
