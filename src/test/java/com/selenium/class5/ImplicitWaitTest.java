package com.selenium.class5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ImplicitWaitTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Select elementSelect = new Select(driver.findElement(By.cssSelector("[name='country']")));
        Thread.sleep(1000);

        elementSelect.selectByVisibleText("AMERICAN SAMOA");
        Thread.sleep(1000);
        elementSelect.selectByIndex(9);
        Thread.sleep(1000);
        elementSelect.selectByValue("BOUVET ISLAND");
        Thread.sleep(1000);

        for(WebElement printAllOptions:elementSelect.getOptions()){
            System.out.println(printAllOptions.getTagName() + " " + printAllOptions.getAttribute("value") + " " + printAllOptions.getText());
        }

        driver.close();
    }
}
