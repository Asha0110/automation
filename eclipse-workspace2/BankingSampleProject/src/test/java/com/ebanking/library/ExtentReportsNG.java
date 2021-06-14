package com.ebanking.library;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsNG {
	
	final static Logger logger = Logger.getLogger(ExtentReportsNG.class);
	
	static ExtentReports extent;

	public static ExtentReports getExtentReport() {
		try {
			// System.getProperty("user.dir")--- gives the current project path
			String path = System.getProperty("user.dir") + "/ExtentReports/index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			extent = new ExtentReports();
			reporter.config().setReportName("Automation Practice Results");
			reporter.config().setDocumentTitle("Extent Report");
			reporter.config().setTheme(Theme.DARK);

			extent.attachReporter(reporter);
			extent.setSystemInfo("tester", "Asha");
			extent.setSystemInfo("Job Id", "1001");
			
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		return extent;

		}
	
	
	
	
	
	
	
	
	
	
	
}// closing tag
