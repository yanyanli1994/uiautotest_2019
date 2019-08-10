package com.netease.AcFunTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class TestActions {
    WebDriver driver = new ChromeDriver();
    //一、右键
    @Test
    public void rightClickTest(){
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化actions
        Actions actions = new Actions(driver);
        //在百度一下按钮  右键
        actions.contextClick(buttonBaidu).perform();
    }

    //二、双击
    @Test
    public void doubleClickTest()throws InterruptedException{
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        Thread.sleep(3000);
        //实例化actions
        Actions actions = new Actions(driver);
        actions.doubleClick(buttonBaidu).perform();
    }

    //三、移动
    @Test
    public void move()throws InterruptedException{
        driver.get("file:///c:/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        String hello = driver.findElement(By.xpath(".//*[text()='Hello World']")).getText();
        Assert.assertEquals(hello,"Hello World");
    }
    //四、拖拽:拖拽到指定位置
    @Test
    public void testDrop(){
        driver.get("file:///c:/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
    }
    //五、拖拽:把元素el1拖拽到el2
    @Test
    public void dropTest()throws InterruptedException{
        driver.get("file:///c:/selenium_html/dragAndDrop.html");
        WebElement el1 = driver.findElement(By.id("drag"));
        WebElement el2 = driver.findElement(By.xpath("/html/body/h1"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(el1).moveToElement(el2).release(el1).perform();
        Thread.sleep(5000);
    }
    //六、多选   选中从0-2的下拉数据
    @Test
    public void moreSelectTest()throws InterruptedException{
        driver.get("file:///c:/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEquals"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEquals\"]"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);
    }

    //七、保存html
    @Test
    public void saveHtml() throws AWTException,InterruptedException {
        driver.get("http://www.baidu.com");
        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_S);
//        Thread.sleep(5000);
//        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        int keyS = (int)new Character('A');
        System.out.println(keyS);
        robot.keyPress(keyS);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    //八、上传
    @Test
    public void uploadTest() throws AWTException,InterruptedException {
        driver.get("file:///c:/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\Administrator\\Pictures\\test.png");
        Thread.sleep(5000);
        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_S);
//        Thread.sleep(5000);
//        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        int keyS = (int)new Character('A');
        System.out.println(keyS);
        robot.keyPress(keyS);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }



}
