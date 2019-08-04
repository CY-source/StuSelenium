package com.stu.webdriver03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendEmailTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }

    /**
     *4.完成带附件的发送邮件
     */
    @Test
    public void sendEmail(){
        //调用封装的登录方法
        LoginTest.login(driver,"meyoungtester","meyoung123");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")));

        //点击‘写信’按钮
        driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
        driver.findElement(By.className("js-component-emailtips nui-ipt-placeholder"))
                .sendKeys("meyoungtester@163.com");
        //定位‘主题’文本框，并输入文本
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input"))
                .sendKeys("这个主题");
        //上传文件
        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input"))
                .sendKeys("C:\\Users\\Administrator\\Desktop\\笔记图\\程序猿.jpg");
        //定位iframe
        WebElement frame = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("/html/body")).sendKeys("这是文本内容");
        //driver控制权转交回页面
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='发送']")).click();
        //校验
        boolean b = driver.findElement(By.xpath("//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(b);

    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
