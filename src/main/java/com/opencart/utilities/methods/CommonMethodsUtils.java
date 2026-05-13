package com.opencart.utilities.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonMethodsUtils {

    private final WebDriver driver;

    public CommonMethodsUtils(WebDriver driver) {
        this.driver = driver;
    }

    public String getPlaceholderText(By locator) {
        return driver.findElement(locator).getDomAttribute("placeholder");
    }
}