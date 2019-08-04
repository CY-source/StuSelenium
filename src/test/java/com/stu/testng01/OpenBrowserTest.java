package com.stu.testng01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {
    //1.启动Firefox
    @Test
    public void openFirefox(){
        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public void openFirefox02(){
        //指定firefox.exe路径
        System.setProperty("webdriver.firefox.bin","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();

    }
    @Test
    public void openFirefox03(){
        System.setProperty("webdriver.geckodriver.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
    }

    //2.启动Chrome
    @Test
    public void openChrome(){
        //指定chrome.exe路径
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

    }
    //3.启动IE
    @Test
    public void openIE(){
        System.setProperty("webdriver.ie.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();

    }
    //4.启动Edge
    @Test
    public void oprnEdge(){
        System.setProperty("webdriver.edge.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\MicrosoftWebDriver.exe");
        WebDriver webDriver = new EdgeDriver();

    }

}
