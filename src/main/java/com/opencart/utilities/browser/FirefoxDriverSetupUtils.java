/**
 * Purpose: Sets up FirefoxDriver by reading the specified options
 * from the config.properties file
 */

package com.opencart.utilities.browser;

import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverSetupUtils {

    public static WebDriver initializeFirefoxDriver() {
        boolean isHeadless = Boolean.parseBoolean(ConfigPropertiesFileReaderUtils.getHeadLessValue());
        boolean isIncognito = Boolean.parseBoolean(ConfigPropertiesFileReaderUtils.getIncognitoValue());

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