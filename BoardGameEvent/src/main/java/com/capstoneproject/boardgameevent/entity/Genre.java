package com.capstoneproject.boardgameevent.entity;

import java.util.Arrays;
import java.util.List;

public enum Genre {
    STRATEGY("Strategy"),
    ACTION("Action"),
    QUEST("Quest"),
    ADVENTURE("Adventure"),
    DETECTIVE("Detective"),
    CARD("Card"),
    FAMILY("Family"),
    CLASSIC("Classic");

    private final String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static List<Genre> toList() {
        return Arrays.asList(Genre.values());
    }
}
