package com.betinvest.client.repository;

import com.betinvest.client.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    List<Team> findAll();

    @Query(" select t.id from Team t")
    Set<Integer> getIdSet();
}
