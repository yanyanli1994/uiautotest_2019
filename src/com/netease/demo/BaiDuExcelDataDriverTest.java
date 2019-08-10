package com.netease.demo;

import com.netease.utils.BrowserEmulator;
import com.netease.datadriver.ExcelDataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

/**
 * 百度页面excel文件读取
 * @author lixx
 *
 */
public class BaiDuExcelDataDriverTest {

    BrowserEmulator browserEmulator;

    @BeforeClass
    public void setUp() throws Exception {
        browserEmulator = new BrowserEmulator();

    }
    @Test(dataProvider = "dp" )
    public void search(Map<String,String> data) {
        browserEmulator.open(data.get("url").trim());
        browserEmulator.type(data.get("input1").trim(), data.get("name1").trim());
        browserEmulator.click(data.get("button").trim());
        browserEmulator.isTextPresent(data.get("expect").trim(), 3000);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        browserEmulator.quit();
    }

    @DataProvider(name = "dp")
    public Iterator<Object[]> dataFortestMethod(Method method) throws IOException {
        return new ExcelDataProvider(this.getClass().getName(),method.getName());
    }

}