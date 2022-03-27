package co.com.sofka.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomEmailGenerator {

    public static String randomEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
    }
}
