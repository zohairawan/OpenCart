package com.opencart.tests.login;

import com.aventstack.extentreports.ExtentTest;
import com.opencart.pages.AccountPage;
import com.opencart.pages.LoginPage;
import com.opencart.tests.base.BaseTest;
import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import com.opencart.utilities.report.ExtentReportUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LF_001_LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        ExtentTest extentTest = ExtentReportUtils.getThreadLocalTest();
        extentTest.info("Login test is starting");
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        extentTest.info("User logs in with valid credentials");
        AccountPage accountPage = loginPage.loginValidUser(ConfigPropertiesFileReaderUtils.getValidEmail(), ConfigPropertiesFileReaderUtils.getValidPassword());

        extentTest.info("Getting account page URL");
        String actualAccountPageURL = accountPage.getAccountPageURL();
        String expectedAccountPageURL = accountPage.URL;
        extentTest.info("Validating successful login - comparing URL");
        Assert.assertEquals(actualAccountPageURL, expectedAccountPageURL);

        extentTest.info("Validating successful login - My Account header is displayed");
        Assert.assertTrue(accountPage.isMyAccountHeaderDisplayed());

        extentTest.info("Validating successful login - logout link is displayed");
        Assert.assertTrue(accountPage.isLogoutLinkDisplayed());
    }
}