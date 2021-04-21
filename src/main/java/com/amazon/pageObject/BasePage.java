package com.amazon.pageObject;

import com.amazon.utils.PropertyManager;
import com.amazon.utils.Wait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v89.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage extends Page {

    protected Wait wait;
    protected WebDriver driver;
    protected PropertyManager propertyManager;

    public BasePage(WebDriver driver, PropertyManager propertyManager) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.propertyManager = propertyManager;
        this.wait = new Wait(this.driver);
    }

    public void checkPageTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    protected void pressKey(Keys key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }

    protected void openWebPage(String url) {
        driver.navigate().to(url);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    protected void enterTextIntoField(WebElement element, String text) {
        Actions actions = new Actions(driver);
        actions.sendKeys(element, text).perform();
    }

    protected void clickOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

    protected void selectFromDropdownByValue(WebElement element, String value) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    protected void selectFromDropdownByText(WebElement element, String value) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(value);
    }
}
