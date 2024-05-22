package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.Place;
import com.capstoneproject.boardgameevent.entity.RatingPlace;
import com.capstoneproject.boardgameevent.exception.ActionAlreadyPerformedException;
import com.capstoneproject.boardgameevent.exception.DataAccessException;
import com.capstoneproject.boardgameevent.repository.PlaceRepository;
import com.capstoneproject.boardgameevent.repository.RatingPlaceRepository;
import com.capstoneproject.boardgameevent.rest.model.RateForm;
import com.capstoneproject.boardgameevent.service.AbstractSrdServiceImpl;
import com.capstoneproject.boardgameevent.service.PlaceService;
import com.capstoneproject.boardgameevent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@AllArgsConstructor
public class PlaceServiceImpl extends AbstractSrdServiceImpl<Integer, Place> implements PlaceService {

    private final PlaceRepository placeRepository;

    private final RatingPlaceRepository ratingPlaceRepository;

    private final UserService userService;

    @Override
    protected CrudRepository<Place, Integer> getRepository() {
        return placeRepository;
    }

    @Override
    protected Class<Place> getEntityClass() {
        return Place.class;
    }

    @Override
    public Place save(Place entity) {
        return placeRepository.save(entity);
    }

    @Override
    public Optional<Place> findByName(String name) {
        return placeRepository.findByName(name);
    }

    @Override
    public void throwOrSave(Place entity) {
        if (findByName(entity.getName()).isPresent()) {
            throw new DataAccessException(String.format("Place name: %s is already exists", entity.getName()));
        }
        save(entity);
    }

    @Override
    public void rate(RateForm form) {
        Integer placeId = Integer.parseInt(form.getRateId());
        Float rating = Float.parseFloat(form.getEventRate());
        Place place = getById(placeId);
        if (!ratingPlaceRepository.existsByUserIdAndEventId(userService.getUser().getUserId(), placeId)) {
            rate(placeId, rating);
        } else {
            throw new ActionAlreadyPerformedException(String.format("You are already rate %s in %s.", place.getName(), place.getLocation()));
        }
    }

    private void rate(Integer placeId, Float score) {
        Place place = getById(placeId);
        Integer usersVoted = place.getUsersVoted();
        Float currRating = place.getRaing();
        if (null == usersVoted) {
            place.setRaing(score);
            place.setUsersVoted(1);
        } else {
            Float updateRating = ((currRating * usersVoted) + score) / (usersVoted + 1);
            place.setRaing(updateRating);
            place.setUsersVoted(usersVoted + 1);
        }

        RatingPlace ratingPlace = new RatingPlace();
        ratingPlace.setUser(userService.getUser());
        ratingPlace.setPlace(place);
        ratingPlace.setRating(score);
        ratingPlaceRepository.save(ratingPlace);
    }

}
