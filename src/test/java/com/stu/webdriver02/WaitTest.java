package com.stu.webdriver02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * 打开测试页面，点击wait按钮，获取文本，并判断是否为“wait for display”
     */
    @Test
    public void waitTest(){
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");

    }

    @Test
    public void waitTest02(){
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));

        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
