package com.springbootjpah2.project.springbootjpah2.dao;

import com.springbootjpah2.project.springbootjpah2.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

    List<Alien> findByTech(String aTech);

    @Query("from Alien where tech=?1 order by aName")
    List<Alien> findByTechSorted(String aTech);
}
