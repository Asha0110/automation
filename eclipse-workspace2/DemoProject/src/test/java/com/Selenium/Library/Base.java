package com.Selenium.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	final static Logger logger = Logger.getLogger(Base.class);
	
	public WebDriver driver;
	String browserName;
	 public Properties prop;

	@BeforeMethod
	public WebDriver setUp() throws IOException {
		
		ExtentReportsNG.getExtentReport();
		String path = "src/test/resources/config.properties";
		FileInputStream file = new FileInputStream(path);
		 prop = new Properties();
		prop.load(file);
		browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().arch64().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:/Users/asha_/MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}
		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}
	@AfterClass
	public void afterAllTest() {
		if(driver!=null) {
			driver.quit();
		}
	}
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE); // this file is not in local machine, it is in virtual machine
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		

	}
}
