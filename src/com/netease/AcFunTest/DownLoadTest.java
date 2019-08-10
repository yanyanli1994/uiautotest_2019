package com.netease.AcFunTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DownLoadTest {
    @Test
    public void testFirefoxDown()  throws  InterruptedException, AWTException {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        //设置火狐的默认下载文件夹，0表示桌面  1表示我的下载   2表示自定义文件夹
        firefoxProfile.setPreference("browser.download.folderList","2");
        //设置自定义文件夹位置
        firefoxProfile.setPreference("browser.download.dir","D:\\soft");
        //设置无需确认下载的文件格式
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream,application/vnd.ms-excel,text/csv,application/zip");
        //打开一个预先配置的火狐
        WebDriver driver = new FirefoxDriver(firefoxProfile);
//        driver.get("http://rj.baidu.com/soft/detail/13478.html?ald");
        driver.get("http://www.firefox.com.cn/");
        driver.findElement(By.xpath("//*[@id=\"nav-download-firefox\"]/ul/li[3]/a")).click();
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
//        driver.findElement(By.xpath(".//*[@id='softAbs']/a[2]")).click();
    }
}
