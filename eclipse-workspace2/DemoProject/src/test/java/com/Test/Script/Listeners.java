
package com.Test.Script;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;

import com.Selenium.Library.Base;
import com.Selenium.Library.ExtentReportsNG;

import com.Selenium.Library.GlobalLibrary;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener {

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentTest test;
	ExtentReports extent = ExtentReportsNG.getExtentReport();// calling extentreportsNG class

	public void onStart(ITestResult result) {
		System.out.println("onStart method started");
	}

	public void onFinish(ITestResult result) {
		
		extent.flush();
	}

	public void onTestStart(ITestResult result) {
		// System.out.println("New Test Started" + result.getName());
		test = extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {// On Test Failure
		test.fail(result.getThrowable());
		//extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e) {
		
		}
		
		try {
			getScreenShotPath(testMethodName, driver);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
//					.get(result.getInstance());
//		} catch (Exception e) {
//		}
//		
//			try {
//				extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver),
//						result.getMethod().getMethodName());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage" + result.getName());
	}
}
