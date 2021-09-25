package com.base;



import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;

    public static List<BaseExcelDataObject> dtobj=null;

    public static BaseExcelDataObject baseExcelDataObject=null;

    public static Properties prop;
    
    public static FileInputStream fileInput=null;
    
    public static ExtentTest test;
    public static ExtentReports report;
    public static Logger log;

    public void setup(String testCaseName, BaseExcelDataObject baseExcelDataObject) throws IOException
    {
        this.baseExcelDataObject = baseExcelDataObject;
        this.setUp(testCaseName);
        driverSetup(testCaseName);

    }

    public void setUp(String testCaseName)
    {
       this.dtobj = (List<BaseExcelDataObject>) TestUtil.Genrate(testCaseName);
    }

    public void driverSetup(String testCaseName) throws IOException
    {

        File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");

        fileInput = new FileInputStream(file);
        prop = new Properties();
        prop.load(fileInput);
        String browserType=prop.getProperty("browser").toLowerCase();
        logger(testCaseName,browserType);
        switch(browserType)
        {
            case "chrome": WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge": WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
       
    }
    
    public void logger(String testCaseName,String browserType)
    { 
    	log =Logger.getLogger("TestBase");
        log.info("Testcase -------------------{"+testCaseName.toUpperCase()+"}");
        log.info("Browser --------------------{"+browserType.toUpperCase()+"}");
    }
}
