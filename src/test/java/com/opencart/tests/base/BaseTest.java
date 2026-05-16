package com.opencart.tests.base;

import com.opencart.pages.HomePage;
import com.opencart.utilities.browser.DriverManagerUtils;
import com.opencart.utilities.browser.WebDriverSetupUtils;
import com.opencart.utilities.logger.LogManagerUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    protected HomePage homePage;
    protected final Logger loggerUtil = LogManagerUtils.getLogger(this.getClass());

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setupTest(@Optional String browser) {
        loggerUtil.debug("Initializing browser type");
        WebDriver driver = WebDriverSetupUtils.initializeDriverType(browser);
        loggerUtil.debug("Making browser thread-safe");
        DriverManagerUtils.createThreadLocalDriver(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        loggerUtil.debug("Closing browser");
        WebDriver driver = DriverManagerUtils.getThreadLocalDriver();
        if (driver != null) {
            driver.quit();
        }

        DriverManagerUtils.unloadThreadLocalDriver();
    }
}