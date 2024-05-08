package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.User;
import com.capstoneproject.boardgameevent.exception.DataAccessException;
import com.capstoneproject.boardgameevent.repository.UserRepository;
import com.capstoneproject.boardgameevent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username).orElseThrow(DataAccessException::new);
    }
}
