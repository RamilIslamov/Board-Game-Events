package com.capstoneproject.boardgameevent.repository;

import com.capstoneproject.boardgameevent.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
