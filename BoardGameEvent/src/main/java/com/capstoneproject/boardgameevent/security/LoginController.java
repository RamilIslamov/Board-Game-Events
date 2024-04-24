package com.capstoneproject.boardgameevent.security;

import com.capstoneproject.boardgameevent.entity.User;
import com.capstoneproject.boardgameevent.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String index() {
        return "/login";
    }

    @PostMapping
    public String verifyUser(LoginForm form) {
        Optional<User> user = userRepo.findByUsername(form.getUsername());
        if (user.isPresent()) {
            if (passwordEncoder.matches(form.getPassword(), user.get().getPassword())) {
                return "redirect:events";
            }
            return "redirect:login";
        }
        return "redirect:register";
    }
}
