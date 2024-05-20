package com.capstoneproject.boardgameevent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "game_name")
    private String name;

    @Column(name = "max_players")
    private Integer maxPlayers;

    @Column(name = "round_duration_min")
    private Integer roundDuration;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "rules")
    private String rules;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}
