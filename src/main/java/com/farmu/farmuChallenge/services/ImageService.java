package com.farmu.farmuChallenge.services;

import com.farmu.farmuChallenge.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@Slf4j
public class ImageService {

    private static final String IMAGE_WILL_BE_PROCESSED = "{} - Image with width: {} and height {} will be processed at {}";
    private static final String IMAGE_WAS_PROCESSED = "{} - Image with width: {} and height {} was processed at {}";

    public byte[] resizeImage(byte[] imageData, int width, int height) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        log.info(IMAGE_WILL_BE_PROCESSED, Constants.SERVICE_NATURE, width, height, LocalDateTime.now().withNano(0));
        Thumbnails.of(new ByteArrayInputStream(imageData))
                .size(width, height)
                .outputFormat(Constants.JPG)
                .toOutputStream(outputStream);
        log.info(IMAGE_WAS_PROCESSED, Constants.SERVICE_NATURE, width, height, LocalDateTime.now().withNano(0));
        return outputStream.toByteArray();
    }


}
