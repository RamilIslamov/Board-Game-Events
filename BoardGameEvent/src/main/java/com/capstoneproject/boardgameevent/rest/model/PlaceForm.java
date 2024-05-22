package com.capstoneproject.boardgameevent.rest.model;

import lombok.Data;

@Data
public class PlaceForm {

    private String placeName;
    private String placeLocation;
    private String placeDescription;

    public Place toPlace() {
        Place place = new Place();
        place.setLocation(placeLocation);
        place.setName(placeName);
        place.setDescription(placeDescription);
        return place;
    }
}
