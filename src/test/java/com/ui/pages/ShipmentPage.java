package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShipmentPage extends BrowserUtility {
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//button[@name='processCarrier']");
    private static final By TERMS_AND_CONDITIONS_CHECKBOX = By.id("cgv");

    public ShipmentPage(WebDriver driver) {
        super(driver);
    }

    public ShipmentPage checkTermsAndConditions(){
        clickOnCheckBox(TERMS_AND_CONDITIONS_CHECKBOX);
        return this;
    }
    public PaymentPage goToPaymentPage(){
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new PaymentPage(getDriver());
    }
}
