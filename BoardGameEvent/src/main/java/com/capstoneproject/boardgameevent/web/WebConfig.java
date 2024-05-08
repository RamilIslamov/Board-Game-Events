package com.capstoneproject.boardgameevent.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.capstoneproject.boardgameevent.web.Pages.EVENTS;
import static com.capstoneproject.boardgameevent.web.Pages.GAMES;
import static com.capstoneproject.boardgameevent.web.Pages.LOGIN;
import static com.capstoneproject.boardgameevent.web.Pages.PLACES;
import static com.capstoneproject.boardgameevent.web.Pages.TEAMS;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController(LOGIN).setViewName("login");
        registry.addViewController(GAMES).setViewName("games");
        registry.addViewController(PLACES).setViewName("places");
        registry.addViewController(EVENTS).setViewName("events");
        registry.addViewController(TEAMS).setViewName("teams");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/styles/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/styles/img/**")
                .addResourceLocations("classpath:/static/img/");
    }
}
