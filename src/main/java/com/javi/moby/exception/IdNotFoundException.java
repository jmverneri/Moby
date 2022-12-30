package com.javi.moby.exception;

public class IdNotFoundException extends RuntimeException{
    private String message;

    public IdNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public IdNotFoundException() {
    }
}
