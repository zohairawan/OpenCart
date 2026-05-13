/**
 * Purpose: Assigns WebDriver to a concrete class by reading the browser type
 * from the config.properties file
 */

package com.opencart.utilities.browser;

import com.opencart.constants.Constant;
import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class WebDriverSetupUtils {

    public static WebDriver initializeDriverType(String browser) {
        WebDriver driver;
        String driverType = (browser == null) ? ConfigPropertiesFileReaderUtils.getBrowserValue() : browser;

        switch (driverType.toLowerCase()) {
            case Constant.CHROME_BROWSER -> driver = ChromeDriverSetupUtils.initializeChromeDriver();
            case Constant.FIREFOX_BROWSER -> driver = FirefoxDriverSetupUtils.initializeFirefoxDriver();
            case null, default -> throw new RuntimeException("======= INVALID BROWSER TYPE PROVIDED =======");
        }

        driver.manage().window().maximize();
        return driver;
    }
}