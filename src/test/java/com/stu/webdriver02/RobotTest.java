package com.stu.webdriver02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class RobotTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IDEAProjects\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 键盘操作
     */
    @Test
    public void saveHtml() throws AWTException, InterruptedException {
        driver.get("https://www.baidu.com/");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        int keyS = (int) new Character('S');
        System.out.println(keyS);

        //robot.keyPress(KeyEvent.VK_S);
        //robot.keyPress(keyS);
        robot.keyPress(83);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        //释放按键
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    /**
     * 上传文件处理
     */
    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("file:///F:/IDEAProjects/Selenium_Demo01/selenium_html/index.html");
        driver.findElement(By.id("load"))
                .sendKeys("C:\\Users\\Administrator\\Desktop\\笔记图\\程序猿.jpg");
        Thread.sleep(5000);
    }

    /**
     * 下载文件处理
     */
    @Test
    public void testFirefoxDown(){
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        //设置火狐默认下载文件夹，0表示桌面 1表示我的下载 2表示自定义下载
        firefoxProfile.setPreference("browser.download.folderList","2");
        //设置自定义文件夹位置
        firefoxProfile.setPreference("browser.download.dir","F:\\IDEAProjects\\screenshot");
        //设置无需确认下载的文件格式
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/octet-stream,application/vnd.ms-excel,text/csv,application/zip,application/exe");
        FirefoxDriver driver = new FirefoxDriver(firefoxProfile);
        driver.get("https://notepad-plus.en.softonic.com/download");
        driver.findElement(By.xpath("//*[@id=\"js-app-download-info\"]/div[2]/a/strong")).click();

        driver.quit();
    }

    @Test
    public void chromeDownTest(){
        String downloadFilepath = "F:\\IDEAProjects\\screenshot";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups",0);
        chromePrefs.put("download.default_directory",downloadFilepath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",chromePrefs);

        System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

    }

    @AfterMethod
    public void closed(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
