package com.capstoneproject.boardgameevent.security;

import com.capstoneproject.boardgameevent.entity.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String email;
    private String password;
    private String username;


    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(email, passwordEncoder.encode(password), username);
    }
}
