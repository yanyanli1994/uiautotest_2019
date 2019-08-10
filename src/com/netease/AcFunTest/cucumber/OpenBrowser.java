package com.netease.AcFunTest.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser extends StepsDemo{
    public static void openBrowser(String url){
        WebDriver driver = new ChromeDriver();

        System.setProperty("webdriver.chrome.driver","F:\\workspace\\Dagger-master\\res\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }
}
