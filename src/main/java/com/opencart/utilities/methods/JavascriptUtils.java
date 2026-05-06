package com.opencart.utilities.methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtils {

    private JavascriptExecutor javascriptExecutor;

    public JavascriptUtils(WebDriver driver) {
        javascriptExecutor = ((JavascriptExecutor) driver);
    }

    public void clickJS(WebElement webElement) {
        javascriptExecutor.executeScript("arguments[0].click();", webElement);
    }

    public void scrollToCenterOfElementJS(WebElement webElement) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block:'center'});", webElement);
    }
}