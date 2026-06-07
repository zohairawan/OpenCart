/*
 * Purpose:
 * - Contains all the methods/fields that all tests require
 * - It's abstract because there should be no reason to create an object,
 *   it only serves as a collection of methods/fields to be reused by pages
 */

package com.opencart.tests.base;

import com.opencart.driver.DriverFactory;
import com.opencart.driver.DriverManagerUtils;
import com.opencart.utilities.logger.LogManagerUtils;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    @Parameters({"browser", "operatingSystem"})
    @BeforeMethod(alwaysRun = true)
    public void setupTest(String browser, @Optional("") String operatingSystem) {
        WebDriver driver = DriverFactory.createDriver(browser, operatingSystem);
        driver.manage().window().maximize();
        DriverManagerUtils.setDriver(driver);
        ThreadContext.put("browser", browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        LogManagerUtils.getLogger(BaseTest.class).info("Quitting driver");
        WebDriver driver = DriverManagerUtils.getDriver();
        if (driver != null) {
            driver.quit();
            LogManagerUtils.getLogger(BaseTest.class).info("Driver quit successful");
        }

        DriverManagerUtils.unloadDriver();
    }
}