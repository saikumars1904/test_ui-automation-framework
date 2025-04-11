package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtility {
    private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.cssSelector("span.lighter");
    private static final By ALL_PRODUCT_LISTS_NAME = By.xpath("//h5[@itemprop='name']/a");
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultTitle()
    {
        return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm){
        List<String> keyWords = Arrays.asList(searchTerm.toLowerCase().split(" "));
        List<String> productNameList = getAllVisibleText(ALL_PRODUCT_LISTS_NAME);
        boolean result = productNameList.stream().anyMatch(name ->(keyWords.stream().anyMatch(name.toLowerCase()::contains)));
        return result;
    }

    public ProductDetailPage clickOnTheProductAtIndex(int index)
    {
        clickOn(getAllElements(ALL_PRODUCT_LISTS_NAME).get(index));
        ProductDetailPage productDetailPage =new ProductDetailPage(getDriver());
        return productDetailPage;

    }
}
