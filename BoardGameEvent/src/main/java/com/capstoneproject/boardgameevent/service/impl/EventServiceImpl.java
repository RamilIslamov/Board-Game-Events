package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.Event;
import com.capstoneproject.boardgameevent.entity.EventToUsers;
import com.capstoneproject.boardgameevent.entity.Rating;
import com.capstoneproject.boardgameevent.entity.User;
import com.capstoneproject.boardgameevent.exception.ActionAlreadyPerformedException;
import com.capstoneproject.boardgameevent.repository.EventRepository;
import com.capstoneproject.boardgameevent.repository.EventsToUsersRepository;
import com.capstoneproject.boardgameevent.repository.RatingRepository;
import com.capstoneproject.boardgameevent.rest.model.ExitForm;
import com.capstoneproject.boardgameevent.rest.model.ParticipateForm;
import com.capstoneproject.boardgameevent.rest.model.RateForm;
import com.capstoneproject.boardgameevent.rest.model.SearchEventForm;
import com.capstoneproject.boardgameevent.service.AbstractSrdServiceImpl;
import com.capstoneproject.boardgameevent.service.EventService;
import com.capstoneproject.boardgameevent.service.UserService;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.capstoneproject.boardgameevent.entity.QEvent.event;
import static com.querydsl.core.types.ExpressionUtils.and;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.IterableUtils.toList;

@AllArgsConstructor
public class EventServiceImpl extends AbstractSrdServiceImpl<Integer, Event> implements EventService {

    private final EventRepository eventRepository;

    private final UserService userService;

    private final EventsToUsersRepository eventsToUsersRepository;

    private final RatingRepository ratingRepository;

    @Override
    protected CrudRepository<Event, Integer> getRepository() {
        return eventRepository;
    }

    @Override
    protected Class<Event> getEntityClass() {
        return Event.class;
    }

    @Override
    @Transactional
    public Event update(Event event) {
        if (null == event) {
            return null;
        }
        Event entity = getById(event.getEventId());
        entity.setPlayers(event.getPlayers());
        entity.setName(event.getName());
        entity.setEventDate(event.getEventDate());
        entity.setLocation(event.getLocation());
        entity.setDescription(event.getDescription());

        return entity;
    }

    @Override
    @Transactional
    public Event save(Event entity) {
        return eventRepository.save(entity);
    }

    @Override
    @Transactional
    public void participate(ParticipateForm form) throws ActionAlreadyPerformedException {
        Integer eventId = Integer.parseInt(form.getEventId());
        User user = userService.getUser();
        Long userId = user.getUserId();
        Event event = getById(eventId);

        if (eventsToUsersRepository.existsByUserIdAndEventId(userId, eventId)) {
            throw new ActionAlreadyPerformedException(String.format("You are already participate at %s in %s.", event.getName(), event.getLocation()));
        }

        Integer currPlayers = event.getCurrPlayers();
        event.setCurrPlayers(currPlayers + 1);

        EventToUsers eventToUsers = new EventToUsers();
        eventToUsers.setUserId(userId);
        eventToUsers.setEventId(eventId);
        eventsToUsersRepository.save(eventToUsers);
    }

    @Override
    @Transactional
    public void exit(ExitForm form) {
        Integer eventId = Integer.parseInt(form.getExitEventId());
        Event event = getById(eventId);
        Integer currPlayers = event.getCurrPlayers();
        event.setCurrPlayers(currPlayers - 1);
        User user = userService.getUser();
        EventToUsers eventToUsers = eventsToUsersRepository.findByUserIdAndEventId(user.getUserId(), eventId);
        eventsToUsersRepository.delete(eventToUsers);
    }

    @Override
    public List<Event> findMyEvents() {
        Long userId = userService.getUser().getUserId();
        List<Integer> eventIds = eventsToUsersRepository.findEventIdsByUserId(userId);
        Iterable<Event> eventsIterable = eventRepository.findAllById(eventIds);
        List<Event> eventsList = new ArrayList<>();
        eventsIterable.forEach(eventsList::add);
        return eventsList;
    }

    @Override
    @Transactional
    public void rate(RateForm form) throws ActionAlreadyPerformedException {
        Integer eventId = Integer.parseInt(form.getRateEventId());
        Float rating = Float.parseFloat(form.getEventRate());
        Event event = getById(eventId);
        if (!ratingRepository.existsByUserIdAndEventId(userService.getUser().getUserId(), eventId)) {
            rate(eventId, rating);
        } else {
            throw new ActionAlreadyPerformedException(String.format("You are already rate %s in %s.", event.getName(), event.getLocation()));
        }
    }

    @Override
    @Transactional
    public List<Event> search(SearchEventForm form) {
        Predicate predicate = null;

        if (null != form.getSearchTitle()) {
            String searchTitle = form.getSearchTitle().toLowerCase();
            predicate = and(null, event.name.toLowerCase().contains(searchTitle));
        }

        if (null != form.getGameKey()) {
            predicate = and(predicate, event.gameId.eq(form.getGameKey()));
        }

        if (null != form.getFromDate()) {
            predicate = and(predicate, event.eventDate.after(form.getFromDate()));
        }

        if (null != form.getToDate()) {
            predicate = and(predicate, event.eventDate.before(form.getToDate()));
        }

        return toList(eventRepository.findAll(predicate));
    }

    @Override
    public List<Event> findAllByRating() {
        return findAll().stream()
                        .filter(event -> event.getEventDate().isBefore(LocalDateTime.now()))
                        .sorted((e1, e2) -> Float.compare(e2.getRating(), e1.getRating()))
                        .collect(toList());
    }

    @Override
    public List<Event> findAllByDate() {
        return findAll().stream()
                        .sorted(Comparator.comparing(Event::getEventDate))
                        .collect(toList());
    }

    private void rate(Integer eventId, Float score) {
        Event event = getById(eventId);
        Integer usersVoted = event.getUsersVoted();
        Float currRating = event.getRating();
        if (null == usersVoted) {
            event.setRating(score);
            event.setUsersVoted(1);
        } else {
            Float updateRating = ((currRating * usersVoted) + score) / (usersVoted + 1);
            event.setRating(updateRating);
            event.setUsersVoted(usersVoted + 1);
        }

        Rating rating = new Rating();
        rating.setUser(userService.getUser());
        rating.setEvent(event);
        rating.setRating(score);
        ratingRepository.save(rating);
    }
}

