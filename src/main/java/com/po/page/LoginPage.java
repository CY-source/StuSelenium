package com.po.page;

import org.openqa.selenium.By;

public class LoginPage {
    ////点击‘密码登录’的定位方式
    public static By pwdlogin = By.id("switchAccountLogin");
    //定义email 文本框的定位方式
    public static By emailInput = By.name("email");
    //定义密码输入框的定位方式
    public static By pwdInput = By.name("password");
    //定义 登录 按钮的定位方式
    public static By loginButton = By.id("dologin");
    //注册新账号
    public static By register = By.id("changepage");

}
