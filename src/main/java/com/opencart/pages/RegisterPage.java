package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameField = By.xpath("//input[@id='input-firstname']");
    private By lastNameField = By.xpath("//input[@id='input-lastname']");
    private By emailField = By.xpath("//input[@id='input-email']");
    private By telephoneNumberField = By.xpath("//input[@id='input-telephone']");
    private By passwordField = By.xpath("//input[@id='input-password']");
    private By passwordConfirmField = By.xpath("//input[@id='input-confirm']");
    private By privacyPolicyCheckbox = By.xpath("//input[@name='agree']");
    private By continueButton = By.xpath("//input[@type='submit']");

    public AccountSuccessfullyCreatedPage registerUser(String firstName, String lastName, String email, String telephoneNumber, String password, String confirmPassword) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterTelephone(telephoneNumber);
        enterPassword(password);
        enterPasswordConfirm(confirmPassword);
        clickPrivacyPolicyCheckbox();
        return clickContinueButton();
    }

    private void enterFirstName(String firstName) {
        set(firstName, firstNameField);
    }

    private void enterLastName(String lastName) {
        set(lastName, lastNameField);
    }

    private void enterEmail(String email) {
        set(email, emailField);
    }

    private void enterTelephone(String telephoneNumber) {
        set(telephoneNumber, telephoneNumberField);
    }

    private void enterPassword(String password) {
        set(password, passwordField);
    }

    private void enterPasswordConfirm(String confirmPassword) {
        set(confirmPassword, passwordConfirmField);
    }

    private void clickPrivacyPolicyCheckbox() {
        click(privacyPolicyCheckbox);
    }

    private AccountSuccessfullyCreatedPage clickContinueButton() {
        click(continueButton);
        return new AccountSuccessfullyCreatedPage(driver);
    }
}