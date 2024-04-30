package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.Event;
import com.capstoneproject.boardgameevent.exception.DataAccessException;
import com.capstoneproject.boardgameevent.repository.EventRepository;
import com.capstoneproject.boardgameevent.rest.model.ParticipateForm;
import com.capstoneproject.boardgameevent.service.AbstractSrdServiceImpl;
import com.capstoneproject.boardgameevent.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;

@AllArgsConstructor
public class EventServiceImpl extends AbstractSrdServiceImpl<Integer, Event> implements EventService {

    private final EventRepository eventRepository;

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

    @Override
    public Event save(Event entity) {
        return eventRepository.save(entity);
    }

    @Override
    public Event update(ParticipateForm form) {
        Integer id = Integer.parseInt(form.getEventId());
        Event event = getById(id);

        Integer currPlayers = event.getCurrPlayers();
        Integer formAmount = Integer.parseInt(form.getEventPeople());

        if (currPlayers + formAmount > event.getPlayers()) {
            throw new DataAccessException("Only " + (event.getPlayers() - currPlayers) + " more people can participate in this event");
        }
        event.setCurrPlayers(currPlayers + formAmount);
        return event;
    }
}
