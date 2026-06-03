package com.opencart.pages.components;

import com.opencart.pages.ProductSearchPage;
import com.opencart.utilities.logger.LogManagerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderComponent {

    private final WebDriver driver;
    private final By searchBar = By.xpath("//div[@id='search']/input[@name='search']");
    private final By searchButton = By.xpath("//div[@id='search']/span[@class='input-group-btn']");

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
    }

    public ProductSearchPage searchForProduct(String product) {
        LogManagerUtils.getLogger(this.getClass()).debug("Searching for product '{}'", product);
        WebElement searchBarElement = driver.findElement(searchBar);
        searchBarElement.clear();
        searchBarElement.sendKeys(product);
        driver.findElement(searchButton).click();
        return new ProductSearchPage(driver);
    }
}