package com.opencart.utilities.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonMethods {

    private final WebDriver driver;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    public String getPlaceholderText(By locator) {
        return driver.findElement(locator).getDomAttribute("placeholder");
    }
}