package com.capstoneproject.boardgameevent.rest.converter.impl;

import com.capstoneproject.boardgameevent.entity.Team;
import com.capstoneproject.boardgameevent.rest.converter.TeamConverter;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class TeamConverterImpl implements TeamConverter {

    @Override
    public Team convert(com.capstoneproject.boardgameevent.rest.model.Team api) {
        if (null == api) {
            return null;
        }
        Team entity = new Team();
        entity.setName(api.getName());
        entity.setLeader(api.getLeader());
        entity.setMembersAmount(api.getMembersAmount());
        entity.setTeamPassword(api.getPassword());
        return entity;
    }

    @Override
    public com.capstoneproject.boardgameevent.rest.model.Team convert(Team entity) {
        if (null == entity) {
            return null;
        }
        com.capstoneproject.boardgameevent.rest.model.Team api = new com.capstoneproject.boardgameevent.rest.model.Team();
        api.setName(entity.getName());
        api.setLeader(entity.getLeader());
        api.setMembersAmount(entity.getMembersAmount());
        api.setPassword(entity.getTeamPassword());
        api.setPlayed(entity.getPlayed());
        api.setWins(entity.getWins());
        api.setVisited(entity.getVisited());
        return api;
    }

    @Override
    public List<com.capstoneproject.boardgameevent.rest.model.Team> convert(List<Team> teams) {
        if (null == teams) {
            return emptyList();
        }
        return teams.stream().map(this::convert).collect(toList());
    }
}
