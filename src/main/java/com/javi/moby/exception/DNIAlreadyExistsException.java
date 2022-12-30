package com.javi.moby.exception;

public class DNIAlreadyExistsException extends RuntimeException{
    private String message;

    public DNIAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public DNIAlreadyExistsException() {
    }
}
