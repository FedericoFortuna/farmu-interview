package com.farmu.farmuChallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerEx {
    private static final String INVALID_URL_FORMAT = "Url provided is not correct.";
    private static final String URL_NOT_FOUND = "Url provided does not exist";
    @ExceptionHandler(InvalidUrlFormatException.class)
    public ResponseEntity<String> invalidUrlFormat(InvalidUrlFormatException ex) {
        return new ResponseEntity<>(INVALID_URL_FORMAT, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<String> urlNotFound(UrlNotFoundException ex){
        return new ResponseEntity<>(URL_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
