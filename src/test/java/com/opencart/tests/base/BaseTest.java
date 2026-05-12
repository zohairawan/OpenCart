package com.opencart.tests.base;

import com.opencart.pages.HomePage;
import com.opencart.utilities.browser.DriverManagerUtils;
import com.opencart.utilities.browser.WebDriverSetupUtils;
import com.opencart.utilities.logger.LogManagerUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected HomePage homePage;
    protected final Logger logger = LogManagerUtils.getLogger(this.getClass());

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriver driver = WebDriverSetupUtils.initializeDriverType();
        DriverManagerUtils.setDriverToThreadLocal(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver driver = DriverManagerUtils.getThreadLocalDriver();
        if (driver != null) {
            driver.quit();
        }

        DriverManagerUtils.unloadDriverThreadLocal();
    }
}