package com.opencart.pages;

import com.opencart.constants.Constant;
import com.opencart.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By myAccountIcon = By.xpath("//i[@class='fa fa-user']");
    private By registerLink = By.xpath("//a[normalize-space()='Register']");
    private By loginLink = By.xpath("//a[normalize-space()='Login']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        logger.debug("Launching application (url: " + Constant.URL + ")");
        driver.get(Constant.URL);
    }

    public void clickMyAccountDropdown() {
        logger.debug("Clicking my account dropdown");
        click(myAccountIcon);
    }

    public RegisterPage clickRegisterLink() {
        logger.debug("Clicking register link");
        click(registerLink);
        return new RegisterPage(driver);
    }

    public LoginPage clickLoginLink() {
        logger.debug("Clicking login link");
        click(loginLink);
        return new LoginPage(driver);
    }

    public LoginPage goToLoginPage() {
        clickMyAccountDropdown();
        return clickLoginLink();
    }
}