package com.netease.AcFunTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestXpath {
    WebDriver driver = new ChromeDriver();
    //一、根据xpath获取同一属性的元素，并循环取出数据
    @Test
    public  void byXpath(){
        driver.get("https://www.baidu.com");
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"u1\"]"));
        for (int i=0;i<list.size();i++ ){
            String text = list.get(i).getText();
            System.out.println(text);
        }
    }
    //二、截图百度首页
    @Test
    public void shotTest(){
        driver.get("https://www.baidu.com");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\lixx.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //三、alert弹出框
    @Test
    public void alertTest()throws  InterruptedException{
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    //四、confirm弹出框
    @Test
    public void confirmTest()throws  InterruptedException{
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        //driver控制权转交给alert
        Alert alert = driver.switchTo().alert();
        //点击取消
        alert.dismiss();
        Thread.sleep(3000);
        //点击确定
        alert.accept();
    }
    //五、prompt弹出框
    @Test
    public void promptTest()throws  InterruptedException{
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        //driver控制权转交给alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是Prompt");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        driver.quit();
    }
    //六、iframe测试
    @Test
    public void iframeTest()throws InterruptedException{
        driver.get("file:///C:/selenium_html/index.html");
        //通过ID或者name方式转交控制权
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        WebElement iframe2 = driver.findElement(By.id("2"));
        driver.switchTo().frame(iframe);
        driver.switchTo().frame(iframe2);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        //driver控制权转交给原来界面
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面"));
    }
    //七、下拉框的处理
    /**三种处理方式：
     * 1.selectByIndex()根据索引选取，从0开始
     * 2.selectByValue()根据属性value的属性值来选取
     *3.selectByVisibleText()根据标签之间的Text值，也就是页面显示的
     */
    @Test
    public void selectTest()throws InterruptedException{
        driver.get("file:///C:/selenium_html/index.html");
        WebElement selectEl =  driver.findElement(By.id("moreSelect"));
        //实例化Select类
        Select select = new Select(selectEl);
        //通过索引选择下拉框
        select.selectByIndex(2);
        Thread.sleep(3000);
        //通过属性Value值来选择下拉框
        select.selectByValue("huawei");
        Thread.sleep(3000);
        //通过文本值来选择下拉框
        select.selectByVisibleText("iphone");

    }
    //八、打开一个新窗口
    @Test
    public void testWin()throws InterruptedException{
        driver.get("file:///c:/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        //当前driver所在的页面的句柄值
        String handle1 = driver.getWindowHandle();
        for (String handles:driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }else {
                driver.switchTo().window(handles);
            }
        }
        driver.findElement(By.linkText("baidu")).click();
    }

    //九、等待
    @Test
    public void waitTest()throws InterruptedException{
        driver.get("file:///c:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //线程等待
        //Thread.sleep(5000);
        //全局等待
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //显示等待
        //WebDriverWait wait = new WebDriverWait(driver,10);
        //·wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display11\"]/div")));
        String text = driver.findElement(By.xpath("//*[@id=\"display11\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
    }




}
