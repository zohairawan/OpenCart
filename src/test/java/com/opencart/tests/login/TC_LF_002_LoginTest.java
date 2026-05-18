package com.opencart.tests.login;

import com.aventstack.extentreports.ExtentTest;
import com.opencart.pages.LoginPage;
import com.opencart.tests.base.BaseTest;
import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import com.opencart.utilities.report.ExtentReportUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LF_002_LoginTest extends BaseTest {

    @Test(groups = {"sanity", "2"})
    public void testLoginWithInvalidCredentials() {
        ExtentTest extentTest = ExtentReportUtils.getTest();
        extentTest.info("Starting invalid login test");
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        extentTest.info("Authenticating with invalid credentials");
        loginPage.loginInvalidUser(ConfigPropertiesFileReaderUtils.getInvalidEmail(), ConfigPropertiesFileReaderUtils.getInvalidPassword());

        String expectedInvalidUserErrorMsg = loginPage.INVALID_USER_ERROR_MSG;
        String actualInvalidUserErrorMsg = loginPage.getInvalidUserErrorMsg();
        extentTest.info("Validating error message");
        Assert.assertEquals(actualInvalidUserErrorMsg, expectedInvalidUserErrorMsg);
    }
}