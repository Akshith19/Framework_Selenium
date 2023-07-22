package com.testcases;

import com.base.TestBase;
import com.base.TestUtil;
import com.data.ExcelDataObject;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class demo extends TestBase {

    @BeforeClass
    public void initialize() throws IOException
        {
    	
            ExcelDataObject obj = new ExcelDataObject();
            setup(this.getClass().getSimpleName(),obj);
        }

    @Test(dataProviderClass = TestUtil.class,dataProvider ="dp" )
    public void demo(ExcelDataObject dt) throws IOException, InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        
    }


    @AfterClass
    public void tearDown()
    {
    	driver.quit();
    }
}
