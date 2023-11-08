package com.selenium.class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class LocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());

        //maximize the browser window
        driver.manage().window().maximize();

        //example of id locator, sendKeys use for send value to that locator
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1500);

        //example of class tag
        System.out.println(driver.findElement(By.className("login_logo")).getText());

        //example of name locator
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //css selector
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        Thread.sleep(1500);

        //Link Text
        driver.findElement(By.linkText("Sauce Labs Backpack")).click();
        Thread.sleep(1500);

        //back to previous page
        driver.navigate().back();

        //partial link text
        driver.findElement(By.partialLinkText("ke Li")).click();
        Thread.sleep(1500);

        //back to previous page
        driver.navigate().back();

        //locator tagname example, print all the link value of a particuler page
        List<WebElement> webElement = driver.findElements(By.tagName("a"));
        for(WebElement element:webElement){
            System.out.println(element.getText());
        }
        Thread.sleep(1500);
       //xpath example
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
//        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1500);

        driver.quit();

    }
}
