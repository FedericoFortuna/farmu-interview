package com.farmu.farmuChallenge.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Utils {
    private static final String GENERATE_UUID = "{} - Generating UUID at {}";
    private static final String VALIDATING_URL = "{} - Validating url: {} at {}";

    public static UUID generateUUID(){
        log.debug(GENERATE_UUID, Constants.UTILS_NATURE, LocalDateTime.now().withNano(0));
        return UUID.randomUUID();
    }

    public static boolean isValidURL(String url) {
        Pattern pattern = Pattern.compile(Constants.REGEX);
        Matcher matcher = pattern.matcher(url);
        log.debug(VALIDATING_URL, Constants.UTILS_NATURE, url, LocalDateTime.now().withNano(0));
        return matcher.matches();
    }
}
