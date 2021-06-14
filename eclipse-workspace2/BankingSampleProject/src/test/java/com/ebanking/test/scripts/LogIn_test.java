package com.ebanking.test.scripts;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.ebanking.library.Base;
import com.ebanking.library.JavaPropertiesManager;
import com.ebanking.pages.LogInPage;

public class LogIn_test extends Base {
	String baseurl;
	String UN;
	String pw;
	final static Logger logger = Logger.getLogger(LogIn_test.class);

	Assertion a = new Assertion();

	@Test
	public void loginTest() throws InterruptedException {
		String path1 = "src/test/resources/config.properties";
		JavaPropertiesManager pro = new JavaPropertiesManager(path1); // created object of javapropertiesManager class
		baseurl = pro.readProperty("url");
		driver.get(baseurl);
		logger.info("url is open");

		LogInPage lp = new LogInPage(driver); // created object of loginpage class
		UN = pro.readProperty("username");
		lp.sendUserName(UN).sendKeys(UN);

		logger.info("username is entered....");
		pw = pro.readProperty("password");
		lp.sendPassWord(pw).sendKeys(pw);
		logger.info("password is entered.....");
		lp.clickLogInBtn().click();

//		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
//			Assert.assertTrue(true);
//		logger.info("login test is passed");
//		}
//		else {
//			Assert.assertTrue(false);
//			logger.info("login test is failed");
//		}

		String actualurl = driver.getCurrentUrl();
		String expected = "http://demo.guru99.com/V1/html/Managerhomepage.php";
		a.assertEquals(actualurl, expected);
		logger.info("login test is passed");

	}

	

}
