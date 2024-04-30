package com.capstoneproject.boardgameevent.configuration;

import com.capstoneproject.boardgameevent.repository.EventRepository;
import com.capstoneproject.boardgameevent.repository.GameRepository;
import com.capstoneproject.boardgameevent.rest.converter.EventConverter;
import com.capstoneproject.boardgameevent.rest.converter.GameConverter;
import com.capstoneproject.boardgameevent.rest.converter.impl.EventConverterImpl;
import com.capstoneproject.boardgameevent.rest.converter.impl.GameConverterImpl;
import com.capstoneproject.boardgameevent.service.EventService;
import com.capstoneproject.boardgameevent.service.GameService;
import com.capstoneproject.boardgameevent.service.impl.EventServiceImpl;
import com.capstoneproject.boardgameevent.service.impl.GameServiceImpl;
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

    @Bean
    public GameConverter initGameConvertor() {
        return new GameConverterImpl();
    }

    @Bean
    public GameService initGameService(GameRepository gameRepository) {
        return new GameServiceImpl(gameRepository);
    }

}
