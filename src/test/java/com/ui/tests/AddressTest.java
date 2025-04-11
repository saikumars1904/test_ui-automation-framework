package com.ui.tests;

import com.ui.listeners.TestListeners;
import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPojo;
import com.utility.FakeAddressUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListeners.class})
public class AddressTest extends TestBase{
    private MyAccountPage myAccountPage;
    private AddressPojo addressPojo;
    @BeforeMethod(description = "valid first time user logs into the application")
    public void setUp(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("wabof52871@movfull.com","password");
        addressPojo = FakeAddressUtility.getFakeAddress();

    }
    @Test
    public void addNewFirstAddress(){
        String addressAlias = myAccountPage.goToAddressPage().saveAddress(addressPojo);
        Assert.assertEquals(addressAlias, addressPojo.getAddressAlias(), "Expected and actual alias are not matched");
    }

}
