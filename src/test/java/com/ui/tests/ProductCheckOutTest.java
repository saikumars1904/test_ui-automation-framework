package com.ui.tests;

import com.ui.listeners.TestListeners;
import com.ui.pages.SearchResultPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Size.M;
import static org.testng.Assert.assertTrue;
@Listeners({TestListeners.class})
public class ProductCheckOutTest extends TestBase{
    private SearchResultPage searchResultPage;
    private static final String SEARCH_TERM = "Printed summer dress";
    @BeforeMethod(description = "User logs into the application and searches for a product")
    public void setUp(){
        searchResultPage = homePage.goToLoginPage().doLoginWith("wabof52871@movfull.com", "password")
                 .searchForAProduct(SEARCH_TERM);
    }

    @Test(description = "Verify if the logged in user is able to buy a dress", groups = {"e2e","smoke","sanity"})
    public void checkOutTest()
    {
        String successMsg =  searchResultPage.clickOnTheProductAtIndex(0).changeSize(M).addToCart().proceedCheckOutPage().goToConfirmAddressPage().goToShipmentPage().checkTermsAndConditions().goToPaymentPage()
                .goToOrderSummaryPage().goToOrderConfirmationPage().orderSuccessMessage();
        System.out.println(successMsg);
        assertTrue(successMsg.contains("complete"));
    }

}
