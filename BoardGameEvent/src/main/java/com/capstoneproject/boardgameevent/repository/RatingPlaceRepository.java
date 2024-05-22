package com.capstoneproject.boardgameevent.repository;

import com.capstoneproject.boardgameevent.entity.RatingPlace;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RatingPlaceRepository extends CrudRepository<RatingPlace, Integer> {

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM RatingPlace r WHERE r.user.userId = :userId AND r.place.id = :placeId")
    boolean existsByUserIdAndEventId(@Param("userId") Long userId, @Param("placeId") Integer placeId);

}
