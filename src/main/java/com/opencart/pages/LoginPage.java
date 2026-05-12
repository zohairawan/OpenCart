package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public final String INVALID_USER_ERROR_MSG = "Warning: No match for E-Mail Address and/or Password.";
    private By invalidUserErrorMsgLoc = By.xpath("//div[normalize-space()='Warning: No match for E-Mail Address and/or Password.']");
    private By emailField = By.xpath("//input[@id='input-email']");
    private By passwordField = By.xpath("//input[@id='input-password']");
    private By loginButton = By.xpath("//input[@value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

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

    public AccountPage loginValidUser(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        return clickLoginButton();
    }

    public void loginInvalidUser(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getInvalidUserErrorMsg() {
        return find(invalidUserErrorMsgLoc).getText();
    }
}