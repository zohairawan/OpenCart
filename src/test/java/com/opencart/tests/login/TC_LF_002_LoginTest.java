package com.opencart.tests.login;

import com.opencart.pages.LoginPage;
import com.opencart.tests.base.BaseTest;
import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LF_002_LoginTest extends BaseTest {

    @Test
    public void testLoginWithInvalidCredentials() {
        loggerUtil.info("Starting invalid login test");
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        loggerUtil.info("Authenticating with invalid credentials");
        loginPage.loginInvalidUser(ConfigPropertiesFileReaderUtil.getInvalidEmail(), ConfigPropertiesFileReaderUtil.getInvalidPassword());

        String expectedInvalidUserErrorMsg = loginPage.INVALID_USER_ERROR_MSG;
        String actualInvalidUserErrorMsg = loginPage.getInvalidUserErrorMsg();
        loggerUtil.info("Validating error message");
        try {
            Assert.assertEquals(actualInvalidUserErrorMsg, expectedInvalidUserErrorMsg);
            loggerUtil.info("Invalid login test passed");
        } catch (AssertionError e) {
            loggerUtil.error("Invalid login test failed: {}", e.getMessage());
            Assert.fail();
        }
    }
}