package com.stu.testng01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    /**
     * 打开Chrome 浏览器，打开百度首页，等待5s,关闭浏览器
     */
    @Test
    public void getTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);

    }

    /**
     * 打开Chrome 浏览器，打开百度首页，等待5s,后退，等待3s关闭浏览器
     * @throws InterruptedException
     */
    @Test
    public void backTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
        //后退
        driver.navigate().back();
        Thread.sleep(3000);
    }

    /**
     * 打开Chrome 浏览器，打开百度首页，等待5s,后退，等待3s，前进，等待2s,关闭浏览器
     * @throws InterruptedException
     */
    @Test
    public void forwardTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
        //后退
        driver.navigate().back();
        Thread.sleep(3000);
        //前进
        driver.navigate().forward();

    }

    /**
     * 打开Chrome 浏览器，打开百度首页，等待5s,刷新，等待3s，关闭浏览器
     */
    @Test
    public void refreshTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
        //刷新
        driver.navigate().refresh();
        Thread.sleep(3000);

    }

    /**
     * 打开Chrome浏览器，设置窗口大小 500*500
     * 等待3s，最大化浏览器窗口，等待3s，关闭浏览器
     */
    @Test
    public void winTest() throws InterruptedException {
        //实例化Dimension 设置窗口大小
        Dimension dimension = new Dimension(500,500);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //窗口最大化
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    /**
     * 打开Chrome浏览器，打开百度首页
     * 获取当前页面的URL，获取当前页面Title，等待3s，校验当前页面URL是不是百度地址
     * 关闭浏览器
     */
    @Test
    public void getURLTitleTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        //获取当前页面的URL，
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println("获取到的URL是："+url+"获取的title："+title);
        Thread.sleep(3000);
        Assert.assertEquals(url,"https://www.baidu.com/");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
