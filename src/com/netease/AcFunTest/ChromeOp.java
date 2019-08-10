package com.netease.AcFunTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ChromeOp {
    @Test
    public void test1(){
        String downloadFilepath = "D:\\";
        HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.groups",0);
        chromePrefs.put("download.default_directory",downloadFilepath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOptions("prefs",chromePrefs);
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
//        cap.setCapability(ChromeOptions.CAPABILITY,options);
        System.setProperty("webdriver.chrome.driver",".//res//chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.firefox.com.cn/");
        driver.findElement(By.xpath("//*[@id=\"nav-download-firefox\"]/ul/li[3]/a/strong")).click();
    }
}
