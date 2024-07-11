package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ParfumPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder='Sonuçlarda Ara']")
    public WebElement searchBoxProduct;

    @FindBy(xpath = "//ul[@id='listingUl']/li")
    public List<WebElement> searchProductList;

    @FindBy(xpath = "//h2[@class='sub-title']")
    public WebElement productDetails;

    @FindBy(id = "addToFavouriteWishListBtn")
    public WebElement addFavoritesBtn;

    @FindBy(xpath = "//div[@class='toaster-info']")
    public WebElement alertMessage;

    @FindBy(xpath = "//a[@title='Favorilerim']")
    public WebElement favorilerimBtn;

    @FindBy(xpath = "//div[@id='favouriteList']/ul/li[1]")
    public WebElement firstFavoriteItem;

    public void searchProduct(String productName){
        searchBoxProduct.sendKeys(productName+ Keys.ENTER);
    }

    public void selectProductByNumber(String number){
        int searchNumber = Integer.parseInt(number);
        int productNumber = searchNumber - 1;
        searchProductList.get(productNumber).click();
    }

}
