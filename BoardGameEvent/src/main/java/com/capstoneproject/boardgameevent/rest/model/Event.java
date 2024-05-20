package com.capstoneproject.boardgameevent.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    private Integer id;
    private String name;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private Integer players;
    private Integer currPlayers;
    private Float rating;
    private Integer gameId;

    public boolean isRateable() {
        return dateTime.isBefore(LocalDateTime.now());
    }
}
