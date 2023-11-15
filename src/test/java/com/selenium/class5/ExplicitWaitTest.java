package com.selenium.class5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaitTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());

        //maximize the browser window
        driver.manage().window().maximize();

        //Explicit wait declare
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //example of id locator, sendKeys use for send value to that locator
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user-name")))).sendKeys("standard_user");
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1500);

        //example of class tag
        System.out.println(driver.findElement(By.className("login_logo")).getText());

        //example of name locator
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //css selector
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[data-test='login-button']")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[data-test='login-button']"))));
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));
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
