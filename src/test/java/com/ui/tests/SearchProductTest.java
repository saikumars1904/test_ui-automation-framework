package com.ui.tests;

import com.ui.listeners.TestListeners;
import com.ui.pages.MyAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners({TestListeners.class})
public class SearchProductTest extends TestBase{

    private MyAccountPage myAccountPage;
    private static final String SEARCH_ITEM="Printed summer dress";
    @BeforeMethod(description = "valid user logs into the application")
    public void setUp(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("wabof52871@movfull.com","password");
    }

    @Test(description = "Verify if the logged in user is able to search for a product and correct search products are displayed",groups = {"smoke","sanity","smoke"})
    public void verifyProductSearchTest()
    {
        assertTrue(myAccountPage.searchForAProduct(SEARCH_ITEM).isSearchTermPresentInProductList(SEARCH_ITEM), "Content not found");

    }

}
