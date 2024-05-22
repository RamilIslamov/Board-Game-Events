package com.capstoneproject.boardgameevent.rest.controller;

import com.capstoneproject.boardgameevent.exception.ActionAlreadyPerformedException;
import com.capstoneproject.boardgameevent.rest.converter.EventConverter;
import com.capstoneproject.boardgameevent.rest.converter.GameConverter;
import com.capstoneproject.boardgameevent.rest.model.Event;
import com.capstoneproject.boardgameevent.rest.model.EventForm;
import com.capstoneproject.boardgameevent.rest.model.ExitForm;
import com.capstoneproject.boardgameevent.rest.model.Game;
import com.capstoneproject.boardgameevent.rest.model.ParticipateForm;
import com.capstoneproject.boardgameevent.rest.model.RateForm;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.capstoneproject.boardgameevent.web.Pages.EVENTS;
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
        List<Event> events = eventConverter.convert(eventService.findAllByRating());
        List<Event> closestEvents = eventConverter.convert(eventService.findAllByDate());
        List<Event> userEvents = eventConverter.convert(eventService.findMyEvents());
        List<Game> games = gameConverter.convert(gameService.findAll());

        model.addAttribute("events", events);
        model.addAttribute("games", games);
        model.addAttribute("userEvents", userEvents);
        model.addAttribute("closestEvents", closestEvents);
        return EVENTS;
    }

    @PostMapping
    public String create(EventForm form) {
        Event api = form.toEvent();
        com.capstoneproject.boardgameevent.entity.Event entity = eventConverter.convert(api);
        eventService.save(entity);
        return "redirect:" + EVENTS;
    }

    @PostMapping("/participate")
    public String participate(ParticipateForm form, RedirectAttributes redirectAttributes) {
        try {
            eventService.participate(form);
        } catch (ActionAlreadyPerformedException e) {
            redirectAttributes.addFlashAttribute("errorParticipate", e.getMessage());
            return "redirect:" + EVENTS;
        }
        return "redirect:" + EVENTS;
    }

    @PostMapping("/exit")
    public String exit(ExitForm form) {
        eventService.exit(form);
        return "redirect:" + EVENTS;
    }

    @PostMapping("/rate")
    public String rate(RateForm form, RedirectAttributes redirectAttributes) {
        try {
            eventService.rate(form);
        } catch (ActionAlreadyPerformedException e) {
            redirectAttributes.addFlashAttribute("errorRate", e.getMessage());
            return "redirect:" + EVENTS;
        }
        return "redirect:" + EVENTS;
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
