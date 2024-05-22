package com.capstoneproject.boardgameevent.service;

import com.capstoneproject.boardgameevent.entity.Place;
import com.capstoneproject.boardgameevent.rest.model.RateForm;

import java.util.Optional;

public interface PlaceService extends SrdService<Integer, Place> {

    Optional<Place> findByName(String name);

    void throwOrSave(Place place);

    void rate(RateForm form);
}
