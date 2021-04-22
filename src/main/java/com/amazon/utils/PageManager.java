package com.amazon.utils;

import com.amazon.pageObject.CurrencyChangePage;
import com.amazon.pageObject.HomePage;
import org.openqa.selenium.WebDriver;

public class PageManager {

    public HomePage homePage;
    public CurrencyChangePage currencyChangePage;

    public PageManager(WebDriver driver, PropertyManager propertyManager) {
        this.homePage = new HomePage(driver, propertyManager);
        this.currencyChangePage = new CurrencyChangePage(driver, propertyManager);
    }
}
