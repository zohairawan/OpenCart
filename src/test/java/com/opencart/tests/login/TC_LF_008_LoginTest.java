package com.opencart.tests.login;

import com.aventstack.extentreports.ExtentTest;
import com.opencart.pages.LoginPage;
import com.opencart.tests.base.BaseTest;
import com.opencart.utilities.report.ExtentReportUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LF_008_LoginTest extends BaseTest {

    @Test
    public void testEmailAndPasswordFieldHavePlaceholder() {
        ExtentTest extentTest = ExtentReportUtils.getThreadLocalTest();
        extentTest.info("Starting email and password placeholder text test");
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        extentTest.info("Retrieving placeholder text from email field");
        String actualEmailFieldPlaceholderText = loginPage.getEmailFieldPlaceholderText();
        String expectedEmailFieldPlaceholderText = "E-Mail Address";
        extentTest.info("Validating email field placeholder text");
        Assert.assertEquals(actualEmailFieldPlaceholderText, expectedEmailFieldPlaceholderText);

        extentTest.info("Retrieving placeholder text from password field");
        String actualPasswordFieldPlaceholderText = loginPage.getPasswordFieldPlaceholderText();
        String expectedPasswordFieldPlaceholderText = "Password";
        extentTest.info("Validating password field placeholder text");
        Assert.assertEquals(actualPasswordFieldPlaceholderText, expectedPasswordFieldPlaceholderText);

        extentTest.pass("Email and password placeholder text test passed");
    }
}