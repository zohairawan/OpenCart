package com.opencart.utilities.browser;

import com.opencart.constants.Constant;
import com.opencart.utilities.properties.ConfigPropertiesFileReader;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class WebDriverSetup {

    public static WebDriver initializeDriverType() {
        WebDriver driver;
        String driverType = ConfigPropertiesFileReader.getBrowserValue();

        switch (driverType) {
            case Constant.CHROME_BROWSER -> driver = ChromeDriverSetup.initializeChromeDriver();
            case Constant.FIREFOX_BROWSER -> driver = FirefoxDriverSetup.initializeFirefoxDriver();
            //todo add log
            case null, default -> throw new RuntimeException("======= INVALID BROWSER TYPE PROVIDED =======");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigPropertiesFileReader.getImplicitWaitValue())));
        driver.manage().window().maximize();
        return driver;
    }
}