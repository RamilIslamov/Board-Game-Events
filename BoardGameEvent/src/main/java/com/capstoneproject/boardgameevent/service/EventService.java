package com.capstoneproject.boardgameevent.service;

import com.capstoneproject.boardgameevent.entity.Event;
import com.capstoneproject.boardgameevent.rest.model.ParticipateForm;

import java.util.List;

public interface EventService extends SrdService<Integer, Event> {

    Event update(Event event);

    Event save(Event event);

    Event update(ParticipateForm form);

    List<Event> findMyEvents();

    List<Event> findAllByRating();
}
