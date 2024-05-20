package com.capstoneproject.boardgameevent.rest.converter;

import com.capstoneproject.boardgameevent.entity.Game;

import java.util.List;

public interface GameConverter {

    Game convert(com.capstoneproject.boardgameevent.rest.model.Game api);

    com.capstoneproject.boardgameevent.rest.model.Game convert(Game entity);

    List<com.capstoneproject.boardgameevent.rest.model.Game> convert(List<Game> games);
}
