package com.netease.AcFunTest.cucumber;

import com.netease.AcFunTest.LoginPage;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.并且;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Step1 {
    WebDriver driver = new ChromeDriver();
    @假如("^我已经打开\"(.*?)\"网站$")
    public void 我已经打开_网站(String url){
        OpenBrowser.openBrowser(url);
    }
    @当("^我用账号\"(.*?)\",密码\"(.*?)\"作为登录账号$")
    public void loginSteps(String userName,String pwd){
        Login.login(userName,pwd);
    }
    @当("^我点击登录按钮$")
    public void clickLoginButton(){
       driver.findElement(LoginPage.dologinButton).click();
    }
    @那么("^我登录成功$")
    public void loginSuccess(){
       Login.success();
    }
}
