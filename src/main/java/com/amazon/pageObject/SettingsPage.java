package com.amazon.pageObject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {

    @FindBy(xpath = "//select[@id='icp-sc-dropdown']")
    public static WebElement currencyDrp;

    @FindBy(xpath = "//span[contains(text(),'Save changes')]")
    private static WebElement saveButton;

    @FindBy(xpath = "//span[@id='icp-sc-note']")
    private static WebElement note;

    @FindBy(xpath = "//input[@value='en_US']")
    private static WebElement radioButtonEN_US;

    @FindBy(xpath = "//input[@value='es_US']")
    private static WebElement radioButtonES_US;

    @FindBy(xpath = "//input[@value='de_DE']")
    private static WebElement radioButtonDe_DE;

    @FindBy(xpath = "//input[@value='pt_BR']")
    private static WebElement radioButtonPt_BR;

    @FindBy(xpath = "//span[@id='lop-select']")
    private static WebElement languageSettingsMsg;

    @FindBy(xpath = "//p[@id='icp-sl-t-text']")
    private static WebElement translation;

    public SettingsPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public SettingsPage selectCurrency(String currency) {
        selectFromDropdownByText(currencyDrp, currency);
        return this;
    }

    public String getCurrencyNote() {
        return note.getText();
    }

    public void changeLanguageTo(String language) {
        switch (language) {
            case "Espanol":
                clickOnElement(radioButtonES_US);
                break;
            case "Deutsh":
                clickOnElement(radioButtonDe_DE);
                break;
            case "Portugues":
                clickOnElement(radioButtonPt_BR);
                break;
            default:
                clickOnElement(radioButtonEN_US);
        }
    }

    public String getLanguageSettingsMessage() {
        return languageSettingsMsg.getText();
    }

    public String getTranslationText() {
        return translation.getText();
    }

    public SettingsPage saveSettings() {
        clickOnElement(saveButton);
        return this;
    }
}
