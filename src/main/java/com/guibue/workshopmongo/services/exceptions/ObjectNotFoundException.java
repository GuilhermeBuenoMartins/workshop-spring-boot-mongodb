package com.guibue.workshopmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public static final long serialVerionsUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
