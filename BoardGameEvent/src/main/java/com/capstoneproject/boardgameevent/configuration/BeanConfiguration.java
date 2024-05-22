package com.capstoneproject.boardgameevent.configuration;

import com.capstoneproject.boardgameevent.repository.EventRepository;
import com.capstoneproject.boardgameevent.repository.EventsToUsersRepository;
import com.capstoneproject.boardgameevent.repository.GameRepository;
import com.capstoneproject.boardgameevent.repository.PlaceRepository;
import com.capstoneproject.boardgameevent.repository.RatingEventRepository;
import com.capstoneproject.boardgameevent.repository.RatingPlaceRepository;
import com.capstoneproject.boardgameevent.repository.TeamRepository;
import com.capstoneproject.boardgameevent.repository.UserRepository;
import com.capstoneproject.boardgameevent.rest.converter.EventConverter;
import com.capstoneproject.boardgameevent.rest.converter.GameConverter;
import com.capstoneproject.boardgameevent.rest.converter.PlaceConverter;
import com.capstoneproject.boardgameevent.rest.converter.TeamConverter;
import com.capstoneproject.boardgameevent.rest.converter.impl.EventConverterImpl;
import com.capstoneproject.boardgameevent.rest.converter.impl.GameConverterImpl;
import com.capstoneproject.boardgameevent.rest.converter.impl.PlaceConverterImpl;
import com.capstoneproject.boardgameevent.rest.converter.impl.TeamConverterImpl;
import com.capstoneproject.boardgameevent.service.EventService;
import com.capstoneproject.boardgameevent.service.GameService;
import com.capstoneproject.boardgameevent.service.PlaceService;
import com.capstoneproject.boardgameevent.service.TeamService;
import com.capstoneproject.boardgameevent.service.UserService;
import com.capstoneproject.boardgameevent.service.impl.EventServiceImpl;
import com.capstoneproject.boardgameevent.service.impl.GameServiceImpl;
import com.capstoneproject.boardgameevent.service.impl.PlaceServiceImpl;
import com.capstoneproject.boardgameevent.service.impl.TeamServiceImpl;
import com.capstoneproject.boardgameevent.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BeanConfiguration {

    @Bean
    public UserService initUserService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public EventService initEventService(EventRepository eventRepository,
                                         UserService userService,
                                         EventsToUsersRepository eventsToUsersRepository,
                                         RatingEventRepository ratingEventRepository) {
        return new EventServiceImpl(eventRepository, userService, eventsToUsersRepository, ratingEventRepository);
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

    @Bean
    public TeamService initTeamService(TeamRepository teamRepository, UserService userService, PasswordEncoder passwordEncoder) {
        return new TeamServiceImpl(teamRepository, userService, passwordEncoder);
    }

    @Bean
    public TeamConverter initTeamConvertor() {
        return new TeamConverterImpl();
    }

    @Bean
    public PlaceConverter initPlaceConvertor() {
        return new PlaceConverterImpl();
    }

    @Bean
    public PlaceService initPlaceService(PlaceRepository placeRepository, RatingPlaceRepository ratingPlaceRepository, UserService userService) {
        return new PlaceServiceImpl(placeRepository, ratingPlaceRepository, userService);
    }

}
