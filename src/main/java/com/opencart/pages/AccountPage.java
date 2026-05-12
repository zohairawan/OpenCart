package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    public final String URL = "https://tutorialsninja.com/demo/index.php?route=account/account";

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountPageURL() {
        return driver.getCurrentUrl();
    }
}