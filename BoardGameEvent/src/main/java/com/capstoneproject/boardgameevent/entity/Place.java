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

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "place_name")
    private String name;

    @Column(name = "rating")
    private Float raing = 0F;

    @Column(name = "hosted")
    private Integer hosted = 0;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "users_voted")
    private Integer usersVoted = 0;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private Set<RatingPlace> userRatingPlace;

}
