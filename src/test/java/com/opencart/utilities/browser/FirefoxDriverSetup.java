package com.opencart.utilities.browser;

import com.opencart.utilities.properties.ConfigPropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverSetup {

    public static WebDriver initializeFirefoxDriver() {
        boolean isHeadless = Boolean.parseBoolean(ConfigPropertiesFileReader.getHeadLessValue());
        boolean isIncognito = Boolean.parseBoolean(ConfigPropertiesFileReader.getIncognitoValue());

        if (!isHeadless && !isIncognito) {
            return new FirefoxDriver();
        }

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (isHeadless) {
            firefoxOptions.addArguments("-headless");
        }

        if (isIncognito) {
            firefoxOptions.addArguments("-private");
        }

        return new FirefoxDriver(firefoxOptions);

    }
}