package com.farmu.farmuChallenge.services;

import com.farmu.farmuChallenge.Constants;
import com.farmu.farmuChallenge.entities.UrlEntity;
import com.farmu.farmuChallenge.repositories.UrlRepository;
import com.farmu.farmuChallenge.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class UrlService {

    @Autowired
    private UrlRepository repository;

    public String processUrl(String url){

        if(!Utils.isValidURL(url)){
            //throw ex
        }

        UUID id = Utils.generateUUID();

        String shorterPath = clipUrl(id);

        saveUrl(buildImageEntity(url, id, shorterPath));

        return shorterPath;
    }



    private UrlEntity buildImageEntity(String url, UUID id, String shorterPath){

        return UrlEntity.builder()
                .id(id)
                .originalPath(url)
                .shorterPath(shorterPath)
                .creationDate(LocalDateTime.now().withNano(0))
                .build();
    }

    private String clipUrl(UUID id){
        return Constants.SECURE_PROTOCOL
                + Constants.COLON
                + Constants.D_SLASH
                + Constants.URL_PREFIX
                + Constants.SLASH
                + id.toString();
    }

    private void saveUrl(UrlEntity entity){
        repository.save(entity);
    }

}
