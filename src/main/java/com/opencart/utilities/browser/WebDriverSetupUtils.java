/*
 * Purpose:
 * - Assigns WebDriver to a concrete class by reading the browser type
 *   from the config.properties file
 */

package com.opencart.utilities.browser;

import com.opencart.constants.Constant;
import com.opencart.utilities.logger.LogManagerUtils;
import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.lang.annotation.AnnotationTypeMismatchException;

public class WebDriverSetupUtils {

    public static WebDriver initializeDriverType(String browser) {
        WebDriver driver;
        String driverType = (browser == null) ? ConfigPropertiesFileReaderUtils.getBrowserValue() : browser;

        Logger loggerUtil = LogManagerUtils.getLogger(WebDriverSetupUtils.class);
        loggerUtil.info("Initializing browser type to: '{}'", driverType);
        switch (driverType.toLowerCase()) {
            case Constant.CHROME_BROWSER -> driver = ChromeDriverSetupUtils.initializeChromeDriver();
            case Constant.FIREFOX_BROWSER -> driver = FirefoxDriverSetupUtils.initializeFirefoxDriver();
            default -> {
                loggerUtil.error("Invalid browser type: '{}'", driverType);
                throw new RuntimeException();
            }
        }

        driver.manage().window().maximize();
        return driver;
    }
}