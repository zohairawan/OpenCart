package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSuccessfullyCreatedPage extends BasePage {

    private final By accountSuccessfullyCreatedHeader = By.xpath("//div[@id='content']/h1[normalize-space()='Your Account Has Been Created!']");

    public AccountSuccessfullyCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountSuccessfullyCreatedHeaderText() {
        logger.debug("Getting Account Successfully Created message");
        return find(accountSuccessfullyCreatedHeader).getText();
    }
}