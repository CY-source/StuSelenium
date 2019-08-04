package com.stu.webdriver03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }

    //数据驱动
    @DataProvider(name="data")
    public Object[][] data(){
        return new Object[][]{
                {"user1","123456"},
                {"user2","456789"}
        };
    }
    //完成多个用户账号的登录
    @Test(dataProvider = "data")
    public void loginInTest(String username,String pwd){
        //调用封装的登录方法
        DataDriverTest.loginIn(driver,username,pwd);
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        String error = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error,"请先进行验证");

    }

    /**
     * 封装登录方法
     */
    public static void loginIn(WebDriver driver,String username,String pwd){
        //点击‘密码登录’
        driver.findElement(By.id("switchAccountLogin")).click();
        //driver控制权转交给iframe
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();

    }

    @AfterMethod
    public void closed(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
