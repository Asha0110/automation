package com.ebanking.test.scripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.library.Base;
import com.ebanking.library.ExcelUtil;
import com.ebanking.pages.LogInPage;


public class DataDrivenTest extends Base {

	final static Logger logger = Logger.getLogger(DataDrivenTest.class);

@Test(dataProvider="logInData")
public void logInDDT(String userName, String passWord) throws InterruptedException {
	
	LogInPage lp = new LogInPage(driver);
	lp.sendUserName(userName);
	logger.info("username provided");
	lp.sendPassWord(passWord);
	logger.info("password provided");
	lp.clickLogInBtn();
	logger.info(" login btn clicked");
	
	Thread.sleep(3000);

	if(isAlertPresent()==true) {
	driver.switchTo().alert().accept(); // close alert
	driver.switchTo().defaultContent();
	Assert.assertTrue(false);
	logger.warn("login failed");
}else {
	Assert.assertTrue(true);
	logger.info("login passed");
	lp.logoutBtn();
	driver.switchTo().alert().accept();
}

}

public boolean isAlertPresent() {
	try {
		driver.switchTo().alert();
		
		return true;
	} catch (NoAlertPresentException e) {
		
		return false;
	}

}




@DataProvider(name="logInData")
	 public String [][] getData() throws IOException{
	String path = System.getProperty("user.dir")+"src/test/resources/TestData/guru99testdata.xlsx";	
	
	ExcelUtil eu = new ExcelUtil(path); // created object of excelUtil class
	
	 int totalrows = eu.getRowCount("Sheet1");
	 int totalcols = eu.getCellCount("Sheet1", totalrows);
	
	
	 String logInData[][] = new String[totalrows][totalcols]; // created two dimensional array for the same size
	
	 for(int i = 1;i<=totalrows;i++) { //1 
		
		for(int j=0;j<=totalcols;j++) { //0
			logInData[i-1][j] = eu.getCellData("Sheet1", i, j); 
		}
	}
	 
	 
	 return logInData;
	

}














}//closing tag
