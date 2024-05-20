package com.capstoneproject.boardgameevent.repository;

import com.capstoneproject.boardgameevent.entity.EventToUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventsToUsersRepository extends JpaRepository<EventToUsers, Integer> {

    @Query("SELECT e.eventId FROM EventToUsers e WHERE e.userId = :userId")
    List<Integer> findEventIdsByUserId(@Param("userId") Long userId);

    @Query("SELECT e FROM EventToUsers e WHERE e.userId = :userId AND e.eventId = :eventId")
    EventToUsers findByUserIdAndEventId(@Param("userId") Long userId, @Param("eventId") Integer eventId);

    boolean existsByUserIdAndEventId(Long userId, Integer eventId);

}
