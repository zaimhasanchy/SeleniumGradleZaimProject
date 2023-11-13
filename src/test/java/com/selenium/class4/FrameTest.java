package com.selenium.class4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FrameTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //print the text
        System.out.println("main Header text of frame page: "+driver.findElement(By.cssSelector("[class='main-header']")).getText());

        //switch to frame1
        driver.switchTo().frame("frame1");

        //print the text of frame1
        System.out.println("Frame1 text: "+driver.findElement(By.id("sampleHeading")).getText());

        //exit from the frame1
        driver.switchTo().defaultContent();

        //switch to frame2
        driver.switchTo().frame("frame2");

        //print the text of frame1
        System.out.println("Frame2 text: "+driver.findElement(By.id("sampleHeading")).getText());

        //exit from the frame2
        driver.switchTo().defaultContent();

        //exit driver
        driver.quit();



    }
}
