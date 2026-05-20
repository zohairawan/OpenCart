package com.opencart.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public interface DriverProvider {

    WebDriver createDriver(MutableCapabilities options);
}