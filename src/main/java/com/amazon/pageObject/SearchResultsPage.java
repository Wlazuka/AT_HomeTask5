package com.amazon.pageObject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//span[@cel_widget_id='MAIN-SEARCH_RESULTS-1']//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public static WebElement firstResutlInSearch;

    public SearchResultsPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public SearchResultsPage choseFirstResult() {
        clickOnElement(firstResutlInSearch);
        return this;
    }
}
