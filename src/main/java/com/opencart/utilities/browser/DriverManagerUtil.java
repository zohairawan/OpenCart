package com.opencart.utilities.browser;

import org.openqa.selenium.WebDriver;

public class DriverManagerUtil {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setDriverToThreadLocal(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static WebDriver getThreadLocalDriver() {
        return driverThreadLocal.get();
    }

    public static void unloadDriverThreadLocal() {
        driverThreadLocal.remove();
    }
}