package com.capstoneproject.boardgameevent.repository;

import com.capstoneproject.boardgameevent.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
