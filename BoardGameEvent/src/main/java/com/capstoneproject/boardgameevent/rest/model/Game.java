package com.capstoneproject.boardgameevent.rest.model;

import com.capstoneproject.boardgameevent.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    private Integer id;
    private String name;
    private Integer maxPlayers;
    private Integer roundDuration;
    private String equipment;
    private String rules;
    private Genre genre;
    private LocalDateTime creationDate;
}
