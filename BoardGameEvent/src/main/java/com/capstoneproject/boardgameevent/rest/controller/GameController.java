package com.capstoneproject.boardgameevent.rest.controller;

import com.capstoneproject.boardgameevent.entity.Duration;
import com.capstoneproject.boardgameevent.entity.Genre;
import com.capstoneproject.boardgameevent.entity.People;
import com.capstoneproject.boardgameevent.rest.converter.GameConverter;
import com.capstoneproject.boardgameevent.rest.model.Game;
import com.capstoneproject.boardgameevent.rest.model.GameForm;
import com.capstoneproject.boardgameevent.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.capstoneproject.boardgameevent.entity.Genre.toList;
import static com.capstoneproject.boardgameevent.web.Pages.GAMES;

@Controller
@RequestMapping(path = "/games")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    private final GameConverter gameConverter;

    @GetMapping
    public String index(Model model) {
        List<Game> games = gameConverter.convert(gameService.findAllByCreationDate());
        List<Game> allGames = gameConverter.convert(gameService.findAll());
        List<Genre> genres = toList();
        List<Duration> durations = Duration.toList();
        List<People> people = People.toList();

        model.addAttribute("games", games);
        model.addAttribute("allGames", allGames);
        model.addAttribute("genres", genres);
        model.addAttribute("durations", durations);
        model.addAttribute("people", people);
        return GAMES;
    }

    @PostMapping
    public String create(GameForm form) {
        Game api = form.toGame();
        com.capstoneproject.boardgameevent.entity.Game entity = gameConverter.convert(api);
        gameService.save(entity);
        return "redirect:" + GAMES;
    }
}
