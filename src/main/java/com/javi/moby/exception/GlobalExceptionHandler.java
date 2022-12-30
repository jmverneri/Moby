package com.javi.moby.exception;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value(value = "${data.exception.message1}")
    private String message1;
    @Value(value = "${data.exception.message2}")
    private String message2;
    @Value(value = "${data.exception.message3}")
    private String message3;

    @ExceptionHandler(value = DNIAlreadyExistsException.class)
    public ResponseEntity<Object> dniAlreadyExistsException(DNIAlreadyExistsException dniAlreadyExistsException) {
        return new ResponseEntity<>(message1, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(value = IdNotFoundException.class)
    public ResponseEntity<Object> idNotFoundException(IdNotFoundException idNotFoundException) {
        return new ResponseEntity<>(message2, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TechnologyAlreadyExistsException.class)
    public ResponseEntity<Object> technologyAlreadyExistsException(TechnologyAlreadyExistsException
                                                                               technologyAlreadyExistsException) {
        return new ResponseEntity<>(message3, HttpStatus.ALREADY_REPORTED);
    }
}
