package com.netease.AcFunTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//注册163邮箱
public class RegisterTest {
    WebDriver driver;
    String time = String.valueOf(System.currentTimeMillis()/100);
    @BeforeMethod
    public void testChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\Dagger-master\\res\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com");
    }
    @Test
    public void registest()throws  Exception{
        //点击注册账号按钮
        driver.findElement(By.xpath("//*[@id=\"appLoginTab\"]/div[3]/a[2]")).click();
        Thread.sleep(3000);
//        //控制权转交给iframe里面
//        driver.switchTo().frame("x-URS-iframe");
//        //点击去注册按钮
//        driver.findElement(By.id("changepage")).click();
        //获取当前driver所在的handle值
        String handle1 = driver.getWindowHandle();
        //driver切换到新的window页面
        for (String handles : driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles);
        }
        driver.findElement(By.id("nameIpt")).sendKeys("li"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("xin123123123");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("xin123123123");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        //短信验证码
        driver.findElement(By.id("vcodeIpt")).sendKeys("123123123");
        //点击注册协议
        driver.findElement(By.id("mainAcceptIpt")).click();
        //点击立即注册按钮
        driver.findElement(By.id("mainRegA")).click();
        Thread.sleep(3000);
        String error = driver.findElement(By.id("m_vcode")).getText();
        Thread.sleep(3000);
        Assert.assertEquals(error,"  验证码不正确，请重新填写");
    }
    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
