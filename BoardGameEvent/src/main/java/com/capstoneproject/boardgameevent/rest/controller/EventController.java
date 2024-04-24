package com.capstoneproject.boardgameevent.rest.controller;

import com.capstoneproject.boardgameevent.repository.EventRepository;
import com.capstoneproject.boardgameevent.rest.converter.EventConverter;
import com.capstoneproject.boardgameevent.rest.model.Event;
import com.capstoneproject.boardgameevent.service.EventService;
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
public class EventController {

    private final EventService eventService;

    private final EventConverter eventConverter;

    private final EventRepository eventRepository;

    public EventController(final EventService eventService,
                           final EventConverter eventConverter,
                           final EventRepository eventRepository) {
        this.eventService = requireNonNull(eventService,
                                           "eventService is required to be not null");
        this.eventConverter = requireNonNull(eventConverter,
                                             "eventConverter is required to be not null");
        this.eventRepository = requireNonNull(eventRepository,
                                              "eventRepository is required to be not null");

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> findById(@PathVariable Integer id) {
        requireNonNull(id, "id parameter is required");

        return ok(eventConverter.convert(eventService.getById(id)));
    }

    @GetMapping
    public String index(Model model) {
        List<Event> events = eventConverter.convert(eventService.findAll());
        events.sort(Comparator.comparingDouble(Event::getRating));
        model.addAttribute("events", events);
        return "/events";
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event api) {
        com.capstoneproject.boardgameevent.entity.Event entity = eventConverter.convert(api);

        return ok(eventConverter.convert(eventService.save(entity)));
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
