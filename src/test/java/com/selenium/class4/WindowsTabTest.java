package com.selenium.class4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class WindowsTabTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //keep original window in a string and paas a enum(constraint)
        String originalWindow= driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/sample");
        Thread.sleep(2000);
        System.out.println("New Tab : "+driver.findElement(By.id("sampleHeading")).getText());
        driver.close();
        //back to main window
        driver.switchTo().window(originalWindow);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://demoqa.com/sample");
        Thread.sleep(2000);
        System.out.println("New window text : "+driver.findElement(By.id("sampleHeading")).getText());
        driver.close();
        driver.switchTo().window(originalWindow);
        Thread.sleep(2000);

        driver.quit();
//        System.out.println(driver.getTitle());




    }
}
