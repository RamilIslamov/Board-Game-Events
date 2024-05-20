package com.capstoneproject.boardgameevent.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;

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
    private Float rating = 0F;

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "users_voted")
    private Integer usersVoted = 0;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<Rating> userRatings;

}
