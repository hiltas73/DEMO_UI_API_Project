package com.demo.pages;

import com.demo.utilities.BrowserUtil;
import com.demo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage{

    /**
     * This method will navigate user to the specific module in n11.com application.
     * For example: if tab is equals to Elektronik, and module equals to Bilgisayar,
     * Then method will navigate user to this page: https://www.n11.com/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module){
        //String moduleLocator = "//a[@title='" + moduleName + "']";
        //Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
        String tabLocator = "//a[@class='itemContainer' and contains(@title,'" + tab + "')]";
        String moduleLocator = "//a[@class='subCatMenuItem' and contains(@title,'" + module + "')]";

            //BrowserUtil.waitForClickablility((WebElement) By.xpath(tabLocator),3);
            WebElement tabElement = Driver.getDriver().findElement(By.xpath(tabLocator));
            new Actions(Driver.getDriver()).moveToElement(tabElement).build().perform();
            BrowserUtil.sleep(2);

            WebElement moduleElement = Driver.getDriver().findElement(By.xpath(moduleLocator));
            new Actions(Driver.getDriver()).moveToElement(moduleElement).click().build().perform();


//        try {
//            BrowserUtil.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
//            BrowserUtil.scrollToElement(Driver.getDriver().findElement(By.xpath(moduleLocator)));
//            Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
//            BrowserUtil.sleep(2);
//        } catch (Exception e) {
//            //BrowserUtil.waitForStaleElement(Driver.getDriver().findElement(By.xpath(moduleLocator)));
//            BrowserUtil.clickWithTimeOut(Driver.getDriver().findElement(By.xpath(moduleLocator)),  5);
//        }
    }

}
