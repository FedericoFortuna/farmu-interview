package com.farmu.farmuChallenge.exceptions;

import com.farmu.farmuChallenge.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class HandlerEx {
    private static final String INVALID_URL_FORMAT = "Url provided is not correct.";
    private static final String URL_NOT_FOUND = "Url provided does not exist";
    private static final String INVALID_FORMAT_EXCEPTION = "{} - An invalid url format exception was thrown at {}";
    private static final String URL_NOT_FOUND_EXCEPTION = "{} - An url not found exception was thrown at {}";
    @ExceptionHandler(InvalidUrlFormatException.class)
    public ResponseEntity<String> invalidUrlFormat(InvalidUrlFormatException ex) {
        log.debug(INVALID_FORMAT_EXCEPTION, Constants.EXCEPTION_NATURE, LocalDateTime.now().withNano(0));
        return new ResponseEntity<>(INVALID_URL_FORMAT, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<String> urlNotFound(UrlNotFoundException ex){
        log.debug(URL_NOT_FOUND_EXCEPTION, Constants.EXCEPTION_NATURE, LocalDateTime.now().withNano(0));
        return new ResponseEntity<>(URL_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
