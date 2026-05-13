package com.opencart.tests.login;

import com.opencart.pages.LoginPage;
import com.opencart.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LF_008_LoginTest extends BaseTest {

    @Test
    public void testEmailAndPasswordFieldHavePlaceholder() {
        logger.info("Starting placeholder text test");
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        logger.info("Retrieving placeholder text from email field");
        String actualEmailFieldPlaceholderText = loginPage.getEmailFieldPlaceholderText();
        String expectedEmailFieldPlaceholderText = "E-Mail Address";
        try {
            logger.info("Validating email field placeholder text");
            Assert.assertEquals(actualEmailFieldPlaceholderText, expectedEmailFieldPlaceholderText);
        } catch (AssertionError e) {
            logger.error("Email field placeholder text test failed: {}", e.getMessage());
            Assert.fail();
        }

        logger.info("Retrieving placeholder text from password field");
        String actualPasswordFieldPlaceholderText = loginPage.getPasswordFieldPlaceholderText();
        String expectedPasswordFieldPlaceholderText = "Password";
        try {
            logger.info("Validating password field placeholder text");
            Assert.assertEquals(actualPasswordFieldPlaceholderText, expectedPasswordFieldPlaceholderText);
        } catch (AssertionError e) {
            logger.error("Password field placeholder text test failed: {}", e.getMessage());
            Assert.fail();
        }
    }
}