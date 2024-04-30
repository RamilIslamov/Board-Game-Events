package com.capstoneproject.boardgameevent.rest.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventForm {

    String eventName;
    String eventDescr;
    String eventLocation;
    String eventDate;
    String eventPeople1;
    String gameId;

    public Event toEvent() {
        Event event = new Event();
        event.setName(eventName);
        event.setDescription(eventDescr);
        event.setLocation(eventLocation);
        event.setCurrPlayers(0);
        event.setPlayers(Integer.parseInt(eventPeople1));
        event.setDateTime(LocalDateTime.parse(eventDate));
        event.setGameId(Integer.parseInt(gameId));
        return event;
    }
}
