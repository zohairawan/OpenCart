/**
 * Purpose: Sets up ChromeDriver by reading the specified options
 * from the config.properties file
 */

package com.opencart.utilities.browser;

import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverSetupUtil {

    public static WebDriver initializeChromeDriver() {
        boolean isHeadless = ConfigPropertiesFileReaderUtil.getHeadLessValue();
        boolean isIncognito = ConfigPropertiesFileReaderUtil.getIncognitoValue();

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