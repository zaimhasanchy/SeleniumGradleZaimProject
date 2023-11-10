package com.selenium.class3.webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class WebElementTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        //this timeout applicable for every webelemnt
        //implicitlyWait(Duration.ofSeconds(30)):
        // This sets the implicit wait time for the WebDriver.
        // The implicit wait instructs the WebDriver to wait for a certain amount of time
        // when trying to locate an element if it is not immediately present.
        // In this case, the wait time is set to 30 seconds.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //clear and sendkeys example
        WebElement elementFullName=driver.findElement(By.id("userName"));
        elementFullName.sendKeys("Hasan");
        Thread.sleep(1500);
        elementFullName.clear();
        elementFullName.sendKeys("Zaim");
        Thread.sleep(1500);

        WebElement elementEmail=driver.findElement(By.id("userEmail"));
        elementEmail.clear();
        elementEmail.sendKeys("test@abc.com");
        Thread.sleep(1000);

        WebElement elementCurrentAddress=driver.findElement(By.id("currentAddress"));
        System.out.println("tag name of CurrentAddress field: "+elementCurrentAddress.getTagName());
        System.out.println("CurrentAddress text area height: "+elementCurrentAddress.getRect().height);
        System.out.println("CurrentAddress text area width: "+elementCurrentAddress.getRect().width);
        System.out.println("CurrentAddress text area position x value: "+elementCurrentAddress.getRect().x);
        System.out.println("CurrentAddress text area position y value: "+elementCurrentAddress.getRect().y);
        System.out.println("CurrentAddress text area css value for property font-family: "+elementCurrentAddress.getCssValue("font-family"));
        elementCurrentAddress.clear();
        elementCurrentAddress.sendKeys("Lalmatia, Muhammadpur");
        Thread.sleep(1000);

        WebElement elementPermanentAddress=driver.findElement(By.id("permanentAddress"));
        elementPermanentAddress.clear();
        elementPermanentAddress.sendKeys("Sutraput, Mymensingh");
//        Thread.sleep(1000);

        WebElement elementSubmit=driver.findElement(By.cssSelector("[id='submit']"));
        boolean isDisplayedSubmit=elementSubmit.isDisplayed();
        System.out.println("is submit displayed in dom:" + isDisplayedSubmit);
//        elementSubmit.click();
//        Thread.sleep(1500);

        //this will print all the links of this page
        //<a id="created" href="javascript:void(0)">Created</a>
        driver.navigate().to("https://demoqa.com/links");
        List<WebElement> elementLink=driver.findElements(By.tagName("a"));
        for(WebElement elementTagA:elementLink){
            System.out.println(elementTagA.getAttribute("href"));
        }


        //navigate to another page
        driver.navigate().to("https://demoqa.com/checkbox");

        // Locate the checkboxes using their XPath
        WebElement uncheckedCheckbox = driver.findElement(By.xpath("//svg[@class='rct-icon rct-icon-uncheck']"));
        WebElement checkedCheckbox = driver.findElement(By.xpath("//svg[@class='rct-icon rct-icon-check']"));

        // Validate whether the checkboxes are selected or not
        System.out.println("Unchecked checkbox isSelected: " + uncheckedCheckbox.isSelected());
        System.out.println("Checked checkbox isSelected: " + checkedCheckbox.isSelected());



        driver.quit();


    }
}
