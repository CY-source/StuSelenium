package com.stu.webdriver03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //创建一个 DesiredCapabilities类型
        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        //实例化一个driver
        //WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.101:4446/wd/hub"),chrome);
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.101:5555/wd/hub"),chrome);

        driver.get("https://www.baidu.com/");
        Thread.sleep(5000);
        driver.quit();
    }

    //数据驱动
    @DataProvider(name="data1")
    public Object[][] test1(){
        return new Object[][]{
                {"internet explorer"},{"chrome"}
        };
    }
    @Test(dataProvider = "data1")
    public void testGrid2(String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if (browser.contentEquals("internet explorer")) {
            dc = DesiredCapabilities.internetExplorer();
        }else if (browser.contentEquals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else {
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.101:4446/wd/hub"),dc);

        driver.get("https://www.baidu.com/");
        Thread.sleep(5000);
        driver.quit();

    }

}
