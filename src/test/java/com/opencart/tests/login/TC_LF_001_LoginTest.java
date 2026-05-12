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
        homePage.clickMyAccountDropdown();
        LoginPage loginPage = homePage.clickLoginLink();
        logger.info("Authenticating with valid credentials");
        loginPage.enterEmail("jd@demo.com");
        loginPage.enterPassword("demo123");
        AccountPage accountPage = loginPage.clickLoginButton();
        String actualAccountPageURL = accountPage.getAccountPageURL();
        String expectedAccountPageURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
        logger.info("Validating successful login");
        try {
            Assert.assertEquals(actualAccountPageURL, expectedAccountPageURL);
            logger.info("Valid login test passed");
        } catch (AssertionError e) {
            logger.error("Valid login test failed: " + e.getMessage());
            Assert.fail();
        }
    }
}