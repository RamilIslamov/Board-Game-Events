package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.Event;
import com.capstoneproject.boardgameevent.repository.EventRepository;
import com.capstoneproject.boardgameevent.service.AbstractSrdServiceImpl;
import com.capstoneproject.boardgameevent.service.EventService;

public class EventServiceImpl extends AbstractSrdServiceImpl<Integer, Event> implements EventService {

    public EventServiceImpl(final EventRepository eventRepository) {
        super(eventRepository);
    }

    @Override
    protected Class<Event> getEntityClass() {
        return Event.class;
    }

    @Override
    public Event update(Event event) {
        if (null == event) {
            return null;
        }
        Event entity = getById(event.getId());
        entity.setPlayers(event.getPlayers());
        entity.setName(event.getName());
        entity.setEventDate(event.getEventDate());
        entity.setLocation(event.getLocation());
        entity.setDescription(event.getDescription());

        return entity;
    }
}
