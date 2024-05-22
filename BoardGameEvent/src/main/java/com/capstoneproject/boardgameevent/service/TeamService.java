package com.capstoneproject.boardgameevent.service;

import com.capstoneproject.boardgameevent.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService extends SrdService<Integer, Team> {

    List<Team> findByPercentageOfWins();

    Optional<Team> findByName(String name);

    void throwOrSave(Team team);

    Boolean existByNameAndPassword(String name, String password);

    void join(String name, String password);

    Team findByNameAndPassword(String name, String password);

}
