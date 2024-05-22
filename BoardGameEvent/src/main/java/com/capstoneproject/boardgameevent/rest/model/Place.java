package com.capstoneproject.boardgameevent.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    private Integer id;
    private String name;
    private Float rating;
    private Integer hosted;
    private String location;
    private String description;
}
