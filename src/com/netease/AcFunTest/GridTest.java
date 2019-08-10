package com.netease.AcFunTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    public void test() throws MalformedURLException,InterruptedException {
//        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.105"));
//        driver.get("http://www.baidu.com");
//        Thread.sleep(10000);
//        driver.quit();
    }

    @DataProvider(name = "data4")
    public Object[][] test1() {
        return new Object[][]{
                {"firefox"},
                {"chrome"}};
    }
    @Test(dataProvider = "data4")
        public void testGrid2(String browser,String url) throws MalformedURLException,InterruptedException{
            DesiredCapabilities dc = null;
            if (browser == "firefox"){
                dc = DesiredCapabilities.firefox();
            }else if (browser == "chrome"){
                dc = DesiredCapabilities.chrome();
            }else{
                System.out.println("error");
            }
            WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
            driver.get("http://www.baidu.com");
            Thread.sleep(3000);
            driver.quit();
        }
    }
