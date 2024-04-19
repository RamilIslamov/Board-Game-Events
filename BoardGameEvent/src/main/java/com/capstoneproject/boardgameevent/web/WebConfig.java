package com.capstoneproject.boardgameevent.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/games").setViewName("games");
        registry.addViewController("/places").setViewName("places");
        registry.addViewController("/teams").setViewName("teams");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/styles/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/styles/img/**")
                .addResourceLocations("classpath:/static/img/");
    }
}
