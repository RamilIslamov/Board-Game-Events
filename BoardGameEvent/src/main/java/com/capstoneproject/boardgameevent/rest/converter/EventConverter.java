package com.capstoneproject.boardgameevent.rest.converter;

import com.capstoneproject.boardgameevent.entity.Event;

import java.util.List;

public interface EventConverter {

    Event convert(com.capstoneproject.boardgameevent.rest.model.Event api);

    com.capstoneproject.boardgameevent.rest.model.Event convert(Event entity);

    List<com.capstoneproject.boardgameevent.rest.model.Event> convert(List<Event> events);
}
