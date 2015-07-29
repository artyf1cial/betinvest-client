package com.betinvest.client.repository;

import com.betinvest.client.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    List<Team> findAll();

    List<Team> findByCountryIdAndSportId(int countryId, int sportId);

    @Query(" select t.id from Team t")
    Set<Integer> getIdSet();

    @Query(" select t.id from Team t where t.name= ?1 and t.country.id = ?2 and t.sport.id = ?3")
    Integer getIdByNameAndCountryIdAndSportId(String name, Integer countryId, Integer sportId);
}
