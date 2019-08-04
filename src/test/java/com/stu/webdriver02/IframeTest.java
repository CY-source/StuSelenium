package com.stu.webdriver02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 1. 定位iFrame 2. driver控制权交给iFrame
     * 3. 操作iFrame里面的元素 4. driver控制权交回原页面
     */
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/index.html");
        //通过id或者name方式 转交控制权
        //driver.switchTo().frame("aa");
        //通过webelement 方式
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        //把控制权转交给frame
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        //把driver控制权交给原来界面
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();

    }


    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
