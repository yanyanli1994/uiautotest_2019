package com.netease.demo;

import com.netease.datadriver.CSVDataProvider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login51Testing {
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        CSVDataProvider.get51Testing(); //调用打开软件测试论坛首页的方法
    }

    @Test(dataProvider = "login")   //登录的测试用例
    public void login(String username, String password, String example, String response) throws InterruptedException {
        CSVDataProvider.driver.findElement(By.xpath(".//*[@id='ls_username']")).sendKeys(username);
        //输入用户名
        CSVDataProvider.driver.findElement(By.xpath(".//*[@id='ls_password']")).sendKeys(password);
        //输入密码
        CSVDataProvider.driver.findElement(By.xpath(".//*[@id='lsform']/div/div[1]/table/tbody/tr[2]/td[3]/button")).click();
        //点击登录
        Thread.sleep(2000);

        Assert.assertTrue(CSVDataProvider.driver.getPageSource().contains(response));
        //断言
        Reporter.log(example);
        //打印日志
    }

    @AfterMethod
    public void afterMethod() {
        CSVDataProvider.driver.quit();
    }

    @DataProvider(name = "login")   //文件名
    public Object[][] dp() throws IOException {
        String path = "data/" + this.getClass().getSimpleName()+ ".csv";
//        return CSVDataProvider.readCSV("F:\\workspace\\Dagger-master\\data\\login.csv");    //文件的路径
        return CSVDataProvider.readCSV(path);    //文件的路径

    }
}
