package com.farmu.farmuChallenge.services;

import com.farmu.farmuChallenge.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class ImageService {

    public byte[] resizeImage(byte[] imageData, int width, int height) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(new ByteArrayInputStream(imageData))
                .size(width, height)
                .outputFormat(Constants.JPG)
                .toOutputStream(outputStream);
        return outputStream.toByteArray();
    }


}
