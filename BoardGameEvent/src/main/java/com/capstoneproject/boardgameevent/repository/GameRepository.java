package com.capstoneproject.boardgameevent.repository;

import com.capstoneproject.boardgameevent.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {

}
