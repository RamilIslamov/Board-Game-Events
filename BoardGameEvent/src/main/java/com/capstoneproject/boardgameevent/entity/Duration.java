package com.capstoneproject.boardgameevent.entity;

import java.util.Arrays;
import java.util.List;

public enum Duration {
    LESS_THAN_HOUR("Less than 1 hour"),
    BETWEEN_1_HOUR_AND_3_HOURS("Between 1 hour and 3 hours"),
    MORE_THAN_3_HOURS("More than 3 hours");

    private final String description;

    Duration(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static List<Duration> toList() {
        return Arrays.asList(Duration.values());
    }

}
