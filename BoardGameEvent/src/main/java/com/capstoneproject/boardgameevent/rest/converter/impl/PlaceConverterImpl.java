package com.capstoneproject.boardgameevent.rest.converter.impl;

import com.capstoneproject.boardgameevent.entity.Place;
import com.capstoneproject.boardgameevent.rest.converter.PlaceConverter;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class PlaceConverterImpl implements PlaceConverter {

    @Override
    public Place convert(com.capstoneproject.boardgameevent.rest.model.Place api) {
        if (null == api) {
            return null;
        }
        Place entity = new Place();
        entity.setName(api.getName());
        entity.setDescription(api.getDescription());
        entity.setLocation(api.getLocation());
        return entity;
    }

    @Override
    public com.capstoneproject.boardgameevent.rest.model.Place convert(Place entity) {
        if (null == entity) {
            return null;
        }
        com.capstoneproject.boardgameevent.rest.model.Place api = new com.capstoneproject.boardgameevent.rest.model.Place();
        api.setId(entity.getId());
        api.setName(entity.getName());
        api.setDescription(entity.getDescription());
        api.setHosted(entity.getHosted());
        api.setRating(entity.getRaing());
        api.setLocation(entity.getLocation());
        return api;
    }

    @Override
    public List<com.capstoneproject.boardgameevent.rest.model.Place> convert(List<Place> events) {
        if (null == events) {
            return emptyList();
        }
        return events.stream().map(this::convert).collect(toList());
    }
}
