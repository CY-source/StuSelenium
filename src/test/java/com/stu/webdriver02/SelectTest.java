package com.stu.webdriver02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     *1.打开测试页面，Select下拉列表框，（1）选择vivo （2）选择huawei (3)选择iPhone
     */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/index.html");
        WebElement selectEl = driver.findElement(By.id("moreSelect"));
        //实例化select类
        Select select = new Select(selectEl);
        //通过 索引 选择下拉框
        select.selectByIndex(2);
        Thread.sleep(3000);
        //通过 属性value值 选择下拉框
        select.selectByValue("huawei");
        Thread.sleep(3000);
        //通过 文本值  选择下拉框
        select.selectByVisibleText("iphone");

    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
