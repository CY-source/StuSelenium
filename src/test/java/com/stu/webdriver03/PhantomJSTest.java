package com.stu.webdriver03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomJSTest {
    @Test
    public void pjsTest() throws InterruptedException {
        //设置PhantomJS driver路径
        System.setProperty("phantomjs.binary.path","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\phantomjs.exe");
        //打开PhantomJS浏览器
        WebDriver driver = new PhantomJSDriver();
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("phantomJs");
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();

    }
}
