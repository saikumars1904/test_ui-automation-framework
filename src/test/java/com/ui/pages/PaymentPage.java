package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BrowserUtility {

    private static final By PAY_BY_BANK_WIRE_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public OrderSummaryPage goToOrderSummaryPage(){
        clickOn(PAY_BY_BANK_WIRE_LOCATOR);
        return new OrderSummaryPage(getDriver());
    }

}
