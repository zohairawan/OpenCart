package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountLogoutPage extends BasePage {

    private final By accountLogoutHeader = By.xpath("//h1[normalize-space()='Account Logout']");

    public AccountLogoutPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountLogoutHeaderText() {
        return textOf(accountLogoutHeader);
    }
}