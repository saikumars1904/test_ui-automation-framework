package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojos.AddressPojo;

import java.util.Locale;

public class FakeAddressUtility {

    public static AddressPojo getFakeAddress(){
        Faker faker = new Faker(Locale.US);
        AddressPojo addressPojo = new AddressPojo(faker.company().name(),faker.address().buildingNumber(),faker.address().streetAddress(),faker.address().city(),faker.address().zipCode(),faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),faker.gameOfThrones().quote(),faker.address().stateAbbr(),faker.address().state());
        return addressPojo;
    }
}
