package com.testng.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodTest extends BaseMethodTest{
    @Test(priority = 0, description = "Execute first")
    public void verifySaucedemoSitesTile1(){
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 3, timeOut = 4) //// Timeout set to 4 milliseconds
    public void verifySaucedemoSitesTile2(){
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 1, description = "execute 2nd")
    public void verifySaucedemoSitesTile3(){
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 2, description = "login with valid credential")
    public void loginTestWithValidAccount(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
}
