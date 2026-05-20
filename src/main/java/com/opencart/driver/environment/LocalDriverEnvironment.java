package com.opencart.driver.environment;

import com.opencart.driver.DriverProvider;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public class LocalDriverEnvironment implements DriverEnvironment {
    @Override
    public WebDriver createWebDriver(MutableCapabilities options, DriverProvider provider) {
        return provider.createDriver(options);
    }
}