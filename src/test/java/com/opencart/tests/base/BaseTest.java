package com.opencart.tests.base;

import com.opencart.pages.HomePage;
import com.opencart.utilities.browser.WebDriverSetup;
import com.opencart.utilities.properties.ConfigPropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = WebDriverSetup.initializeDriverType();
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}