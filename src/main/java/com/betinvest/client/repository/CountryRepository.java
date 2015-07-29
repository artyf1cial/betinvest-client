package com.betinvest.client.repository;

import com.betinvest.client.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    List<Country> findAll();

    List<Country> findByName(String name);

    @Query(" select c.id from Country c")
    Set<Integer> getIdSet();

    @Query(" select c.id from Country c where c.name=?1")
    Integer getIdByName(String name);
}
