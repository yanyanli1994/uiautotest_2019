package com.netease.AcFunTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomjsTest {
    @Test
    public void pjsTest()throws InterruptedException{
        System.setProperty("phantomjs.binary.path","F:\\workspace\\Dagger-master\\res\\phantomjs.exe");
        WebDriver driver=new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(3000);
        String a = driver.getTitle();
        System.out.println(a);
        driver.quit();
    }
}
