package com.demo.pages;

import com.demo.utilities.BrowserUtil;
import com.demo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage{

    public void navigateToModule(String moduleName){
        String moduleLocator = "//a[@title='" + moduleName + "']";
        Driver.getDriver().findElement(By.xpath(moduleLocator)).click();

    }

}
