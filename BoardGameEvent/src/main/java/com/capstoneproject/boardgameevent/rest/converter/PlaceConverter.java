package com.capstoneproject.boardgameevent.rest.converter;

import com.capstoneproject.boardgameevent.entity.Place;

import java.util.List;

public interface PlaceConverter {

    Place convert(com.capstoneproject.boardgameevent.rest.model.Place api);

    com.capstoneproject.boardgameevent.rest.model.Place convert(Place entity);

    List<com.capstoneproject.boardgameevent.rest.model.Place> convert(List<Place> games);

}
