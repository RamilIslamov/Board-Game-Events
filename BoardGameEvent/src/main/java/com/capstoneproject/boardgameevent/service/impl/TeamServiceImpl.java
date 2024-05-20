package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.Team;
import com.capstoneproject.boardgameevent.repository.TeamRepository;
import com.capstoneproject.boardgameevent.service.AbstractSrdServiceImpl;
import com.capstoneproject.boardgameevent.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;

@AllArgsConstructor
public class TeamServiceImpl extends AbstractSrdServiceImpl<Integer, Team> implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    protected CrudRepository<Team, Integer> getRepository() {
        return teamRepository;
    }

    @Override
    protected Class<Team> getEntityClass() {
        return Team.class;
    }

    @Override
    public Team save(Team entity) {
        return teamRepository.save(entity);
    }
}
