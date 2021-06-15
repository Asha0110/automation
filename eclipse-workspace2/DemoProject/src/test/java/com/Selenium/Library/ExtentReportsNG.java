package com.Selenium.Library;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsNG {

	static ExtentReports extent;
	

	public static ExtentReports getExtentReport() {

		String path = System.getProperty("user.dir")+"/reports/index.html";
		// String path1 = System.getProperty("./Reports/index.html");

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);// extentSparkReporetr creates a html file andd
																		// does some configuration
	

		reporter.config().setReportName("Ohrm Automation");// name of report
		reporter.config().setDocumentTitle("test result");// title of report
		reporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Asha");

		return extent;

	}

}
