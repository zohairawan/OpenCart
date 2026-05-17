/*
 * Purpose:
 * - Contains all the methods/fields that all tests require
 * - It's abstract because there should be no reason to create an object,
 *   it only serves as a collection of methods/fields to be reused by pages
 */

package com.opencart.tests.base;

import com.opencart.pages.HomePage;
import com.opencart.utilities.browser.DriverManagerUtils;
import com.opencart.utilities.browser.WebDriverSetupUtils;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    protected HomePage homePage;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setupTest(String browser) {
        WebDriver driver = WebDriverSetupUtils.initializeDriverType(browser);
        ThreadContext.put("browser", browser);
        DriverManagerUtils.setDriver(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        WebDriver driver = DriverManagerUtils.getDriver();
        if (driver != null) {
            driver.quit();
        }

        DriverManagerUtils.unloadDriver();
    }
}