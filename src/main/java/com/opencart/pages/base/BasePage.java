package com.opencart.pages.base;

import com.opencart.utilities.logger.LogManagerUtils;
import com.opencart.utilities.methods.JavascriptUtils;
import com.opencart.utilities.methods.WaitUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected JavascriptUtils javascript;
    protected WaitUtils wait;
    protected final Logger logger;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.javascript = new JavascriptUtils(driver);
        wait = new WaitUtils(driver);
        logger = LogManagerUtils.getLogger(this.getClass());
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void set(String text, By locator) {
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }
}