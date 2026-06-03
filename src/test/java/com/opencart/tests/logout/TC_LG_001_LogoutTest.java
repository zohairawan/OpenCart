package com.opencart.tests.logout;

import com.aventstack.extentreports.ExtentTest;
import com.opencart.pages.AccountLogoutPage;
import com.opencart.pages.AccountPage;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.tests.base.BaseTest;
import com.opencart.utilities.browser.DriverManagerUtils;
import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import com.opencart.utilities.report.ExtentReportUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LG_001_LogoutTest extends BaseTest {

    @Test(groups = {"sanity"})
    public void testLogout() {
        ExtentTest extentTest = ExtentReportUtils.getTest();
        extentTest.info("Login test is starting");
        HomePage homePage = new HomePage(DriverManagerUtils.getDriver());
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        extentTest.info("User logs in with valid credentials");
        AccountPage accountPage = loginPage.loginValidUser(ConfigPropertiesFileReaderUtils.getValidEmail(), ConfigPropertiesFileReaderUtils.getValidPassword());

        extentTest.info("User logs out");
        AccountLogoutPage accountLogoutPage = accountPage.clickLogoutLink();

        extentTest.info("Validating Account Logout header is displayed");
        String expectedAccountLogoutHeaderText = "Account Logout";
        String actualAccountHeaderLogoutHeaderText = accountLogoutPage.getAccountLogoutHeaderText();
        Assert.assertEquals(actualAccountHeaderLogoutHeaderText, expectedAccountLogoutHeaderText);
    }
}