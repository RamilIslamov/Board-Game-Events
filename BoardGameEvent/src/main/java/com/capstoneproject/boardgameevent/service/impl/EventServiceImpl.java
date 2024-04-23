package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.Event;
import com.capstoneproject.boardgameevent.repository.EventRepository;
import com.capstoneproject.boardgameevent.service.AbstractSrdServiceImpl;
import com.capstoneproject.boardgameevent.service.EventService;
import org.springframework.data.repository.CrudRepository;

public class EventServiceImpl extends AbstractSrdServiceImpl<Integer, Event> implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    protected CrudRepository<Event, Integer> getRepository() {
        return eventRepository;
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
