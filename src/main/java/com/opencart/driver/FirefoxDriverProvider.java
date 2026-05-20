package com.opencart.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverProvider implements DriverProvider {
    @Override
    public WebDriver createDriver(MutableCapabilities options) {
        FirefoxOptions firefoxOptions = (FirefoxOptions) options;
        return new FirefoxDriver(firefoxOptions);
    }
}