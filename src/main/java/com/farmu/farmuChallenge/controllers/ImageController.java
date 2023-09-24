package com.farmu.farmuChallenge.controllers;

import com.farmu.farmuChallenge.services.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@Slf4j
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/resize")
    public ResponseEntity<byte[]> resizeImage(@RequestParam("file") MultipartFile file,
                                              @RequestParam("width") int width,
                                              @RequestParam("height") int height) {
        try {
            byte[] resizedImage = imageService.resizeImage(file.getBytes(), width, height);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(resizedImage, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
