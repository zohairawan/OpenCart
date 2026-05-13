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

        logger.info("Authenticating with valid credentials");
        AccountPage accountPage = loginPage.loginValidUser(ConfigPropertiesFileReaderUtils.getValidEmail(), ConfigPropertiesFileReaderUtils.getValidPassword());

        logger.info("Retrieving account page URL");
        String actualAccountPageURL = accountPage.getAccountPageURL();
        String expectedAccountPageURL = accountPage.URL;
        try {
            logger.info("Validating successful login");
            Assert.assertEquals(actualAccountPageURL, expectedAccountPageURL);
            logger.info("Valid login test passed");
        } catch (AssertionError e) {
            logger.error("Valid login test failed: {}", e.getMessage());
            Assert.fail();
        }
    }
}