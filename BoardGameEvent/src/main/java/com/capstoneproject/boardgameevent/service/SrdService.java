package com.capstoneproject.boardgameevent.service;

import java.util.List;
import java.util.Optional;

public interface SrdService<K, E> {

    String getEntityName();

    E save(E entity);

    List<E> findAll();

    Optional<E> findById(K id);

    E getById(K id);

    boolean existsById(K id);

    E delete(K id);

}
