package com.capstoneproject.boardgameevent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "events")
public class Event {

    @ManyToMany(mappedBy = "usersToEvents")
    Set<User> users = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer event_id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    @Column(name = "players")
    private Integer players;

    @Column(name = "curr_players")
    private Integer currPlayers = 0;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "game_id")
    private Integer gameId;

}
