package com.selenium.class4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //javascript alert test
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        //confirmation alert test
        WebElement confirmationElement=driver.findElement(By.id("confirmButton"));
        confirmationElement.click();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        confirmationElement.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //Prompt alert check
        WebElement promptElement=driver.findElement(By.id("promtButton"));
        promptElement.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        promptElement.click();
        Thread.sleep(1000);

        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        promptElement.click();
        Thread.sleep(1000);

        driver.switchTo().alert().sendKeys("Input some text in prompt box");
        Thread.sleep(1000);
        System.out.println("Promt box text: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //quit browser
        driver.quit();


    }
}
