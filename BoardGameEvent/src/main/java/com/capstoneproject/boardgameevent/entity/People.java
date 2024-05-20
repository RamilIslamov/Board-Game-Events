package com.capstoneproject.boardgameevent.entity;

import java.util.Arrays;
import java.util.List;

public enum People {

    TWO_OR_LESS("2 players or less"),
    UP_TO_4("Up to 4 players"),
    UP_TO_6("Up to 6 players"),
    MORE_THAN_6("More than 6 players");

    private final String description;

    People(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static List<People> toList() {
        return Arrays.asList(People.values());
    }

}
