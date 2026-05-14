/**
 * Purpose: Sets up FirefoxDriver by reading the specified options
 * from the config.properties file
 */

package com.opencart.utilities.browser;

import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverSetupUtil {

    public static WebDriver initializeFirefoxDriver() {
        boolean isHeadless = ConfigPropertiesFileReaderUtil.getHeadLessValue();
        boolean isIncognito = ConfigPropertiesFileReaderUtil.getIncognitoValue();

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