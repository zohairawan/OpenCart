package com.opencart.utilities.browser;

import com.opencart.utilities.properties.ConfigPropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverSetup {

    public static WebDriver initializeChromeDriver() {
        boolean isHeadless = Boolean.parseBoolean(ConfigPropertiesFileReader.getHeadLessValue());
        boolean isIncognito = Boolean.parseBoolean(ConfigPropertiesFileReader.getIncognitoValue());

        if (!isHeadless && !isIncognito) {
            return new ChromeDriver();
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        if (isHeadless) {
            chromeOptions.addArguments("--headless=new");
        }

        if (isIncognito) {
            chromeOptions.addArguments("--incognito");
        }

        return new ChromeDriver(chromeOptions);
    }
}