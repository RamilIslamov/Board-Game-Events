package com.capstoneproject.boardgameevent.repository;

import com.capstoneproject.boardgameevent.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
