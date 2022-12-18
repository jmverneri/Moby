package com.javi.moby.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException resourceNotFoundException){
        NotFoundException notFoundException = new NotFoundException(resourceNotFoundException.getMessage(),
                resourceNotFoundException.getCause(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(notFoundException, HttpStatus.NOT_FOUND);
    }
}
