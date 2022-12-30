package com.javi.moby.exception;

public class TechnologyAlreadyExistsException extends RuntimeException{
    private String message;

    public TechnologyAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public TechnologyAlreadyExistsException() {
    }
}
