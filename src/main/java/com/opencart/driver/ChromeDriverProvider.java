package com.opencart.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverProvider implements DriverProvider {

    @Override
    public WebDriver createDriver(MutableCapabilities options) {
        ChromeOptions chromeOptions = (ChromeOptions) options;
        return new ChromeDriver(chromeOptions);
    }
}