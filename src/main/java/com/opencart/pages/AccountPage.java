package com.opencart.pages;

import com.opencart.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    public final String URL = "https://tutorialsninja.com/demo/index.php?route=account/account";
    private final By myAccountHeader = By.xpath("//div[@id='content']/h2[normalize-space()='My Account']");
    private final By logoutLink = By.xpath("//a[@class and normalize-space()='Logout']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountPageURL() {
        logger.debug("Getting My Account page URL");
        return driver.getCurrentUrl();
    }

    public boolean isMyAccountHeaderDisplayed() {
        logger.debug("Checking if My Account Header is displayed");
        try {
            return find(myAccountHeader).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLogoutLinkDisplayed() {
        logger.debug("Checking if logout link is displayed");
        try {
            return find(logoutLink).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}