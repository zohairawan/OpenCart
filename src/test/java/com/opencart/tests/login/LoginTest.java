package com.opencart.tests.login;

import com.opencart.pages.AccountPage;
import com.opencart.pages.LoginPage;
import com.opencart.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        homePage.open();
        homePage.clickMyAccountDropdown();
        LoginPage loginPage = homePage.clickLoginHyperlink();
        loginPage.enterEmail("jd@demo.com");
        loginPage.enterPassword("demo123");
        AccountPage accountPage = loginPage.clickLoginButton();
        String actualAccountPageURL = accountPage.getAccountPageURL();
        String expectedAccountPageURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
        Assert.assertEquals(actualAccountPageURL, expectedAccountPageURL);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}