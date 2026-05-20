/*
 * Purpose:
 * - Sets up FirefoxOptions with the appropriate options
 *   by reading the specified options from the config.properties file
 */

package com.opencart.utilities.browser;

import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxOptionsProvider {

    public static FirefoxOptions getFirefoxOptions() {
        boolean isHeadless = ConfigPropertiesFileReaderUtils.getHeadlessValue();
        boolean isIncognito = ConfigPropertiesFileReaderUtils.getIncognitoValue();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        if (isHeadless) {
            firefoxOptions.addArguments("-headless");
        }

        if (isIncognito) {
            firefoxOptions.addArguments("-private");
        }

        return firefoxOptions;
    }
}