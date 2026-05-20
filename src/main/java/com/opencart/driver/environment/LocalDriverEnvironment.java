package com.opencart.driver.environment;

import com.opencart.utilities.logger.LogManagerUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LocalDriverEnvironment implements DriverEnvironment {
    @Override
    public WebDriver createWebDriver(MutableCapabilities options) {
        if (options instanceof ChromeOptions chromeOptions) {
            return new ChromeDriver(chromeOptions);
        }

        if (options instanceof FirefoxOptions firefoxOptions) {
            return new FirefoxDriver(firefoxOptions);
        }

        String invalidOptionErrorMsg = "Invalid browser option type: '" + options.getClass().getSimpleName() + "'";
        LogManagerUtils.getLogger(LocalDriverEnvironment.class).error(invalidOptionErrorMsg);
        throw new IllegalArgumentException(invalidOptionErrorMsg);
    }
}