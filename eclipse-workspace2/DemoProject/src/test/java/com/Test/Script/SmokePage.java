package com.Test.Script;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import com.Ohrm.Pages.LogInPage;
import com.Ohrm.Pages.WelcomePage;
import com.Selenium.Library.Base;

public class SmokePage extends Base {
	Assertion a = new Assertion();
	public static String url;
	public static String UN;
	public static String PW;

	@Test
	public void HomePage_Test() throws InterruptedException {

		 url = prop.getProperty("Url");
		 UN = prop.getProperty("UserName");
		 PW = prop.getProperty("PassWord");

		driver.get(url);
		// String actual = driver.getTitle();
		String actual = driver.getCurrentUrl();
		Thread.sleep(5000);
		String expected = "https://opensource-demo.orangehrmlive.com/";
		a.assertEquals(actual, expected);
	}

	@Test
	public void lonIntoOhrmAccount() throws InterruptedException {
		
		
		driver.get(url);
		LogInPage lp = new LogInPage(driver);
		lp.goToUsername().sendKeys(UN);
		lp.goToPassWord().sendKeys(PW);
		lp.goToLogIn().click();

//	}
//	@Parameters({"url","UserName","PassWord"})
//	@Test
//	public void WelcomePage_Test() throws InterruptedException {
//		//driver.get(url);
//		
		WelcomePage wp = new WelcomePage(driver);
		  	wp.goToAdmin();
		wp.goToJob().click();
		wp.empStatBtn();
		wp.addBtn().click();
		wp.enterName().sendKeys("per diem");
		wp.saveBtnclick().click();
	

//	@Test
//	public void myInfoDetails() throws InterruptedException {
//		WelcomePage wp = new WelcomePage(driver);
		wp.myInfoclickbtn().click();
		wp.editBtn().click();
		wp.sendFirstname().clear();
		wp.sendFirstname().sendKeys("Maya");
		wp.sendlastName().clear();
		wp.sendlastName().sendKeys("priya");
		wp.sendEmpID().clear();
		wp.sendEmpID().sendKeys("14567");
		wp.senddriverlicense().clear();
		wp.senddriverlicense().sendKeys("00134567");
		wp.genderBtn().click();
		wp.selectNationality();
		wp.datepicker();
		wp.dateSelect();
		//wp.selectDate();
		wp.selectMaritalStatus();
		wp.DOB();
		wp.saveBtn();
		Thread.sleep(10000);

	}
}
