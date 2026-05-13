package com.opencart.tests.login;

import com.opencart.pages.AccountPage;
import com.opencart.pages.LoginPage;
import com.opencart.tests.base.BaseTest;
import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LF_001_LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        logger.info("Starting valid login test");
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        logger.info("Entering valid credentials");
        AccountPage accountPage = loginPage.loginValidUser(ConfigPropertiesFileReaderUtils.getValidEmail(), ConfigPropertiesFileReaderUtils.getValidPassword());

        logger.info("Retrieving account page URL");
        String actualAccountPageURL = accountPage.getAccountPageURL();
        String expectedAccountPageURL = accountPage.URL;
        try {
            logger.info("Validating successful login - comparing URL");
            Assert.assertEquals(actualAccountPageURL, expectedAccountPageURL);
        } catch (AssertionError e) {
            logger.error("Valid login test failed - URL comparison failed: {}", e.getMessage());
            Assert.fail();
        }

        logger.info("Validating successful login - My Account header is displayed");
        try {
            Assert.assertTrue(accountPage.isMyAccountHeaderDisplayed());
        } catch (AssertionError e) {
            logger.error("Valid login test failed - My Account header is not displayed: {}", e.getMessage());
            Assert.fail();
        }

        logger.info("Validating successful login - logout link is displayed");
        try {
            Assert.assertTrue(accountPage.isLogoutLinkDisplayed());
        } catch (AssertionError e) {
            logger.error("Valid login test failed - Logout link is not displayed: {}", e.getMessage());
            Assert.fail();
        }

        logger.info("Valid login test passed");
    }
}