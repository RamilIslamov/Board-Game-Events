package com.capstoneproject.boardgameevent.rest.converter.impl;

import com.capstoneproject.boardgameevent.entity.Event;
import com.capstoneproject.boardgameevent.rest.converter.EventConverter;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class EventConverterImpl implements EventConverter {

    @Override
    public Event convert(com.capstoneproject.boardgameevent.rest.model.Event api) {
        if (null == api) {
            return null;
        }
        Event entity = new Event();
        entity.setName(api.getName());
        entity.setDescription(api.getDescription());
        entity.setLocation(api.getLocation());
        entity.setEventDate(api.getDateTime());
        entity.setPlayers(api.getPlayers());
        entity.setCurrPlayers(api.getCurrPlayers());
        entity.setGameId(api.getGameId());
        return entity;
    }

    @Override
    public com.capstoneproject.boardgameevent.rest.model.Event convert(Event entity) {
        if (null == entity) {
            return null;
        }
        com.capstoneproject.boardgameevent.rest.model.Event api = new com.capstoneproject.boardgameevent.rest.model.Event();
        api.setName(entity.getName());
        api.setDescription(entity.getDescription());
        api.setLocation(entity.getLocation());
        api.setPlayers(entity.getPlayers());
        api.setDateTime(entity.getEventDate());
        api.setId(entity.getEvent_id());
        api.setCurrPlayers(entity.getCurrPlayers());
        api.setGameId(entity.getGameId());
        api.setRating(entity.getRating());
        return api;
    }

    @Override
    public List<com.capstoneproject.boardgameevent.rest.model.Event> convert(List<Event> events) {
        if (null == events) {
            return emptyList();
        }
        return events.stream().map(this::convert).collect(toList());
    }

}
