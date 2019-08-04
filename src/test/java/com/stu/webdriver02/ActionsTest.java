package com.stu.webdriver02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    /**
     * 打开百度首页，点击新闻链接，并验证
     */
    @Test
    public void clickTest(){
        driver.get("https://www.baidu.com/");
        //定位新闻链接
        WebElement newslink = driver.findElement(By.name("tj_trnews"));
        //点击新闻链接
        newslink.click();
        //获取当前页面的URL
        String url = driver.getCurrentUrl();
        //校验当前页面的URL
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    /**
     * 打开百度首页，输入关键字selenium，点击’百度一下‘进行搜索
     * 校验title是否等于“selenium_百度搜索”
     */
    @Test
    public void sendkeysTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //定位百度搜索框
        WebElement keys = driver.findElement(By.id("kw"));
        //搜索框输入 selenium
        keys.sendKeys("selenium");
        //定位‘百度一下’按钮
        WebElement baiduButton = driver.findElement(By.id("su"));
        //点击
        baiduButton.click();
        Thread.sleep(3000);
        //获取页面title
        String title = driver.getTitle();
        //校验
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    /**
     * 打开百度首页，输入关键字selenium，清空文本框
     */
    @Test
    public void clearTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //定位百度搜索框
        WebElement keys = driver.findElement(By.id("kw"));
        //搜索框输入 selenium
        keys.sendKeys("selenium");
        Thread.sleep(3000);
        //清空文本框
        keys.clear();
        Thread.sleep(3000);
    }

    /**
     *打开百度首页，获取’新闻‘文本，并校验
     */
    @Test
    public void getTextTest(){
        driver.get("https://www.baidu.com/");
        //定位百度搜索框
        WebElement keys = driver.findElement(By.id("kw"));
        String text = driver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(text,"新闻");
    }

    /**
     * 打开百度首页，获取文本框的tagName，校验是否是input
     */
    @Test
    public void getTagNameTest(){
        driver.get("https://www.baidu.com/");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");
    }

    /**
     * 打开百度页面,判断‘百度一下’按钮的属性值是否为‘百度一下’
     */
    @Test
    public void getAttributeTest(){
        driver.get("https://www.baidu.com/");
        String attribute = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attribute,"百度一下");
    }

    /**
     * 打开百度首页，判断是否显示‘百度一下’按钮
     */
    @Test
    public void isDisPlayedTest(){
        driver.get("https://www.baidu.com/");
        boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }

    /**
     * 打开测试页面，判断Volvo单选框被选中
     */
    @Test
    public void isSelectedTest(){
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        element.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    /**
     * 打开测试页面，判断sumbit 按钮处于未激活状态
     */
    @Test
    public void isEnableTest(){
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/index.html");
        boolean b = driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);
    }

    /**
     * 打开百度页面，截图百度首页（常用于自动化case执行失败后 页面的处理）
     */
    @Test
    public void shotTest(){
        driver.get("https://www.baidu.com/");
        driver.manage().window().maximize();
        File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("F:/IDEAProjects/screenshot/test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
