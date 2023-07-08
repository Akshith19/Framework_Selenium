package com.base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplements extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName().toUpperCase());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName().toUpperCase()+" testcase Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName().toUpperCase()+" testcase Failed");
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName().toUpperCase()+" testcase Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		  report = new ExtentReports();
		  ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "\\test-output\\Extent-report\\Extent.html"); 
		  report.attachReporter(spark);
		  spark.config().setDocumentTitle("Automation Report");
		  spark.config().setTheme(Theme.DARK);
		  System.out.println("Suit level test started");
		    
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		System.out.println("Suit level test ended");
	}

}
