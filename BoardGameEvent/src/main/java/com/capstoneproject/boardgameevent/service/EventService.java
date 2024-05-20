package com.capstoneproject.boardgameevent.service;

import com.capstoneproject.boardgameevent.entity.Event;
import com.capstoneproject.boardgameevent.rest.model.ExitForm;
import com.capstoneproject.boardgameevent.rest.model.ParticipateForm;
import com.capstoneproject.boardgameevent.rest.model.RateForm;
import com.capstoneproject.boardgameevent.rest.model.SearchEventForm;

import java.util.List;

public interface EventService extends SrdService<Integer, Event> {

    Event update(Event event);

    Event save(Event event);

    void participate(ParticipateForm form);

    void exit(ExitForm form);

    void rate(RateForm form);

    List<Event> findMyEvents();

    List<Event> findAllByRating();

    List<Event> findAllByDate();

    List<Event> search(SearchEventForm form);

}
