package com.capstoneproject.boardgameevent.rest.controller;

import com.capstoneproject.boardgameevent.rest.converter.EventConverter;
import com.capstoneproject.boardgameevent.rest.converter.GameConverter;
import com.capstoneproject.boardgameevent.rest.model.Event;
import com.capstoneproject.boardgameevent.rest.model.Game;
import com.capstoneproject.boardgameevent.rest.model.SearchEventForm;
import com.capstoneproject.boardgameevent.rest.model.SearchGameForm;
import com.capstoneproject.boardgameevent.service.EventService;
import com.capstoneproject.boardgameevent.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class SearchController {

    private final EventService eventService;
    private final EventConverter eventConverter;
    private final GameService gameService;
    private final GameConverter gameConverter;

    @PostMapping("/search-events")
    public String search(SearchEventForm form, RedirectAttributes redirectAttributes) {
        form.transformData();
        List<Event> searchResults = eventConverter.convert(eventService.search(form));
        redirectAttributes.addFlashAttribute("searchResults", searchResults);
        return "redirect:/search-events/results";
    }

    @PostMapping("/search-games")
    public String search(SearchGameForm form, RedirectAttributes redirectAttributes) {
        form.transformData();
        List<Game> searchResults = gameConverter.convert(gameService.search(form));
        redirectAttributes.addFlashAttribute("searchResults", searchResults);
        return "redirect:/search-games/results";
    }

    @GetMapping("/search-events/results")
    public String showEventsSearchResults(Model model) {
        // searchResults will be available in the model if it was added via addFlashAttribute
        return "search-events";
    }

    @GetMapping("/search-games/results")
    public String showGamesSearchResults(Model model) {
        // searchResults will be available in the model if it was added via addFlashAttribute
        return "search-games";
    }
}
