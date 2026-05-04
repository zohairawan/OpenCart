package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By myAccountIcon = By.xpath("//i[@class='fa fa-user']");
    private By registerHyperlink = By.xpath("//a[normalize-space()='Register']");
    private By loginHyperlink = By.xpath("//a[normalize-space()='Login']");

    public void open() {
        driver.get("https://tutorialsninja.com/demo/");
    }

    public void clickMyAccountDropdown() {
        click(myAccountIcon);
    }

    public RegisterPage clickRegisterHyperlink() {
        click(registerHyperlink);
        return new RegisterPage(driver);
    }

    public LoginPage clickLoginHyperlink() {
        click(loginHyperlink);
        return new LoginPage(driver);
    }
}