package com.capstoneproject.boardgameevent.rest.controller;

import com.capstoneproject.boardgameevent.exception.DataAccessException;
import com.capstoneproject.boardgameevent.repository.EventRepository;
import com.capstoneproject.boardgameevent.rest.converter.EventConverter;
import com.capstoneproject.boardgameevent.rest.model.Event;
import com.capstoneproject.boardgameevent.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.text.MessageFormat.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Validated
@RestController
@RequestMapping(path = "/events",
                produces = APPLICATION_JSON_VALUE,
                consumes = APPLICATION_JSON_VALUE)
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

    @PreAuthorize("hasRole('USER')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> findById(@PathVariable Integer id) {
        requireNonNull(id, "id parameter is required");

        return ok(eventConverter.convert(eventService.getById(id)));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<Event>> findAll() {
        return ok(eventConverter.convert(eventService.findAll()));
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping
    public ResponseEntity<Event> create(@RequestBody Event api) {
        com.capstoneproject.boardgameevent.entity.Event entity = eventConverter.convert(api);

        if (eventService.existsById(entity.getId())) {
            throw new DataAccessException(format("Event with ID {0} already exist.",
                                                 entity.getId()));
        }

        return ok(eventConverter.convert(eventService.save(entity)));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<Event> update(@RequestBody Event api) {

        return ok(eventConverter.convert(eventService.update(eventConverter.convert(api))));
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER') or hasRole('ROOT') or hasRole('SUPERVISOR') or hasRole('USER') or hasRole('SERVICE') or hasRole('VIEWER')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Event> delete(@PathVariable Integer id) {
        return ok(eventConverter.convert(eventService.delete(id)));
    }
}
