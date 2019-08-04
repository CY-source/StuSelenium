package com.stu.webdriver03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 执行JS
     */
    @Test
    public void JSTest(){
        driver.get("https://www.baidu.com/");
        //把driver转成JavascriptExecutor 类型
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //持续JS代码
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")");

    }

    @AfterMethod
    public void closed(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
