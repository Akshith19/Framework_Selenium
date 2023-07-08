package com.base;




import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Listeners(value=ListenerImplements.class)
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
    	TestNG testNg = new TestNG();
    	testNg.addListener(new AnnotationTransfer());
        this.baseExcelDataObject = baseExcelDataObject;
        this.setUp(testCaseName);
        setDriver(testCaseName);

    }

    public void setUp(String testCaseName)
    {
       this.dtobj = (List<BaseExcelDataObject>) TestUtil.Genrate(testCaseName);
    }

    public void setDriver(String testCaseName) throws IOException
    {

        File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");

        fileInput = new FileInputStream(file);
        prop = new Properties();
        prop.load(fileInput);
        String browserType=prop.getProperty("browser").toLowerCase();
        logger(testCaseName,browserType);
        switch(browserType)
        {
            case "chrome": 
            ChromeOptions optionsChrome = new ChromeOptions();
            optionsChrome.addArguments("start-maximized");
            optionsChrome.addArguments("--incognito");
            optionsChrome.addArguments("--remote-allow-origins=*");
            driver=new ChromeDriver(optionsChrome);
                break;
            case "edge": 
            EdgeOptions optionsEdge = new EdgeOptions();
            optionsEdge.setCapability("InPrivate", true);
            
            driver=new EdgeDriver();
                break;
            case "firefox": 
            driver=new FirefoxDriver();
                break;    
        }
       
    }
    
    
   
   
    
    public void logger(String testCaseName,String browserType)
    { 
    	log =Logger.getLogger("TestBase");
        log.info("Testcase -----------{"+testCaseName.toUpperCase()+"}");
        log.info("Browser ------------{"+browserType.toUpperCase()+"}");
    }
}
