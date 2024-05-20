package com.capstoneproject.boardgameevent.exception;

public class ActionAlreadyPerformedException extends RuntimeException {

    public ActionAlreadyPerformedException(String message) {
        super(message);
    }
}
