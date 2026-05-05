package com.opencart.tests.register;

import com.opencart.pages.AccountSuccessfullyCreatedPage;
import com.opencart.pages.RegisterPage;
import com.opencart.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001_RegisterTest extends BaseTest {

    @Test
    public void testRegisterUser() {
        homePage.open();
        homePage.clickMyAccountDropdown();
        RegisterPage registerPage = homePage.clickRegisterHyperlink();
        AccountSuccessfullyCreatedPage accountSuccessfullyCreatedPage = registerPage.registerUser("J", "D", "jd@demo.com", "111-111-1111", "demo123", "demo123");
        String actualAccountSuccessfullyCreatedText = accountSuccessfullyCreatedPage.getAccountSuccessfullyCreatedHeaderText();
        String expectedAccountSuccessfullyCreatedText = "Your Account Has Been Created!";
        Assert.assertEquals(actualAccountSuccessfullyCreatedText, expectedAccountSuccessfullyCreatedText);
    }
}