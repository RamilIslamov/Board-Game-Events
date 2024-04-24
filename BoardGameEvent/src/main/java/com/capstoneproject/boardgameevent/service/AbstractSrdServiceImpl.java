package com.capstoneproject.boardgameevent.service;

import com.capstoneproject.boardgameevent.exception.EntityNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.collections4.IterableUtils.toList;

public abstract class AbstractSrdServiceImpl<K extends Serializable, E> implements SrdService<K, E> {

    protected abstract CrudRepository<E, K> getRepository();

    public String getEntityName() {
        return getEntityClass().getSimpleName();
    }

    protected abstract Class<E> getEntityClass();

    public List<E> findAll() {
        return toList(getRepository().findAll());
    }

    public Optional<E> findById(K id) {
        return getRepository().findById(id);
    }

    public E getById(K id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException(getEntityName(), id));
    }

    @Transactional
    public E delete(K id) {
        E entity = getById(id);
        getRepository().delete(entity);
        return entity;
    }

    @Override
    public boolean existsById(K id) {
        return getRepository().existsById(id);
    }

}
