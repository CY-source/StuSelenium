package com.stu.webdriver02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionTest02 {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开百度页面，在‘百度一下’按钮右键
     */
    @Test
    public void rightClickTest(){
        driver.get("https://www.baidu.com/");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化Actions这个类
        Actions actions = new Actions(driver);
        //在‘百度一下’右键
        actions.contextClick(buttonBaidu).perform();
    }

    /**
     * 打开百度页面，在‘百度一下’双击
     */
    @Test
    public void doubleClickTest(){
        driver.get("https://www.baidu.com/");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.doubleClick(buttonBaidu).build().perform();
    }

    /**
     * 打开测试页面，鼠标移动到action按钮，那么显示‘Hello World!’
     */
    @Test
    public void  moveTest() throws InterruptedException {
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        String hello = driver.findElement(By.xpath("//*[@id=\"over\"]/div")).getText(); // .//*[text()='Hello World!']
        Assert.assertEquals(hello,"Hello World!");

    }

    /**
     * 把元素拖动到（x,y）
     */
    @Test
    public void dropTest(){
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 把元素拖动到另一个元素上
     */
    @Test
    public void dropTest02() throws InterruptedException {
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/dragAndDrop.html");
        WebElement element1 = driver.findElement(By.id("drag"));
        WebElement element2 = driver.findElement(By.xpath("/html/body/h1"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        //鼠标选中→移动→释放→执行
        actions.clickAndHold(element1)
                .moveToElement(element2)
                .release()
                .perform();
        Thread.sleep(5000);
    }

    /**
     * 下拉框多选
     */
    @Test
    public void moreSelectTest() throws InterruptedException {
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .click(list.get(0))
                .click(list.get(2))
                .keyUp(Keys.SHIFT)
                .perform();
        //选中1、3 默认1选中
        //actions.keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.CONTROL);
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
