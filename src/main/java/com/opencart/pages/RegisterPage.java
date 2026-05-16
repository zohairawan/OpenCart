package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private final By firstNameField = By.xpath("//input[@id='input-firstname']");
    private final By lastNameField = By.xpath("//input[@id='input-lastname']");
    private final By emailField = By.xpath("//input[@id='input-email']");
    private final By telephoneNumberField = By.xpath("//input[@id='input-telephone']");
    private final By passwordField = By.xpath("//input[@id='input-password']");
    private final By passwordConfirmField = By.xpath("//input[@id='input-confirm']");
    private final By privacyPolicyCheckbox = By.xpath("//input[@name='agree']");
    private final By continueButton = By.xpath("//input[@type='submit']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

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
        logger.debug("Entering firstname: {}", firstName);
        set(firstName, firstNameField);
    }

    private void enterLastName(String lastName) {
        logger.debug("Entering lastname: {}", lastName);
        set(lastName, lastNameField);
    }

    private void enterEmail(String email) {
        logger.debug("Entering email: {}", email);
        set(email, emailField);
    }

    private void enterTelephone(String telephoneNumber) {
        logger.debug("Entering telephone number: {}", telephoneNumber);
        set(telephoneNumber, telephoneNumberField);
    }

    private void enterPassword(String password) {
        logger.debug("Entering password: {}", password);
        set(password, passwordField);
    }

    private void enterPasswordConfirm(String confirmPassword) {
        logger.debug("Re-entering password: {}", confirmPassword);
        set(confirmPassword, passwordConfirmField);
    }

    private void clickPrivacyPolicyCheckbox() {
        logger.debug("Clicking privacy policy checkbox");
        click(privacyPolicyCheckbox);
    }

    private AccountSuccessfullyCreatedPage clickContinueButton() {
        logger.debug("Clicking continue button");
        click(continueButton);
        logger.debug("Navigating to Account Successfully Created page");
        return new AccountSuccessfullyCreatedPage(driver);
    }
}