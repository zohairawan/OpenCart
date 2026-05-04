package com.opencart.tests.register;

import com.opencart.tests.base.BaseTest;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void testRegisterUser() {
        homePage.open();
        homePage.clickMyAccountDropdown();
        homePage.clickRegisterHyperlink();
    }
}