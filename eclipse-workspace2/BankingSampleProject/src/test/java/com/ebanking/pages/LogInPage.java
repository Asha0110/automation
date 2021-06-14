package com.ebanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	WebDriver driver;
	
	public LogInPage (WebDriver driver){
		this.driver= driver;
	}
	
	By uname = By.xpath("//input[@type='text']");
	By pword = By.xpath("//input[@type='password']");
	By logbtn = By.xpath("//input[@type='submit']");
	By logOut = By.xpath("");
	
	public WebElement sendUserName( String username) {
		return driver.findElement(uname);
	}
	
	public WebElement sendPassWord(String password) {
		return driver.findElement(pword);
	}
	
	public WebElement clickLogInBtn() {
		return driver.findElement(logbtn);
	}

	public WebElement logoutBtn() {
		return driver.findElement(logOut);
		
	}
	
	
	
}
