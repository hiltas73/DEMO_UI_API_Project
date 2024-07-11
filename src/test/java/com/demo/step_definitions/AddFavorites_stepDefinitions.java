package com.demo.step_definitions;

import com.demo.pages.LoginPage;
import com.demo.pages.MainPage;
import com.demo.pages.ParfumPage;
import com.demo.utilities.BrowserUtil;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddFavorites_stepDefinitions {

    LoginPage login = new LoginPage();
    MainPage mainPage = new MainPage();
    ParfumPage parfumPage = new ParfumPage();

    String productDetails = "";
    @Given("user login to the url")
    public void user_login_to_the_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        login.login.click();
        login.login(ConfigurationReader.getProperty("email"),ConfigurationReader.getProperty("password"));
    }
    @When("user navigate to {string} {string}")
    public void user_navigate_to(String tab, String module) {
        mainPage.navigateToModule(tab, module);
    }
    @When("user search for {string}")
    public void user_search_for(String productName) {
        parfumPage.searchProduct(productName);
    }
    @When("clicks on the item no {string}")
    public void clicks_on_the_item_no(String numberAsString) {
        parfumPage.selectProductByNumber(numberAsString);
        productDetails = parfumPage.productDetails.getText();
        System.out.println("productDetails = " + productDetails);
    }
    @When("add product to the favorites")
    public void add_product_to_the_favorites() {
        parfumPage.addFavoritesBtn.click();
        String expectedMessage = "Ürün favorilerinize eklenmiştir.";
        Assert.assertEquals("Add to favorites test",expectedMessage,parfumPage.alertMessage.getText());
    }
    @Then("verify the product in favorites is the same with the original product")
    public void verify_the_product_in_favorites_is_the_same_with_the_original_product() {
        //BrowserUtil.waitForVisibility(parfumPage.favorilerimBtn,10);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(parfumPage.alertMessage));
        parfumPage.favorilerimBtn.click();
        parfumPage.firstFavoriteItem.click();
        System.out.println("productDetails = " + productDetails);
        System.out.println("parfumPage.productDetails.getText() = " + parfumPage.productDetails.getText());
        Assert.assertEquals(productDetails,parfumPage.productDetails.getText());
    }


}
