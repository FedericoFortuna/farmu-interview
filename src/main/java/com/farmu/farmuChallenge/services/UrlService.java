package com.farmu.farmuChallenge.services;

import com.farmu.farmuChallenge.exceptions.UrlNotFoundException;
import com.farmu.farmuChallenge.utils.Constants;
import com.farmu.farmuChallenge.entities.UrlEntity;
import com.farmu.farmuChallenge.exceptions.InvalidUrlFormatException;
import com.farmu.farmuChallenge.repositories.UrlRepository;
import com.farmu.farmuChallenge.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UrlService {

    private static final String OBTAINING_ID = "{} - Obtaining ID from url: {} at {}";
    private static final String SEARCHING_ID = "{} - Searching id: {} into database at {}";
    private static final String ID_NOT_FOUND = "{} - Does not exists an url into database with id {} - {}";
    private static final String URL_FOUNDED = "{} - The id: {} corresponds with url: {} - {}";
    private static final String BUILDING_URL = "{} - Building an image entity to save into database with url: {} & id: {} & shorter path: {} - {}";
    private static final String SAVING_URL = "{} - Saving shorter url: {} into database - {}";

    @Autowired
    private UrlRepository repository;

    public String getOriginalUrl(String shortenedUrl) {
        log.info(OBTAINING_ID, Constants.SERVICE_NATURE, shortenedUrl, LocalDateTime.now().withNano(0));
        String id = getId(shortenedUrl);
        log.info(SEARCHING_ID, Constants.SERVICE_NATURE, id, LocalDateTime.now().withNano(0));
        Optional<UrlEntity> urlOpt = repository.findById(UUID.fromString(id));
        if (urlOpt.isEmpty()) {
            log.info(ID_NOT_FOUND, Constants.SERVICE_NATURE, id, LocalDateTime.now().withNano(0));
            throw new UrlNotFoundException();
        }
        log.info(URL_FOUNDED, Constants.SERVICE_NATURE, id, urlOpt.get().getOriginalPath(), LocalDateTime.now().withNano(0));
        return urlOpt.get().getOriginalPath();
    }

    private String getId(String url) {
        int lastIndex = url.lastIndexOf('/');
        if (lastIndex != -1) {
            return url.substring(lastIndex + 1);
        } else {
            return url;
        }
    }

    public String processUrl(String url) {

        if (!Utils.isValidURL(url)) {
            throw new InvalidUrlFormatException();
        }

        UUID id = Utils.generateUUID();

        String shorterPath = buildShortenedUrl(id);

        saveUrl(buildUrlEntity(url, id, shorterPath));

        return shorterPath;
    }


    private UrlEntity buildUrlEntity(String url, UUID id, String shorterPath) {
        log.info(BUILDING_URL, Constants.SERVICE_NATURE, url, id, shorterPath, LocalDateTime.now().withNano(0));
        return UrlEntity.builder()
                .id(id)
                .originalPath(url)
                .shorterPath(shorterPath)
                .creationDate(LocalDateTime.now().withNano(0))
                .build();
    }

    private String buildShortenedUrl(UUID id) {
        return Constants.SECURE_PROTOCOL
                + Constants.COLON
                + Constants.D_SLASH
                + Constants.URL_PREFIX
                + Constants.DOT
                + Constants.COM
                + Constants.SLASH
                + id.toString();
    }

    private void saveUrl(UrlEntity entity) {
        log.info(SAVING_URL, Constants.SERVICE_NATURE, entity.getShorterPath(), LocalDateTime.now().withNano(0));
        repository.save(entity);
    }

}
