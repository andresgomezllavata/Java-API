package com.rest.api.superhero.controller;

import com.rest.api.superhero.error.SuperheroAlreadyExistedException;
import com.rest.api.superhero.error.SuperheroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SuperheroExceptionController {

    @ExceptionHandler(value = SuperheroNotFoundException.class)
    public ResponseEntity<Object> superheroNotFoundException(SuperheroNotFoundException exception)
    {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = SuperheroAlreadyExistedException.class)
    public ResponseEntity<Object> superheroAlreadyExisted(SuperheroAlreadyExistedException exception)
    {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
}
