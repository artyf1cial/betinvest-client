package com.betinvest.client.repository;

import com.betinvest.client.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface SportRepository extends JpaRepository<Sport, Integer> {

    List<Sport> findAll();

    List<Sport> findByName(String name);

    @Query(" select s.id from Sport s")
    Set<Integer> getIdSet();

    @Query(" select s.id from Sport s where s.name=?1")
    Integer getIdByName(String name);
}
