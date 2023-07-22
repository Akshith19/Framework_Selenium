package com.testcases;

import com.base.TestBase;
import com.base.TestUtil;
import com.data.ExcelDataObject;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LaunchBrowser extends TestBase {

    @BeforeClass
    public void initialize() throws IOException
        {
    	
            ExcelDataObject obj = new ExcelDataObject();
            setup(this.getClass().getSimpleName(),obj);
        }

    @Test(dataProviderClass = TestUtil.class,dataProvider ="dp" )
    public void browser(ExcelDataObject dt) throws IOException, InterruptedException {

    	driver.manage().window().maximize();
    	driver.get("https://www.google.com");
        Thread.sleep(1000);
    }


    @AfterClass
    public void tearDown()
    {
    	driver.quit();
    }
}
