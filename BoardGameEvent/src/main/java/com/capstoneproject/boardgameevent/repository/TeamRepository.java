package com.capstoneproject.boardgameevent.repository;

import com.capstoneproject.boardgameevent.entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Integer> {

    Optional<Team> findByName(String name);

    Boolean existsByNameAndTeamPassword(String name, String password);

    Team findByNameAndTeamPassword(String name, String password);
}
