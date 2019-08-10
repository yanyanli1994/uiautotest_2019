package com.netease.reacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class SelectTest {
    public static void main(String[] args) throws InterruptedException  {
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\Dagger-master\\res\\chromedriver.exe");//chromedriver服务地址
        WebDriver driver =new ChromeDriver();
        driver.get("https://012x.ant.design/components/select/");//打开指定的网站
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"components-select-demo-basic\"]/div/span[1]/span/span[1]")).click();//找到下拉元素
        sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"components-select-demo-basic\"]/div/span[1]/span/span[1]")).sendKeys(Keys.UP);
        sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"components-select-demo-basic\"]/div/span[1]/span/span[1]")).sendKeys(Keys.ENTER);
        sleep(3000);
        try {
            /**
             * WebDriver自带了一个智能等待的方法。
             dr.manage().timeouts().implicitlyWait(arg0, arg1）；
             Arg0：等待的时间长度，int 类型 ；
             Arg1：等待时间的单位 TimeUnit.SECONDS 一般用秒作为单位。
             */
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * dr.quit()和dr.close()都可以退出浏览器,简单的说一下两者的区别：第一个close，
         * 如果打开了多个页面是关不干净的，它只关闭当前的一个页面。第二个quit，
         * 是退出了所有Webdriver所有的窗口，退的非常干净，所以推荐使用quit最为一个case退出的方法。
         */
        driver.quit();//退出浏览器
    }
}
