package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestBase {
    public static WebDriver driver;

    public static List<BaseExcelDataObject> dtobj=null;

    public static BaseExcelDataObject baseExcelDataObject=null;

    public void setup(String testCaseName, BaseExcelDataObject baseExcelDataObject)
    {
        this.baseExcelDataObject = baseExcelDataObject;
        this.setUp(testCaseName);
        driverSetup();

    }

    public void setUp(String testCaseName)
    {
       this.dtobj = (List<BaseExcelDataObject>) TestUtil.Genrate(testCaseName);
    }

    public void driverSetup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\SeleniumDrivers\\91.0.4472.101\\chromedriver.exe");
        driver = new ChromeDriver();
    }
}
