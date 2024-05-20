package com.capstoneproject.boardgameevent.rest.model;

import com.capstoneproject.boardgameevent.entity.Duration;
import com.capstoneproject.boardgameevent.entity.Genre;
import com.capstoneproject.boardgameevent.entity.People;
import lombok.Data;

@Data
public class SearchGameForm {

    String searchTitle;
    String genre;
    String duration;
    String maxPlayers;

    Genre searchGenre;
    People players;
    Duration searchDuration;

    public void transformData() {
        if (null != genre && !genre.isBlank()) {
            searchGenre = Genre.valueOf(genre);
        }
        if (null != duration && !duration.isBlank()) {
            searchDuration = Duration.valueOf(duration);
        }
        if (null != maxPlayers && !maxPlayers.isBlank()) {
            players = People.valueOf(maxPlayers);
        }

    }
}
