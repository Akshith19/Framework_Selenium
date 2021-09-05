package com.base;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;


public class TestUtil extends TestBase{
    public static String excelpath;
    @DataProvider(name="dp")
    public static Object[][] getData(Method m)
    {
        Object[][] testData = new Object[dtobj.size()][1];
        for(int i=0;i<dtobj.size();i++)
        {
            testData[i][0]=dtobj.get(i);
        }
        return testData;
    }

    public static List<? extends BaseExcelDataObject> Genrate(String sheetName)
    {
        List<? extends BaseExcelDataObject> people=null;
        try
        {
            excelpath= System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx";
            PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().sheetName(sheetName).build();
            people= Poiji.fromExcel(new File(excelpath),baseExcelDataObject.getClass(),options);
        }
        catch (Exception e)
        {
            e.printStackTrace();
    }
        return people;

    }
    
    public static void takescreenshot() throws IOException
    {
    	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(screenshotFile.getAbsolutePath());
        FileHandler.copy(screenshotFile, new File(System.getProperty("user.dir")+"\\target\\screenshots\\"+System.currentTimeMillis()+".png"));
      
    }


}
