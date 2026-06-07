/*
 * Purpose:
 * - Assigns WebDriver to a concrete class by reading the browser type
 *   from the config.properties file
 */

package com.opencart.driver;

import com.opencart.constants.Constants;
import com.opencart.driver.browser_options.ChromeOptionsProvider;
import com.opencart.driver.browser_options.FirefoxOptionsProvider;
import com.opencart.driver.environment.DriverEnvironment;
import com.opencart.driver.environment.LocalDriverEnvironment;
import com.opencart.driver.environment.RemoteDriverEnvironment;
import com.opencart.utilities.logger.LogManagerUtils;
import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public class DriverFactory {


    public static WebDriver createDriver(String browser, String operatingSystem) {
        Logger logger = LogManagerUtils.getLogger(DriverFactory.class);
        logger.info("Initializing browser type to: '{}'", browser);

        MutableCapabilities options;
        DriverEnvironment environment = getEnvironment(operatingSystem);
        switch (browser.toLowerCase()) {
            case Constants.CHROME_BROWSER -> {
                options = ChromeOptionsProvider.getChromeOptions();
                return environment.createWebDriver(options);
            }
            case Constants.FIREFOX_BROWSER -> {
                options = FirefoxOptionsProvider.getFirefoxOptions();
                return environment.createWebDriver(options);
            }
            default -> {
                String invalidBrowserMessage = "Invalid browser type: '" + browser + "'";
                logger.error(invalidBrowserMessage);
                throw new IllegalArgumentException(invalidBrowserMessage);
            }
        }
    }

    private static DriverEnvironment getEnvironment(String operatingSystem) {
        Logger logger = LogManagerUtils.getLogger(DriverFactory.class);
        String environment = ConfigPropertiesFileReaderUtils.getExecutionEnv().toLowerCase();
        logger.info("Initializing environment type to: '{}'", environment);
        return switch (environment) {
            case Constants.EXECUTION_ENV_LOCAL -> new LocalDriverEnvironment();
            case Constants.EXECUTION_ENV_REMOTE -> new RemoteDriverEnvironment(operatingSystem);
            default -> {
                String invalidEnvironmentMsg = "Invalid environment type: '" + environment + "'";
                logger.error(invalidEnvironmentMsg);
                throw new IllegalArgumentException(invalidEnvironmentMsg);
            }
        };
    }
}