/*
 * Purpose:
 * - Creates a ThreadLocal WebDriver which
 *   ensures each parallel test thread receives its own isolated WebDriver object
 * - Prevents driver collision during parallel execution
 */

package com.opencart.utilities.browser;

import org.openqa.selenium.WebDriver;

public class DriverManagerUtils {

    /*
     * Why static?
     * The WebDriver value stored inside ThreadLocal is isolated per thread,
     * meaning each thread gets its own independent WebDriver instance
     * even though the ThreadLocal itself is shared
     * ThreadLocal = locker room
     * Locker contains WebDriver specific to that thread
     * Threads can access any locker room (ThreadLocal)
     */
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        DriverManagerUtils.driver.set(driver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void unloadDriver() {
        driver.remove();
    }
}