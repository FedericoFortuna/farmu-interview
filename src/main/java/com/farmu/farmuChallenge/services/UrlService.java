package com.farmu.farmuChallenge.services;

import com.farmu.farmuChallenge.utils.Constants;
import com.farmu.farmuChallenge.entities.UrlEntity;
import com.farmu.farmuChallenge.exceptions.InvalidUrlFormatException;
import com.farmu.farmuChallenge.repositories.UrlRepository;
import com.farmu.farmuChallenge.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class UrlService {

    @Autowired
    private UrlRepository repository;

    public String processUrl(String url){

        if(!Utils.isValidURL(url)){
            throw new InvalidUrlFormatException();
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
                + Constants.DOT
                + Constants.COM
                + Constants.SLASH
                + id.toString();
    }

    private void saveUrl(UrlEntity entity){
        repository.save(entity);
    }

}
