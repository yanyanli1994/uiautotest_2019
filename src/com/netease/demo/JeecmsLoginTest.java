package com.netease.demo;

import com.netease.datadriver.CSVDataProvider;
import com.netease.utils.BrowserEmulator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
/*
jeecms登录页面，csv参数化
 */
public class JeecmsLoginTest {
    BrowserEmulator browserEmulator;

    @BeforeClass
    public void setUp() throws Exception {
        browserEmulator = new BrowserEmulator();

    }
    @Test(dataProvider = "dp" )
    public void search(String description,String username,String pasword,String response)throws Exception {
        //打开jeecms首页
        browserEmulator.open("http://demo.jeecms.com/jeeadmin/jeecms/index.do#/login");
        //输入用户名
        browserEmulator.type("//*[@id='app']/div/div[1]/div/div[1]/input",username);
        //输入密码
        browserEmulator.type("//*[@id=\"app\"]/div/div[1]/div/div[2]/input",pasword);
        //点击登录
        browserEmulator.click("//*[@id=\"login\"]");
        Thread.sleep(2000);
        Assert.assertTrue(browserEmulator.getBrowserCore().getPageSource().contains("jeecms演示站"),"登录失败");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        browserEmulator.quit();
    }

    @DataProvider(name = "login")   //文件名
    public Object[][] dp() throws IOException {
        String path = "data/" + this.getClass().getSimpleName()+ ".csv";
        return CSVDataProvider.readCSV(path);    //文件的路径
    }
}
