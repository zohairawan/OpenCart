package com.opencart.tests.login;

import com.opencart.pages.AccountPage;
import com.opencart.pages.LoginPage;
import com.opencart.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LF_001_LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        logger.info("Starting valid login test");
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        logger.info("Authenticating with valid credentials");
        AccountPage accountPage = loginPage.loginValidUser("jd@demo.com", "demo123");

        String actualAccountPageURL = accountPage.getAccountPageURL();
        String expectedAccountPageURL = accountPage.URL;
        logger.info("Validating successful login");
        try {
            Assert.assertEquals(actualAccountPageURL, expectedAccountPageURL);
            logger.info("Valid login test passed");
        } catch (AssertionError e) {
            logger.error("Valid login test failed: " + e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        logger.info("Starting invalid login test");
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        logger.info("Authenticating with invalid credentials");
        loginPage.loginInvalidUser("wrong@demo.com", "wrongpwd");

        String expectedInvalidUserErrorMsg = loginPage.INVALID_USER_ERROR_MSG;
        String actualInvalidUserErrorMsg = loginPage.getInvalidUserErrorMsg();
        logger.info("Validating error message");
        try {
            Assert.assertEquals(actualInvalidUserErrorMsg, expectedInvalidUserErrorMsg);
            logger.info("Invalid login test passed");
        } catch (AssertionError e) {
            logger.error("Invalid login test failed");
            Assert.fail();
        }
    }
}