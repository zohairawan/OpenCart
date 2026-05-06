package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.xpath("//input[@id='input-email']");
    private By passwordField = By.xpath("//input[@id='input-password']");
    private By loginButton = By.xpath("//input[@value='Login']");

    public void enterEmail(String email) {
        set(email, emailField);
    }

    public void enterPassword(String password) {
        set(password, passwordField);
    }

    public AccountPage clickLoginButton() {
        click(loginButton);
        return new AccountPage(driver);
    }
}