package com.netease.AcFunTest.cucumber;

import com.netease.AcFunTest.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login extends StepsDemo{
    public static void login(String userName,String pwd){
        WebDriver driver = new ChromeDriver();
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(LoginPage.userNameTextBox).sendKeys(userName);
        driver.findElement(LoginPage.pwdTexgtBox).sendKeys(pwd);
    }

    public static void success() {
    }
}
