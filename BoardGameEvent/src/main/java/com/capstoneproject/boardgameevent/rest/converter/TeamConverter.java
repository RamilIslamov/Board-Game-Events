package com.capstoneproject.boardgameevent.rest.converter;

import com.capstoneproject.boardgameevent.entity.Team;

import java.util.List;

public interface TeamConverter {

    Team convert(com.capstoneproject.boardgameevent.rest.model.Team api);

    com.capstoneproject.boardgameevent.rest.model.Team convert(Team entity);

    List<com.capstoneproject.boardgameevent.rest.model.Team> convert(List<Team> teams);
}
