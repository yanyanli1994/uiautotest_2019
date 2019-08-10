package com.netease.AcFunTest.cucumber;

import cucumber.api.java.zh_cn.并且;
import cucumber.api.java.zh_cn.当;

public class Steps {
    @当("^我打开163网站$")
    public void openURL(){
        System.out.println("我打开163网站");
    }
    @并且("^我在email文本框输入\"(.*?)\"$")
    public void sendkeyEmail(String email){
        System.out.println("我输入了email"+email);
    }
    @并且("^我在密码框输入\"(.*?)\"$")
    public void sendkeyPWD(String pwd){
        System.out.println("我输入了密码"+pwd);
    }
    @并且("^我点击登录按钮$")
    public void clickLogin(){
        System.out.println("点击登录按钮");
    }
    @并且("^我登录成功$")
    public void assertTest(){
        System.out.println("登录成功");
    }
}
