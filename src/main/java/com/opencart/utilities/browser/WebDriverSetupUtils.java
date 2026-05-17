/*
 * Purpose:
 * - Assigns WebDriver to a concrete class by reading the browser type
 *   from the config.properties file
 */

package com.opencart.utilities.browser;

import com.opencart.constants.Constant;
import com.opencart.utilities.logger.LogManagerUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverSetupUtils {

    public static WebDriver initializeDriverType(String browser) {
        WebDriver driver;

        Logger loggerUtil = LogManagerUtils.getLogger(WebDriverSetupUtils.class);
        loggerUtil.info("Initializing browser type to: '{}'", browser);
        switch (browser.toLowerCase()) {
            case Constant.CHROME_BROWSER -> driver = ChromeDriverSetupUtils.initializeChromeDriver();
            case Constant.FIREFOX_BROWSER -> driver = FirefoxDriverSetupUtils.initializeFirefoxDriver();
            default -> {
                loggerUtil.error("Invalid browser type: '{}'", browser);
                throw new RuntimeException();
            }
        }

        driver.manage().window().maximize();
        return driver;
    }
}