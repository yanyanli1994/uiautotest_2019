package com.netease.AcFunTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void testChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\Dagger-master\\res\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com");
        //密码登录
        driver.findElement(By.id("switchAccountLogin")).click();
    }
    //正确账号登录
    @Test
    public void loginSuccess()throws Exception{
        Thread.sleep(3000);
        String logout = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");
    }
    //错误账号登录
    @Test
    public void loginError()throws Exception {
        LoginTest.login(driver, "meyoungtester", "meyoung1231111");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        String error = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error, "账号或密码错误");
    }


    public static void login(WebDriver driver,String email,String pwd){
        driver.switchTo().frame(0);
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        driver.findElement(LoginPage.loginButton).click();
    }
    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
