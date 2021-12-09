package com.PapaJohnsStartOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StartOrder {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.papajohns.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[contains(text(), 'Start Your Order')]")).click();
		Thread.sleep(2000);
		WebElement country = driver.findElement(By.xpath("//*[@id='locations-country']"));
		Select s = new Select(country);
		s.selectByVisibleText("USA");
		WebElement residence = driver.findElement(By.xpath("//*[@id='locations-addresstype']"));
		Select se = new Select(residence);
		se.selectByValue("HOME");
		WebElement add = driver.findElement(By.xpath("//*[@id='autocomplete']"));
		add.sendKeys("12 styles dr");
		WebElement apt = driver.findElement(By.xpath("//*[@id='locations-aptstefloor']"));
		Select select = new Select(apt);
		select.selectByIndex(1);
		WebElement roomNum = driver.findElement(By.xpath("//input[@name='residential-roomnumber']"));
		roomNum.sendKeys("20");
		WebElement zipCode = driver.findElement(By.xpath("(//input[@name='zipcode'])[1]"));
		zipCode.sendKeys("03301");
		driver.findElement(By.xpath("//*[@class='button button-large']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver; // scroll down by using javascript
		js.executeScript("window.scrollBy(0,200)");
		// driver.findElement(By.xpath("//a[@aria-label='Details link of Cheese
		// Pizza']")).click();
		driver.findElement(By.xpath("(//a[text()='Details'])[3]")).click();// by using grouping xPath
		js.executeScript("window.scrollBy(0,150)");
		WebElement size = driver.findElement(By.xpath("//*[@id='Cheese Pizza-size-select']"));
		Select select1 = new Select(size);
		select1.selectByIndex(1);
		WebElement quantity = driver.findElement(By.xpath("//*[@id='cheese-pizza-quantity-select']"));
		Select select2 = new Select(quantity);
		select2.selectByVisibleText("2");
		WebElement crustType = driver.findElement(By.xpath("//*[@id='cheese-pizza-crust-select']"));
		Select select3 = new Select(crustType);
		select3.selectByVisibleText("Original Crust");
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,200)");
		WebElement flavor = driver.findElement(By.xpath("//*[@id='cheese-pizza-crust-flavor-select']"));
		Select select4 = new Select(flavor);
		Thread.sleep(2000);
		select4.selectByVisibleText("Add Crust Flavor");
		Thread.sleep(2000);
		WebElement addToOrder = driver.findElement(By.xpath("//*[@aria-label='ADD TO ORDER Cheese Pizza'][2]"));
		addToOrder.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@href='/order/checkout/start']")).click();
		// driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[1]/div/div/div/a[1]")).click();
		Thread.sleep(5000);

		WebElement fname = driver.findElement(By.xpath("//input[@id='contact-firstname']"));
		fname.sendKeys("arial");
		WebElement lname = driver.findElement(By.xpath("//input[@id='contact-lastname']"));
		lname.sendKeys("smith");
		WebElement email = driver.findElement(By.xpath("//input[@id='contact-email']"));
		email.sendKeys("asmith@gmail.com");
		WebElement phoneNo = driver.findElement(By.xpath("//input[@id='phone-number']"));
		phoneNo.sendKeys("(877) 547-7272");
		WebElement sms = driver.findElement(By.xpath("//input[@id='create-account-textoffers']"));
		sms.click();
		Thread.sleep(5000);
		driver.close();
	}

}
