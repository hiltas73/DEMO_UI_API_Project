package com.demo.step_definitions;

import com.demo.pages.LoginPage;
import com.demo.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class getAllLinks_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    @When("user gets all the links from footer of the page")
    public void user_gets_all_the_links_from_footer_of_the_page() {
//        WebElement footer = Driver.getDriver().findElement(By.xpath("//footer[@id='footer']"));
//        int footerLinksSize = footer.findElements(By.tagName("a")).size();
//        System.out.println("footerLinksSize = " + footerLinksSize);
//        List<WebElement> footlinks = footer.findElements(By.tagName("a"));

        List<WebElement> footerLinks = loginPage.footerLinks;
        int num = 1;
        for (WebElement footlink : footerLinks) {
            System.out.println("footlink.getText() num = " + num + " - " + footlink.getText());
            num++;
        }
    }
    @Then("write footer links as a text file")
    public void write_footer_links_as_a_text_file() {

    }

}
