package com.selenium.class5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://demoqa.com/menu");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // move mouse to a element like main menu -> sub menu -> sub sub menu
        Actions action1=new Actions(driver);
        action1.moveToElement(driver.findElement(By.linkText("Main Item 2"))).build().perform();
        action1.moveToElement(driver.findElement(By.partialLinkText("SUB SUB LIST"))).build().perform();
        Thread.sleep(2000);
        action1.moveToElement(driver.findElement(By.linkText("Sub Sub Item 2"))).click().build().perform();
        Thread.sleep(2000);

        //test drag and drop
        driver.navigate().to("https://demoqa.com/droppable");
        Actions action2=new Actions(driver);
        WebElement srcElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));
        action2.dragAndDrop(srcElement,targetElement).build().perform();
        Thread.sleep(2000);

        //Right click
        driver.navigate().to("https://demoqa.com/buttons");
        Actions action3=new Actions(driver);
        action3.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();
        Thread.sleep(2000);

        //Double click
        Actions action4=new Actions(driver);
        action4.doubleClick(driver.findElement(By.id("doubleClickBtn"))).perform();
        Thread.sleep(2000);


        driver.quit();


    }
}
