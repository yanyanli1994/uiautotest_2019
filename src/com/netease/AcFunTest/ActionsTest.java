package com.netease.AcFunTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest {
    WebDriver driver = new ChromeDriver();
    @Test
    public void clickTest() throws  InterruptedException{
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        //定位新闻链接
        WebElement newlink = driver.findElement(By.name("tj_trnews"));
        //点击新闻链接
        newlink.click();
        //获取当前页面的URL
        String url = driver.getCurrentUrl();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

}
