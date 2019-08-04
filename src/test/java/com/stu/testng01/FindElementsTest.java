package com.stu.testng01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    /**
     * 打开百度首页，通过id定位搜索文本框
     */
    @Test
    public void byIdTest(){
        driver.get("https://www.baidu.com/");
        WebElement keyField = driver.findElement(By.id("kw")); }
    /**
     * 打开百度首页，通过name定位搜索文本框
     */
    @Test
    public void byNameTest(){
        driver.get("https://www.baidu.com/");
        WebElement keyField = driver.findElement(By.name("wd"));
    }
    /**
     * 打开百度首页，通过className定位搜索文本框
     */
    @Test
    public void byClassNameTest(){
        driver.get("https://www.baidu.com/");
        WebElement keyField = driver.findElement(By.className("mnav"));
    }
    /**
     * 打开百度首页，通过linkText定位搜索文本框
     */
    @Test
    public void byLinkTextTest(){
        driver.get("https://www.baidu.com/");
        WebElement keyField = driver.findElement(By.linkText("新闻"));
    }
    /**
     * 打开百度首页，通过partialLinkText定位搜索文本框
     */
    @Test
    public void bypartialLinkTextTest(){
        driver.get("https://www.baidu.com/");
        WebElement keyField = driver.findElement(By.partialLinkText("新"));
    }
    /**
     * 打开百度首页，通过tagName定位搜索文本框 （不常用）
     */
    @Test
    public void byTagNameTest(){
        driver.get("https://www.baidu.com/");
        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }
    /**
     * 打开百度首页，通过xpath 百度一下 按钮
     */
    @Test
    public void byXpathTest(){
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"su\"]"));
    }
    /**
     * 打开百度首页，通过cssSelector  百度图片
     */
    @Test
    public void bycssSelectorTest(){
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.cssSelector("#lg>img"));
    }
    /**
     * 打开百度首页，通过xpath 获取（新闻 hao123 地图 贴吧······）
     */
    @Test
    public void byXpathTest02(){
        driver.get("https://www.baidu.com/");
        List<WebElement> elementList = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i = 0;i < elementList.size();i++){
            String text = elementList.get(i).getText();
            System.out.println(text);
        }

    }

    @AfterMethod
    public void closedBrower(){
        driver.quit();
    }

}
