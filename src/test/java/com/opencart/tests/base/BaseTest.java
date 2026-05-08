package com.opencart.tests.base;

import com.opencart.pages.HomePage;
import com.opencart.utilities.browser.DriverManager;
import com.opencart.utilities.browser.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriver driver = WebDriverSetup.initializeDriverType();
        DriverManager.setDriverToThreadLocal(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver driver = DriverManager.getThreadLocalDriver();
        if (driver != null) {
            driver.quit();
        }

        DriverManager.unloadDriverThreadLocal();
    }
}