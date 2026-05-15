/**
 * Purpose: Sets up ChromeDriver by reading the specified options
 * from the config.properties file
 */

package com.opencart.utilities.browser;

import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverSetupUtils {

    public static WebDriver initializeChromeDriver() {
        boolean isHeadless = ConfigPropertiesFileReaderUtils.getHeadLessValue();
        boolean isIncognito = ConfigPropertiesFileReaderUtils.getIncognitoValue();

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