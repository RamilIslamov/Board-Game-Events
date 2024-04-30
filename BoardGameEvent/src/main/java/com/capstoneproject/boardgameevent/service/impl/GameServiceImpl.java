package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.Game;
import com.capstoneproject.boardgameevent.repository.GameRepository;
import com.capstoneproject.boardgameevent.service.AbstractSrdServiceImpl;
import com.capstoneproject.boardgameevent.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GameServiceImpl extends AbstractSrdServiceImpl<Integer, Game> implements GameService {

    private final GameRepository gameRepository;

    @Override
    protected CrudRepository<Game, Integer> getRepository() {
        return gameRepository;
    }

    @Override
    protected Class<Game> getEntityClass() {
        return Game.class;
    }

    @Override
    public Game update(Game game) {
        if (null == game) {
            return null;
        }
        Game entity = getById(game.getId());
        entity.setRoundDuration(game.getRoundDuration());
        entity.setName(game.getName());
        entity.setRules(game.getRules());
        entity.setMaxPlayers(game.getMaxPlayers());
        entity.setEquipment(game.getEquipment());

        return entity;
    }

    @Override
    public Game save(Game entity) {
        return gameRepository.save(entity);
    }

}
