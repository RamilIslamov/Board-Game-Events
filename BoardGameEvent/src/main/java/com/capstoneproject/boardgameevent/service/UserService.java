package com.capstoneproject.boardgameevent.service;

import com.capstoneproject.boardgameevent.entity.User;
import com.capstoneproject.boardgameevent.security.UserDetailsService;

public interface UserService extends UserDetailsService {

    User getUser();
}
