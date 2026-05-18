package com.opencart.tests.login;

import com.aventstack.extentreports.ExtentTest;
import com.opencart.dataprovider.DataProviders;
import com.opencart.pages.LoginPage;
import com.opencart.tests.base.BaseTest;
import com.opencart.utilities.report.ExtentReportUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginDDTest extends BaseTest {

    @Test(groups = {"demo"}, dataProvider = "invalidLoginData", dataProviderClass = DataProviders.class)
    public void testInvalidLoginFromExcelFile(String email, String password) {
        ExtentTest extentTest = ExtentReportUtils.getTest();
        extentTest.info("Starting invalid login data driven test");
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        extentTest.info("Authenticating with invalid credentials");
        loginPage.loginInvalidUser(email, password);

        String expectedInvalidUserErrorMsg = loginPage.INVALID_USER_ERROR_MSG;
        String actualInvalidUserErrorMsg = loginPage.getInvalidUserErrorMsg();
        extentTest.info("Validating error message");
        Assert.assertEquals(actualInvalidUserErrorMsg, expectedInvalidUserErrorMsg);
    }
}