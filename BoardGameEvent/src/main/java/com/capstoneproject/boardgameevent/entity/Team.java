package com.capstoneproject.boardgameevent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "team_name")
    private String name;

    @Column(name = "leader")
    private String leader;

    @Column(name = "members_amount")
    private Integer membersAmount;

    @Column(name = "events_visited")
    private Integer visited = 0;

    @Column(name = "games_played")
    private Integer played = 0;

    @Column(name = "games_won")
    private Integer wins = 0;

    @Column(name = "password")
    private String teamPassword;
}
