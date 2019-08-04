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

public class RegisterTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }

    /**
     * 1.完成163邮箱的注册
     */
    @Test
    public void registTest(){
        //点击‘密码登录’
        driver.findElement(By.id("switchAccountLogin")).click();
        //driver控制权转交给iframe
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        //点击注册按钮
        driver.findElement(By.id("changepage")).click();
        //获取当前driver所在的handle值
        String handle1 = driver.getWindowHandle();
        //driver 切换到新的window页面
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
        //时间戳
        String time = String.valueOf(System.currentTimeMillis()/100);

        driver.findElement(By.id("nameIpt")).sendKeys("emain"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("123456");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123456");
        driver.findElement(By.id("vcodeIpt")).sendKeys("123123");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("123123");
        driver.findElement(By.id("mainRegA")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_vcode\"]/span")));

        String errorText=driver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
        Assert.assertEquals(errorText,"  手机验证码不正确，请重新填写");

    }

    @Test
    public void testcase01(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @AfterMethod
    public void closed(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
