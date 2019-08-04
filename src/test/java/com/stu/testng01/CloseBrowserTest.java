package com.stu.testng01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseBrowserTest {
    @Test
    public void closedChrome() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        //实例化ChromeDriver(
        WebDriver driver = new ChromeDriver();
        //线程等待5s
        Thread.sleep(5000);
        //关闭当前窗口 系统进程未关闭，占用资源
        driver.close();
    }
    @Test
    public void closedChrome01() {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        //实例化ChromeDriver(
        WebDriver driver = new ChromeDriver();
        //线程等待 5s
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭所有窗口并退出 系统进程即关闭，释放资源
        driver.quit();
    }
}


