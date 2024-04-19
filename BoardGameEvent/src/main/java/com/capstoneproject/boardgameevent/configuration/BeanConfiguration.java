package com.capstoneproject.boardgameevent.configuration;

import com.capstoneproject.boardgameevent.repository.EventRepository;
import com.capstoneproject.boardgameevent.rest.controller.EventController;
import com.capstoneproject.boardgameevent.rest.converter.EventConverter;
import com.capstoneproject.boardgameevent.rest.converter.impl.EventConverterImpl;
import com.capstoneproject.boardgameevent.service.EventService;
import com.capstoneproject.boardgameevent.service.impl.EventServiceImpl;
import org.springframework.context.annotation.Bean;

public class BeanConfiguration {

    @Bean
    public EventService initEventService(EventRepository eventRepository) {
        return new EventServiceImpl(eventRepository);
    }

    @Bean
    public EventConverter initEventConvertor() {
        return new EventConverterImpl();
    }

}
