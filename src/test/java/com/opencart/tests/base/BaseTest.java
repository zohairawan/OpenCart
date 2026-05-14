package com.opencart.tests.base;

import com.opencart.pages.HomePage;
import com.opencart.utilities.browser.DriverManagerUtil;
import com.opencart.utilities.browser.WebDriverSetupUtil;
import com.opencart.utilities.logger.LogManagerUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    protected HomePage homePage;
    protected final Logger loggerUtil = LogManagerUtil.getLogger(this.getClass());

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional String browser) {
        WebDriver driver = WebDriverSetupUtil.initializeDriverType(browser);
        DriverManagerUtil.setDriverToThreadLocal(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver driver = DriverManagerUtil.getThreadLocalDriver();
        if (driver != null) {
            driver.quit();
        }

        DriverManagerUtil.unloadDriverThreadLocal();
    }
}