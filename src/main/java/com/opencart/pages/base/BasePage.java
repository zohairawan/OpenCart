/*
 * Purpose:
 * - Contains all the methods/fields that all pages require
 * - It's abstract because there should be no reason to create an object,
 *   it only serves as a collection of methods/fields to be reused by pages
 */

package com.opencart.pages.base;

import com.opencart.utilities.logger.LogManagerUtils;
import com.opencart.utilities.methods.CommonMethodsUtils;
import com.opencart.utilities.methods.JavascriptUtils;
import com.opencart.utilities.methods.WaitUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected CommonMethodsUtils commonMethodsUtils;
    protected JavascriptUtils javascriptUtils;
    protected WaitUtils waitUtils;
    protected final Logger logger;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        commonMethodsUtils = new CommonMethodsUtils(driver);
        this.javascriptUtils = new JavascriptUtils(driver);
        waitUtils = new WaitUtils(driver);
        logger = LogManagerUtils.getLogger(this.getClass());
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void set(String text, By locator) {
        waitUtils.waitForElementToBeVisible(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void set(String text, By locator, long waitTimeInSeconds) {
        waitUtils.waitForElementToBeVisible(locator, waitTimeInSeconds).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        waitUtils.waitForElementToBeClickable(locator).click();
    }

    protected void click(By locator, long waitTimeInSeconds) {
        waitUtils.waitForElementToBeClickable(locator, waitTimeInSeconds).click();
    }
}