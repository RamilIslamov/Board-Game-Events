package com.capstoneproject.boardgameevent.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    private int id;
    private String name;
    private int maxPlayers;
    private int roundDuration;
    private String equipment;
    private String rules;
}
