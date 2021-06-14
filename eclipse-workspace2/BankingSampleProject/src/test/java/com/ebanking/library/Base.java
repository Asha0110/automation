package com.ebanking.library;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	final static Logger logger = Logger.getLogger(Base.class);

	public static WebDriver driver;
	//public String baseurl = "http://demo.guru99.com/V1/index.php";
	//public String username = "mngr330928";
	//public String password = "tEjEtan";
	private String browserName;

	@BeforeMethod
	public void set_Up() {
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("chrome browser is starting");
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().arch64().setup();
			driver = new FirefoxDriver();
			logger.info("firefox is starting");

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:/Users/asha_/MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
			logger.info("Ie is starting ");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@BeforeClass // this method will run only one time right before all test starts
	public void beforeAllTest() {
		try {
			logger.info("starting all test");
			String path = "C:\\Users\\asha_\\eclipse-workspace2\\BankingSampleProject\\src\\test\\resources\\config.properties"; // absolute
																																	// path
			String path1 = "src/test/resources/config.properties"; // relative path(project level)
			JavaPropertiesManager properties = new JavaPropertiesManager(path1);
			browserName = properties.readProperty("browser");
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);

		}
	}

	@AfterMethod
	public void tearDown() {
		try {
			if (driver != null) {
				driver.close();
			}
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}

	@AfterClass
	public void afterAllTest() {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			logger.error("Error: ", e);

		}
	}
	
	
	
public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}// closing tag
