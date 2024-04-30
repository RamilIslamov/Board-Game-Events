package com.capstoneproject.boardgameevent.rest.controller;

import com.capstoneproject.boardgameevent.rest.converter.EventConverter;
import com.capstoneproject.boardgameevent.rest.converter.GameConverter;
import com.capstoneproject.boardgameevent.rest.model.Event;
import com.capstoneproject.boardgameevent.rest.model.EventForm;
import com.capstoneproject.boardgameevent.rest.model.Game;
import com.capstoneproject.boardgameevent.rest.model.ParticipateForm;
import com.capstoneproject.boardgameevent.service.EventService;
import com.capstoneproject.boardgameevent.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping(path = "/events")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    private final EventConverter eventConverter;

    private final GameService gameService;

    private final GameConverter gameConverter;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> findById(@PathVariable Integer id) {
        requireNonNull(id, "id parameter is required");

        return ok(eventConverter.convert(eventService.getById(id)));
    }

    @GetMapping
    public String index(Model model) {
        List<Event> events = eventConverter.convert(eventService.findAll());
        List<Game> games = gameConverter.convert(gameService.findAll());
        events.sort(Comparator.comparingDouble(Event::getRating));
        model.addAttribute("events", events);
        model.addAttribute("games", games);
        return "/events";
    }

    @PostMapping
    public ResponseEntity<Event> create(EventForm form) {
        Event api = form.toEvent();
        com.capstoneproject.boardgameevent.entity.Event entity = eventConverter.convert(api);
        return ok(eventConverter.convert(eventService.save(entity)));
    }

    @PostMapping("/participate")
    public ResponseEntity<Event> participate(ParticipateForm form) {
        return ok(eventConverter.convert(eventService.update(form)));
    }

    @PutMapping
    public ResponseEntity<Event> update(@RequestBody Event api) {
        return ok(eventConverter.convert(eventService.update(eventConverter.convert(api))));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Event> delete(@PathVariable Integer id) {
        return ok(eventConverter.convert(eventService.delete(id)));
    }
}
