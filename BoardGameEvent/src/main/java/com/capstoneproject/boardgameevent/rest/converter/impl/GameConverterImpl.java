package com.capstoneproject.boardgameevent.rest.converter.impl;

import com.capstoneproject.boardgameevent.entity.Game;
import com.capstoneproject.boardgameevent.rest.converter.GameConverter;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class GameConverterImpl implements GameConverter {

    @Override
    public Game convert(com.capstoneproject.boardgameevent.rest.model.Game api) {
        if (null == api) {
            return null;
        }
        Game entity = new Game();
        entity.setName(api.getName());
        entity.setEquipment(api.getEquipment());
        entity.setRules(api.getRules());
        entity.setId(api.getId());
        entity.setMaxPlayers(api.getMaxPlayers());
        entity.setRoundDuration(api.getRoundDuration());
        entity.setGenre(api.getGenre());
        entity.setCreationDate(api.getCreationDate());
        return entity;
    }

    @Override
    public com.capstoneproject.boardgameevent.rest.model.Game convert(Game entity) {
        if (null == entity) {
            return null;
        }
        com.capstoneproject.boardgameevent.rest.model.Game api = new com.capstoneproject.boardgameevent.rest.model.Game();
        api.setName(entity.getName());
        api.setEquipment(entity.getEquipment());
        api.setRules(entity.getRules());
        api.setRoundDuration(entity.getRoundDuration());
        api.setMaxPlayers(entity.getMaxPlayers());
        api.setId(entity.getId());
        api.setGenre(entity.getGenre());
        api.setCreationDate(entity.getCreationDate());
        return api;
    }

    @Override
    public List<com.capstoneproject.boardgameevent.rest.model.Game> convert(List<Game> events) {
        if (null == events) {
            return emptyList();
        }
        return events.stream().map(this::convert).collect(toList());
    }
}
