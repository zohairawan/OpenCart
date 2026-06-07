/*
 * Purpose:
 * - Sets up ChromeOptions with the appropriate options
 *   by reading the specified options from the config.properties file
 */

package com.opencart.driver.browser_options;

import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsProvider {

    public static ChromeOptions getChromeOptions() {
        boolean isHeadless = ConfigPropertiesFileReaderUtils.getHeadlessValue();
        boolean isIncognito = ConfigPropertiesFileReaderUtils.getIncognitoValue();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (isHeadless) {
            chromeOptions.addArguments("--headless=new");
        }

        if (isIncognito) {
            chromeOptions.addArguments("--incognito");
        }

        return chromeOptions;
    }
}