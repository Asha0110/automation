package com.employeeapi.utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter{
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentSparkReporter reporter;
	public ExtentReports extent;
	//public ExtentTest test;
	public ExtentTest logger;
	

	public void onTestStart(ITestResult result) {// On Test Start
		String path = System.getProperty("user.dir")+"/ExtentReports/index.html";
		reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Automation Practice Results");
		reporter.config().setDocumentTitle("Test Report");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", " Shrestha");
		extent.setSystemInfo("Job Id", "1001");
		extent.setSystemInfo("user", "asha");
		
//		test = extent.createTest(result.getMethod().getMethodName());		
//		extentTest.set(test);
	}

	
	public void onTestSuccess(ITestResult result) {// On Test Success
		//test = extent.createTest(result.getMethod().getMethodName());
		logger = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(logger);
		//extentTest.get().log(Status.PASS, "Test successfully passed.........!!");
		logger.log(Status.PASS, "test passed.....");
		
	}	
	public void onTestFailure(ITestResult result) {// On Test Failure
		
		//extentTest.get().fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName();
//		extentTest.get().log(Status.FAIL, "Test case failed is" + result.getName());
//		extentTest.get().log(Status.FAIL, "Test case failed is" + result.getThrowable());
		logger.fail(result.getThrowable());
		logger.log(Status.FAIL, "Test failed"+result.getName());
		logger.log(Status.FAIL, "Test failed"+result.getThrowable());
		
	}

	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
	
	
	
	
	


