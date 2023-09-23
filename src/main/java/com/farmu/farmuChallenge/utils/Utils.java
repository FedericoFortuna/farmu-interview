package com.farmu.farmuChallenge.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static UUID generateUUID(){
        return UUID.randomUUID();
    }

    public static boolean isValidURL(String url) {
        Pattern pattern = Pattern.compile(Constants.REGEX);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
