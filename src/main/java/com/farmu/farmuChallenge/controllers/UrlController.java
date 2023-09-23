package com.farmu.farmuChallenge.controllers;


import com.farmu.farmuChallenge.services.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/url")
@Slf4j
public class UrlController {

    @Autowired
    private UrlService service;

    @GetMapping(value = "/{originalPath}")
    public ResponseEntity<String> getShorterPath(@PathVariable String originalPath){
        return new ResponseEntity<>(service.clipUrl(originalPath), HttpStatus.OK);
    }

}
