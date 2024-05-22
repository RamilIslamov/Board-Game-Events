package com.capstoneproject.boardgameevent.repository;

import com.capstoneproject.boardgameevent.entity.RatingEvent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RatingEventRepository extends CrudRepository<RatingEvent, Integer> {

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM RatingEvent r WHERE r.user.userId = :userId AND r.event.eventId = :eventId")
    boolean existsByUserIdAndEventId(@Param("userId") Long userId, @Param("eventId") Integer eventId);

}
