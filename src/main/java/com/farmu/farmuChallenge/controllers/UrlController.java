package com.farmu.farmuChallenge.controllers;


import com.farmu.farmuChallenge.services.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url")
@Slf4j
public class UrlController {

    @Autowired
    private UrlService service;

    @GetMapping
    public ResponseEntity<String> getShorterPath(@RequestParam String path){
        return new ResponseEntity<>(service.processUrl(path), HttpStatus.OK);
    }

}
