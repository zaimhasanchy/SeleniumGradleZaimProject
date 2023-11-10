package com.selenium.class3.webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NavigationTest {
    public static <Navigation> void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriver.Navigation navigation=driver.navigate();

        navigation.to("https://demoqa.com/links");
        Thread.sleep(1500);

        navigation.back();
        Thread.sleep(1500);

        navigation.forward();
        Thread.sleep(1500);

        navigation.refresh();

        driver.quit();

    }
}
