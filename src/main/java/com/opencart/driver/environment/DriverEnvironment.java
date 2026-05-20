package com.opencart.driver.environment;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public interface DriverEnvironment {

    WebDriver createWebDriver(MutableCapabilities options);
}