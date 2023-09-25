package com.farmu.farmuChallenge.controllers;


import com.farmu.farmuChallenge.services.UrlService;
import com.farmu.farmuChallenge.utils.Constants;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/url")
@Slf4j
public class UrlController {
    private static final String URL_TO_CLIP = "{} - URL: {} was received to be processed at {}";
    private static final String GET_ORIGINAL_URL = "{} - URL shortened: {} was received to be processed at {}";
    private static final String ORIGINAL_URL_WAS_FOUND = "{} - Original URL: {} was found and will be redirected at {}";
    private static final String ORIGINAL_URL_WAS_NOT_FOUND = "{} - Original URL was not found at {}";
    @Autowired
    private UrlService service;

    @GetMapping
    public ResponseEntity<String> getShorterPath(@RequestParam String path){
        log.info(URL_TO_CLIP, Constants.CONTROLLER_NATURE, path, LocalDateTime.now().withNano(0));
        return new ResponseEntity<>(service.processUrl(path), HttpStatus.OK);
    }

    @GetMapping(value = "/shortened")
    public void redirectUrl(@RequestParam String url, HttpServletResponse response) throws IOException {
        log.info(GET_ORIGINAL_URL, Constants.CONTROLLER_NATURE, url, LocalDateTime.now().withNano(0));
        String originalUrl = service.getOriginalUrl(url);
        if (originalUrl != null) {
            log.info(ORIGINAL_URL_WAS_FOUND, Constants.CONTROLLER_NATURE, originalUrl, LocalDateTime.now().withNano(0));
            response.sendRedirect(originalUrl);
        } else {
            log.error(ORIGINAL_URL_WAS_NOT_FOUND, Constants.CONTROLLER_NATURE, LocalDateTime.now().withNano(0));
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
