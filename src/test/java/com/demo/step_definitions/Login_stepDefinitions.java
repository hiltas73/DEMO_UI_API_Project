package com.demo.step_definitions;

import com.demo.pages.LoginPage;
import com.demo.utilities.BrowserUtil;
import com.demo.utilities.Driver;
import io.cucumber.java.en.*;
import com.demo.utilities.ConfigurationReader;
import org.junit.Assert;

public class Login_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    @Given("user navigate to the url")
    public void user_navigate_to_the_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user enters google email")
    public void user_enters_google_email() {
        loginPage.login.click();
        loginPage.email.sendKeys(ConfigurationReader.getProperty("email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();

    }
    @Then("user should login to main page")
    public void user_should_login_to_main_page() {
        String actualPageTitle = Driver.getDriver().getTitle();
        System.out.println("actualPageTitle = " + actualPageTitle);
        Assert.assertEquals("Login test","n11 - 10 Üzerinden 11'lik Alışveriş Deneyimi",actualPageTitle);
    }

}
