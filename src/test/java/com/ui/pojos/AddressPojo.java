package com.ui.pojos;

public class AddressPojo
{
    private String company;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postCode;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String otherInformation;
    private String addressAlias;
    private String state;


    public AddressPojo(String company, String addressLine1, String addressLine2, String city, String postCode, String homePhoneNumber, String mobilePhoneNumber, String otherInformation, String addressAlias, String state) {
        this.company = company;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postCode = postCode;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.otherInformation = otherInformation;
        this.addressAlias = addressAlias;
        this.state = state;
    }

    public String getCompany() {
        return company;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public String getState() {
        return state;
    }
}
