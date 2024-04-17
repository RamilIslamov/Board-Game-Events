package com.capstoneproject.boardgameevent;

import com.capstoneproject.boardgameevent.configuration.BeanConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({BeanConfiguration.class})
public class BoardGameEventApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BoardGameEventApplication.class, args);
    }

}
