package com.capstoneproject.boardgameevent.rest.model;

import com.capstoneproject.boardgameevent.entity.Genre;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GameForm {

    String gameName;
    String gamePeople;
    String gameGenre;
    String gameDuration;
    String gameEquipment;
    String gameRules;

    public Game toGame() {
        Game game = new Game();
        game.setName(gameName);
        game.setMaxPlayers(Integer.parseInt(gamePeople));
        game.setRoundDuration(Integer.parseInt(gameDuration));
        game.setEquipment(gameEquipment);
        game.setRules(gameRules);
        game.setGenre(Genre.valueOf(gameGenre));
        game.setCreationDate(LocalDateTime.now());
        return game;
    }
}
