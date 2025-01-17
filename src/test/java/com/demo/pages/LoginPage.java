package com.demo.pages;

import com.demo.utilities.BrowserUtil;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage{

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "loginButton")
    public WebElement loginBtn;

    @FindBy(xpath = "//div[@class='fMenu']//a")
    public List<WebElement> footerLinks;

    public void login(String email, String password){
        this.email.sendKeys(ConfigurationReader.getProperty("email"));
        this.password.sendKeys(ConfigurationReader.getProperty("password"));
        this.loginBtn.click();
    }

    public void navigateModule(String moduleName){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[@title='" + moduleName + "']"));
        BrowserUtil.clickWithJS(element);

    }

}
