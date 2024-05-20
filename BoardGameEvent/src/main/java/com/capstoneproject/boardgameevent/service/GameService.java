package com.capstoneproject.boardgameevent.service;

import com.capstoneproject.boardgameevent.entity.Game;
import com.capstoneproject.boardgameevent.rest.model.SearchGameForm;

import java.util.List;

public interface GameService extends SrdService<Integer, Game> {

    Game save(Game event);

    List<Game> search(SearchGameForm form);

    List<Game> findAllByCreationDate();

}
