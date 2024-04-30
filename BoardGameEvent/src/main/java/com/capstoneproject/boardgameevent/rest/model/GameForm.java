package com.capstoneproject.boardgameevent.rest.model;

import lombok.Data;

@Data
public class GameForm {

    String name;
    String maxPlayers;
    String roundDuration;
    String equipment;
    String rules;

    public Game toGame() {
        Game event = new Game();
        event.setName(name);
        event.setMaxPlayers(Integer.parseInt(maxPlayers));
        event.setRoundDuration(Integer.parseInt(roundDuration));
        event.setEquipment(equipment);
        event.setRules(rules);
        return event;
    }
}
