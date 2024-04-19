package com.capstoneproject.boardgameevent.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    private String name;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private int players;
    private int rating;
}
