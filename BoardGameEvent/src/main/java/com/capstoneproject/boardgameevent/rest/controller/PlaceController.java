package com.capstoneproject.boardgameevent.rest.controller;

import com.capstoneproject.boardgameevent.exception.ActionAlreadyPerformedException;
import com.capstoneproject.boardgameevent.rest.converter.PlaceConverter;
import com.capstoneproject.boardgameevent.rest.model.Place;
import com.capstoneproject.boardgameevent.rest.model.PlaceForm;
import com.capstoneproject.boardgameevent.rest.model.RateForm;
import com.capstoneproject.boardgameevent.service.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.capstoneproject.boardgameevent.web.Pages.PLACES;

@Controller
@RequestMapping(path = "/places")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    private final PlaceConverter placeConverter;

    @GetMapping
    public String index(Model model) {
        List<Place> places = placeConverter.convert(placeService.findAll());

        model.addAttribute("places", places);
        return PLACES;
    }

    @PostMapping
    public ResponseEntity<String> create(PlaceForm form) {
        try {
            Place place = form.toPlace();
            com.capstoneproject.boardgameevent.entity.Place entity = placeConverter.convert(place);
            placeService.throwOrSave(entity);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("Place created successfully");
    }

    @PostMapping("/rate")
    public String rate(RateForm form, RedirectAttributes redirectAttributes) {
        try {
            placeService.rate(form);
        } catch (ActionAlreadyPerformedException e) {
            redirectAttributes.addFlashAttribute("errorRate", e.getMessage());
            return "redirect:" + PLACES;
        }
        return "redirect:" + PLACES;
    }
}
