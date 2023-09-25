package com.farmu.farmuChallenge.controllers;

import com.farmu.farmuChallenge.services.ImageService;
import com.farmu.farmuChallenge.utils.Constants;
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
import java.time.LocalDateTime;

@RestController
@RequestMapping("/image")
@Slf4j
public class ImageController {

    private static final String INFO_IMAGE_SIZES = "{} - File with width: {} and height: {} was received at {}";
    private static final String HEADERS_CONFIG = "{} - Headers are being configured at {}";
    private static final String SENDING_IMAGE = "{} - Sending image at {}";

    @Autowired
    private ImageService imageService;

    @PostMapping("/resize")
    public ResponseEntity<byte[]> resizeImage(@RequestParam("file") MultipartFile file,
                                              @RequestParam("width") int width,
                                              @RequestParam("height") int height) {
        try {
            log.info(INFO_IMAGE_SIZES, Constants.CONTROLLER_NATURE, width, height, LocalDateTime.now().withNano(0));
            byte[] resizedImage = imageService.resizeImage(file.getBytes(), width, height);
            HttpHeaders headers = new HttpHeaders();
            log.info(HEADERS_CONFIG, Constants.CONTROLLER_NATURE, LocalDateTime.now().withNano(0));
            headers.setContentType(MediaType.IMAGE_JPEG);
            log.info(SENDING_IMAGE, Constants.CONTROLLER_NATURE, LocalDateTime.now().withNano(0));
            return new ResponseEntity<>(resizedImage, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
