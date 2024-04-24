package com.capstoneproject.boardgameevent.service;

import com.capstoneproject.boardgameevent.entity.Event;

public interface EventService extends SrdService<Integer, Event> {

    Event update(Event event);

    Event save(Event event);
}
