package com.netease.AcFunTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//163发邮件
public class SendEmail {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\Dagger-master\\res\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com");
        //密码登录
        driver.findElement(By.id("switchAccountLogin")).click();
    }
    @Test
    public void sendEmail(){
        LoginTest.login(driver,"meyoungtester","meyoung123");
        //点击写信按钮
        driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
        //定位收件人
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("992987194@qq.com");
        //定位主题文本框  并输入文本
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']"));
        //上传文件
        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]"));
        //定位iframe
        WebElement frame = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("/html/body")).sendKeys("测试下这个内容");
        //driver控制权转交回页面
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[text()='发送']")).click();
        Boolean bl = driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(bl);
    }
}
