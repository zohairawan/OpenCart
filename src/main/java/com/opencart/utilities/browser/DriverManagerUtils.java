package com.opencart.utilities.browser;

import org.openqa.selenium.WebDriver;

public class DriverManagerUtils {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void createThreadLocalDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static WebDriver getThreadLocalDriver() {
        return driverThreadLocal.get();
    }

    public static void unloadThreadLocalDriver() {
        driverThreadLocal.remove();
    }
}