package com.javi.moby.exception;

public class DNIDontExistException extends RuntimeException{
    private String message;

    public DNIDontExistException(String message) {
        super(message);
        this.message = message;
    }

    public DNIDontExistException() {
    }
}
