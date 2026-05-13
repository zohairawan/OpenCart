package com.opencart.utilities.methods;

import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {

    private final long DEFAULT_EXPLICIT_WAIT_TIME_IN_SECONDS = ConfigPropertiesFileReaderUtils.getExplicitWaitInSeconds();
    private final WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementToBeVisible(By locator, long waitTimeInSeconds) {
        return getWaitObject(waitTimeInSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return getWaitObject(DEFAULT_EXPLICIT_WAIT_TIME_IN_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator, long waitTimeInSeconds) {
        return getWaitObject(waitTimeInSeconds).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return getWaitObject(DEFAULT_EXPLICIT_WAIT_TIME_IN_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebDriverWait getWaitObject(long waitTimeInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
    }
}