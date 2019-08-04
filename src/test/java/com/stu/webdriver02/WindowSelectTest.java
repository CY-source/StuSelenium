package com.stu.webdriver02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowSelectTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开测试页面，点击 Open new window，点击‘baidu’
     */
    @Test
    public void windowTest() throws InterruptedException {
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        //当前driver所在页面的 句柄值
        String handle1 = driver.getWindowHandle();
        // for 循环判断获取的handles是否等于handle1
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1))
                continue;
            //控制权转交window
            driver.switchTo().window(handles);
            driver.findElement(By.linkText("baidu")).click();
            driver.switchTo().window(handle1);
        }
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
