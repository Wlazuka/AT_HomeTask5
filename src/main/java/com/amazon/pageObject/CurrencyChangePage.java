package com.amazon.pageObject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyChangePage extends BasePage {

    @FindBy(xpath = "//select[@id='icp-sc-dropdown']")
    public static WebElement currencyDrp;

    @FindBy(xpath = "//span[contains(text(),'Save changes')]")
    private static WebElement saveButton;

    @FindBy(xpath = "//span[@id='icp-sc-note']")
    private static WebElement note;

    public CurrencyChangePage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public CurrencyChangePage selectCurrency(String currency) {
        selectFromDropdownByText(currencyDrp, currency);
        return this;
    }

    public String getCurrencyNote(){
        return note.getText();
    }

    public String pageSource(){
        return getPageSource();
    }

    public CurrencyChangePage saveSettings() {
        clickOnElement(saveButton);
        return this;
    }
}
