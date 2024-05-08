package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.Event;
import com.capstoneproject.boardgameevent.entity.User;
import com.capstoneproject.boardgameevent.repository.EventRepository;
import com.capstoneproject.boardgameevent.rest.model.ParticipateForm;
import com.capstoneproject.boardgameevent.service.AbstractSrdServiceImpl;
import com.capstoneproject.boardgameevent.service.EventService;
import com.capstoneproject.boardgameevent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class EventServiceImpl extends AbstractSrdServiceImpl<Integer, Event> implements EventService {

    private final EventRepository eventRepository;

    private final UserService userService;

    @Override
    protected CrudRepository<Event, Integer> getRepository() {
        return eventRepository;
    }

    @Override
    protected Class<Event> getEntityClass() {
        return Event.class;
    }

    @Override
    @Transactional
    public Event update(Event event) {
        if (null == event) {
            return null;
        }
        Event entity = getById(event.getEvent_id());
        entity.setPlayers(event.getPlayers());
        entity.setName(event.getName());
        entity.setEventDate(event.getEventDate());
        entity.setLocation(event.getLocation());
        entity.setDescription(event.getDescription());

        return entity;
    }

    @Override
    @Transactional
    public Event save(Event entity) {
        return eventRepository.save(entity);
    }

    @Override
    @Transactional
    public Event update(ParticipateForm form) {
        Integer id = Integer.parseInt(form.getEventId());
        Event event = getById(id);

        Integer currPlayers = event.getCurrPlayers();

        event.setCurrPlayers(currPlayers + 1);
        User user = userService.getUser();
        user.getUsersToEvents().add(event);

        return event;
    }

    @Override
    public List<Event> findMyEvents() {
        return new ArrayList<>(userService.getUser().getUsersToEvents());
    }

    @Override
    public List<Event> findAllByRating() {
        return findAll().stream()
                        .sorted((e1, e2) -> Float.compare(e1.getRating(), e2.getRating()))
                        .collect(toList());
    }

}
