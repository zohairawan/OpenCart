package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSuccessfullyCreatedPage extends BasePage {

    public AccountSuccessfullyCreatedPage(WebDriver driver) {
        super(driver);
    }

    private By accountSuccessfullyCreatedHeader = By.xpath("//div[@id='content']/h1[normalize-space()='Your Account Has Been Created!']");

    public String getAccountSuccessfullyCreatedHeaderText() {
        return find(accountSuccessfullyCreatedHeader).getText();
    }
}