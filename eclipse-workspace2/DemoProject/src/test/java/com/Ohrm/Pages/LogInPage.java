package com.Ohrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	
	public WebDriver driver;
	
	public LogInPage( WebDriver driver){ // constructor 
		this.driver = driver;
		}
	By Uname = By.id("txtUsername");
	By pword= By.id("txtPassword");
	By Logbtn = By.id("btnLogin");
	
	
	public WebElement goToUsername() {
		 return driver.findElement(Uname);
		
		}
	public WebElement goToPassWord() {
		 return driver.findElement(pword);
	
}
	public WebElement goToLogIn() {
		 return driver.findElement(Logbtn);
}
	}