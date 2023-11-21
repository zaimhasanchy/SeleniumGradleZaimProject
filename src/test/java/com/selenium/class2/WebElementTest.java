package com.selenium.class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WebElementTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
//        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_PROFILE,"/dev/null");

        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.findElement(By.className("login_logo")).getText());
        //output: Swag Labs

        //navigate from onpage to another site
        driver.navigate().to("https://parabank.parasoft.com/");

        //print how many anchor tage in this page
        System.out.println(driver.findElements(By.tagName("a")).size());
        Thread.sleep(2000);

        driver.quit();
    }
}
