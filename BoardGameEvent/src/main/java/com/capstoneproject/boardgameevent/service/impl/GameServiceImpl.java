package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.Duration;
import com.capstoneproject.boardgameevent.entity.Game;
import com.capstoneproject.boardgameevent.entity.People;
import com.capstoneproject.boardgameevent.repository.GameRepository;
import com.capstoneproject.boardgameevent.rest.model.SearchGameForm;
import com.capstoneproject.boardgameevent.service.AbstractSrdServiceImpl;
import com.capstoneproject.boardgameevent.service.GameService;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.capstoneproject.boardgameevent.entity.QGame.game;
import static com.querydsl.core.types.ExpressionUtils.and;
import static org.apache.commons.collections4.IterableUtils.toList;

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
    public Game save(Game entity) {
        return gameRepository.save(entity);
    }

    @Override
    public List<Game> search(SearchGameForm form) {
        Predicate predicate = null;

        if (null != form.getSearchTitle()) {
            String searchTitle = form.getSearchTitle().toLowerCase();
            predicate = and(null, game.name.toLowerCase().contains(searchTitle));
        }

        if (null != form.getSearchDuration()) {
            Duration duration = form.getSearchDuration();
            if (Duration.LESS_THAN_HOUR.equals(duration)) {
                predicate = and(predicate, game.roundDuration.loe(60));
            }
            if (Duration.BETWEEN_1_HOUR_AND_3_HOURS.equals(duration)) {
                predicate = and(predicate, game.roundDuration.between(61, 180));
            }
            if (Duration.MORE_THAN_3_HOURS.equals(duration)) {
                predicate = and(predicate, game.roundDuration.goe(181));
            }
        }

        if (null != form.getSearchGenre()) {
            predicate = and(predicate, game.genre.eq(form.getSearchGenre()));
        }

        if (null != form.getPlayers()) {
            People players = form.getPlayers();
            if (People.TWO_OR_LESS.equals(players)) {
                predicate = and(predicate, game.maxPlayers.loe(2));
            }
            if (People.UP_TO_4.equals(players)) {
                predicate = and(predicate, game.maxPlayers.loe(4));
            }
            if (People.UP_TO_6.equals(players)) {
                predicate = and(predicate, game.maxPlayers.loe(6));
            }
            if (People.MORE_THAN_6.equals(players)) {
                predicate = and(predicate, game.maxPlayers.goe(7));
            }
        }

        return toList(gameRepository.findAll(predicate));
    }

    @Override
    public List<Game> findAllByCreationDate() {
        return findAll().stream()
                        .sorted(Comparator.comparing(Game::getCreationDate))
                        .collect(Collectors.toList());
    }
}
