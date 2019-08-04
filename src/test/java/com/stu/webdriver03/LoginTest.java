package com.stu.webdriver03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }

    /**
     * 2.完成正确账号的登录
     */
    @Test
    public void loginSuccess(){
        //调用封装的登录方法
        LoginTest.login(driver,"meyoungtester","meyoung123");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));

        String logout = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");

    }

    /**
     * 3.完成错误账号的登录
     */
    @Test
    public void loginError(){
        //调用封装的登录方法
        LoginTest.login(driver,"meyoungtester","meyoung12311");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));

        String error = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error,"请先进行验证");

    }

    /**
     * 封装登录方法
     */
    public static void login(WebDriver driver,String email,String pwd){
        //点击‘密码登录’
        driver.findElement(By.id("switchAccountLogin")).click();
        //driver控制权转交给iframe
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();

    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }

}
