package ru.stqa.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
    }

    @Test
    public void myFirstTest() {
        driver.get("https://www.google.com/");
        //driver.findElement(By.id("gs_ok2")).click();
        //driver.findElement(By.id("K32")).click();
        //driver.findElement(By.id("gs_ok2")).click();
        //driver.findElement(By.id("K32")).click();
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
        wait.until(titleIs("webdriver - ����� � Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
