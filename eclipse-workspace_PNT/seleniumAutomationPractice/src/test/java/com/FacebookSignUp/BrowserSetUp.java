package com.FacebookSignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BrowserSetUp {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		WebElement cretaccountbtn = driver.findElement(By.xpath("//*[text()= 'Create new account']"));
		cretaccountbtn.click();
		Thread.sleep(5000);
		WebElement fname = driver.findElement(By.xpath("//input[@name='firstname']"));
		fname.sendKeys("arial");
		WebElement lname = driver.findElement(By.xpath("//input[@name='lastname']"));
		lname.sendKeys("stone");
		WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		email.sendKeys("astone@gmail.com");
		WebElement reemail = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		reemail.sendKeys("astone@gmail.com");
		Thread.sleep(5000);
		WebElement month = driver.findElement(By.xpath("//*[@name='birthday_month']"));
		Select select = new Select(month);
		select.selectByIndex(3);
		WebElement  birthday = driver.findElement(By.xpath("//*[@name='birthday_day']"));
		Select se = new Select(birthday);
		se.selectByValue("14");
		WebElement year = driver.findElement(By.xpath("//*[@name='birthday_year']"));
		Select s = new Select(year);
		s.selectByVisibleText("2004");
		Thread.sleep(5000);
		WebElement gender = driver.findElement(By.xpath("(//input[@ name='sex'])[1]"));
		gender.click();
		WebElement signUpBtn = driver.findElement(By.xpath("//button[@name='websubmit']"));
		signUpBtn.click();
		Thread.sleep(5000);
		
		
		
		
		driver.close();
	}

}
