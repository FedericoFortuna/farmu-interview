package com.farmu.farmuChallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerEx {
    private static final String INVALID_URL_FORMAT = "Url provided is not correct.";

    @ExceptionHandler(InvalidUrlFormatException.class)
    public ResponseEntity<String> invalidUrlFormat(InvalidUrlFormatException ex) {
        return new ResponseEntity<>(INVALID_URL_FORMAT, HttpStatus.NOT_FOUND);
    }
}
