package com.netease.AcFunTest;

import org.openqa.selenium.By;

/*
* page层
* 逻辑层 Login()发邮件（5个步骤）
* 业务层（我用xx账号xx密码登录，我的右键....）
* */
public class LoginPage {
    //定义email文本框的定位方式
    public static By emailInput = By.name("email");
    //定义密码输入框的定位方式
    public static By pwdInput = By.name("password");
    //定义登录按钮的定位方式
    public static By loginButton = By.name("dologin");
    //去注册
    public static By zhuceButton = By.name("changepage");


    public static By userNameTextBox;

    public static By pwdTexgtBox;

    public static By dologinButton;
}
