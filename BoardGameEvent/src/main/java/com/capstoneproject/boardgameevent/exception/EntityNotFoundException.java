package com.capstoneproject.boardgameevent.exception;

import java.io.Serializable;

import static java.text.MessageFormat.format;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entityName, Serializable id) {
        super(format("A {0} with the id {1} has not been found",
                     entityName,
                     id));
    }
}
