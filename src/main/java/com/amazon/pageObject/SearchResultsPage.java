package com.amazon.pageObject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBys({
            @FindBy(xpath = "//a[@class='a-link-normal a-text-normal']")})
    public static List<WebElement> results;

    public SearchResultsPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public SearchResultsPage chooseFirstResult() {
        clickOnElement(results.get(0));
        return this;
    }
}
