package com.opencart.pages.base;

import com.opencart.utilities.logger.LogManagerUtil;
import com.opencart.utilities.methods.CommonMethodsUtil;
import com.opencart.utilities.methods.JavascriptUtil;
import com.opencart.utilities.methods.WaitUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected CommonMethodsUtil commonMethodsUtil;
    protected JavascriptUtil javascriptUtil;
    protected WaitUtil waitUtil;
    protected final Logger logger;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        commonMethodsUtil = new CommonMethodsUtil(driver);
        this.javascriptUtil = new JavascriptUtil(driver);
        waitUtil = new WaitUtil(driver);
        logger = LogManagerUtil.getLogger(this.getClass());
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void set(String text, By locator) {
        waitUtil.waitForElementToBeVisible(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void set(String text, By locator, long waitTimeInSeconds) {
        waitUtil.waitForElementToBeVisible(locator, waitTimeInSeconds).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        waitUtil.waitForElementToBeClickable(locator).click();
    }

    protected void click(By locator, long waitTimeInSeconds) {
        waitUtil.waitForElementToBeClickable(locator, waitTimeInSeconds).click();
    }
}