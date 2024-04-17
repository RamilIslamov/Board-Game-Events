package com.capstoneproject.boardgameevent.security;

import com.capstoneproject.boardgameevent.entity.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String email;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(email, password, username);
    }
}
