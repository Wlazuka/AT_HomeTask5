package com.amazon.utils;

import com.amazon.pageObject.*;
import org.openqa.selenium.WebDriver;

public class PageManager {

    public HomePage homePage;
    public SettingsPage settingsPage;
    public SearchResultsPage searchResultsPage;
    public CreateAccountPage createAccountPage;
    public SignInPage signInPage;
    public ProductDetailsPage productDetailsPage;
    public SubTotalPage subTotalPage;
    public CartPage cartPage;

    public PageManager(WebDriver driver, PropertyManager propertyManager) {
        homePage = new HomePage(driver, propertyManager);
        settingsPage = new SettingsPage(driver, propertyManager);
        searchResultsPage = new SearchResultsPage(driver, propertyManager);
        signInPage = new SignInPage(driver, propertyManager);
        createAccountPage = new CreateAccountPage(driver, propertyManager);
        productDetailsPage = new ProductDetailsPage(driver, propertyManager);
        subTotalPage = new SubTotalPage(driver, propertyManager);
        cartPage = new CartPage(driver, propertyManager);
    }
}
