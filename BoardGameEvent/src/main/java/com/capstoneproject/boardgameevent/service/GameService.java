package com.capstoneproject.boardgameevent.service;

import com.capstoneproject.boardgameevent.entity.Game;

import java.util.List;

public interface GameService extends SrdService<Integer, Game> {

    Game update(Game event);

    Game save(Game event);

}
