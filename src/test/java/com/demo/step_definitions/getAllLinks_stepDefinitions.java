package com.demo.step_definitions;

import com.demo.pages.LoginPage;
import com.demo.utilities.BrowserUtil;
import com.demo.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class getAllLinks_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    List<WebElement> footerLinks;
    @When("user gets all the links from footer of the page")
    public void user_gets_all_the_links_from_footer_of_the_page() {
//        WebElement footer = Driver.getDriver().findElement(By.xpath("//footer[@id='footer']"));
//        int footerLinksSize = footer.findElements(By.tagName("a")).size();
//        System.out.println("footerLinksSize = " + footerLinksSize);
//        List<WebElement> footlinks = footer.findElements(By.tagName("a"));

        footerLinks = loginPage.footerLinks;
        int num = 1;
        for (WebElement footlink : footerLinks) {
            System.out.println("footlink.getText() num = " + num + " - " + footlink.getText());
            num++;
        }
    }
    @Then("write footer links as a text file")
    public void write_footer_links_as_a_text_file() throws IOException {
        // Create file in project
        String textFile = "C:\\Users\\LENOVO\\IdeaProjects\\DEMO_UI_API_Project\\links.txt";
        // Create objct of java file class
        File file = new File(textFile);
        // Create file
        file.createNewFile();

        // Write in to file
        // Create object of FileWriter and BufferWriter class
        FileWriter fw = new FileWriter(textFile);
        BufferedWriter bw = new BufferedWriter(fw);
        //bw.write("This is the First line...");
        for (WebElement footerLink : footerLinks) {
            bw.write(footerLink.getText());
            bw.newLine();
        }
        bw.close();

    }
    @And("click on {string} at the footer")
    public void clickOnAtTheFooter(String moduleName) {
        loginPage.navigateModule(moduleName);
    }

    @Then("verify footer links with the text file")
    public void verify_footer_links_with_the_text_file() {

    }


}
