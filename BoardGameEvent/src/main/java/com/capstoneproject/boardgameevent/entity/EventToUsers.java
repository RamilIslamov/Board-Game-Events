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
@Table(name = "users_events")
public class EventToUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer usersEventsId;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "user_id")
    private Long userId;
}
