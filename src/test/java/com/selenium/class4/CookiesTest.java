package com.selenium.class4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CookiesTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //get initial cookies size
        System.out.println("initial browser cookie size is: "+driver.manage().getCookies().size());

        //two new value add in cookie
        Cookie cookie= new Cookie("keyCookieTest1","value1 test for cookie");
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(new Cookie("keyCookieTest2","value2 test for cookie"));

        //after add 2 cookies count the size
        System.out.println("After add browser cookie size is: "+driver.manage().getCookies().size());

        //print all the cookies
        for (Cookie cookie1: driver.manage().getCookies()){
            System.out.println("key: "+cookie1.getName());
            System.out.println("Value: "+cookie1.getValue());
        }

        //delete specific cookie
        driver.manage().deleteCookieNamed("keyCookieTest2");

        //after remove  cookie keyCookieTest2 count the size
        System.out.println("After remove  cookie keyCookieTest2 size is: "+driver.manage().getCookies().size());

        //delete all cookies
        driver.manage().deleteAllCookies();

        //after remove  all cookies count the size
        System.out.println("After remove  all cookies size is: "+driver.manage().getCookies().size());

        //quit the browser
        driver.quit();


    }
}
