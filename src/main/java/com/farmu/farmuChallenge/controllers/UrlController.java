package com.farmu.farmuChallenge.controllers;


import com.farmu.farmuChallenge.services.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/url")
@Slf4j
public class UrlController {

    //TODO
    // add logs
    // review expire function to get url
    // add tests
    

    @Autowired
    private UrlService service;

    @GetMapping
    public ResponseEntity<String> getShorterPath(@RequestParam String path){
        return new ResponseEntity<>(service.processUrl(path), HttpStatus.OK);
    }

    @GetMapping(value = "/shortened")
    public void redirectUrl(@RequestParam String shortenedUrl, HttpServletResponse response) throws IOException {
        String originalUrl = service.getOriginalUrl(shortenedUrl);
        if (originalUrl != null) {
            response.sendRedirect(originalUrl);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
