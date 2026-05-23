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
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_EXPLICIT_WAIT_TIME_IN_SECONDS));
    }

    public WebElement waitForElementToBeVisible(By locator, long waitTimeInSeconds) {
        return getWaitObject(waitTimeInSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator, long waitTimeInSeconds) {
        return getWaitObject(waitTimeInSeconds).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForURLToLoad(String url, long waitTimeInSeconds) {
        getWaitObject(waitTimeInSeconds)
                .until(ExpectedConditions.urlToBe(url));
    }

    public void waitForURLToLoad(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    private WebDriverWait getWaitObject(long waitTimeInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
    }
}