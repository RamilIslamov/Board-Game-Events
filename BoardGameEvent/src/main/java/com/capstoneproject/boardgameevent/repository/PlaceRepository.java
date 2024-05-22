package com.capstoneproject.boardgameevent.repository;

import com.capstoneproject.boardgameevent.entity.Place;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlaceRepository extends CrudRepository<Place, Integer>, QuerydslPredicateExecutor<Place> {

    Optional<Place> findByName(String name);

}
