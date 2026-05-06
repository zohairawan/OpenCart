package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountPageURL() {
        return driver.getCurrentUrl();
    }
}