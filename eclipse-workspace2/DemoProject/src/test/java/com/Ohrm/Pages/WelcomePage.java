package com.Ohrm.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {

	public WebDriver driver;

	public WelcomePage(WebDriver driver) { // constructor
		this.driver = driver;
	}

	By btnAdm = By.xpath("//b[contains(text(),'Admin')]");
	By empbtn = By.xpath("//input[@id='ohrmList_chkSelectAll']");
	By addbtn = By.xpath("//input[@id='btnAdd']");
	By sendname = By.cssSelector("#empStatus_name");
	By savebtn = By.id("btnSave");
	By myinfo = By.xpath("//b[contains(text(),'My Info')]");
	By edit = By.xpath("//input[@id='btnSave']");
	By fstName = By.xpath("//input[@id='personal_txtEmpFirstName']");
	By lstName = By.xpath("//input[@id='personal_txtEmpLastName']");
	By empId = By.xpath("//input[@id='personal_txtEmployeeId']");
	By DLN = By.xpath(" //input[@id='personal_txtLicenNo']");
	By gender = By.cssSelector("#personal_optGender_2");
	By expirelicensedt = By.xpath("//input[@id='personal_txtLicExpDate']");
	By maritalstatus = By.xpath("//select[@id='personal_cmbMarital']");
	By dob = By.xpath("//input[@id='personal_DOB']");
	By save = By.xpath("//input[@id='btnSave']");

	public WebElement goToAdmin() {
		 return driver.findElement(btnAdm);
		 
	}

	public WebElement goToJob() {

		WebElement jb = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
		Actions a1 = new Actions(driver);
		a1.moveToElement((jb)).build().perform();
		WebElement empstatus = driver.findElement(By.xpath("//a[@id='menu_admin_employmentStatus']"));

		return empstatus;

	}

	public WebElement empStatBtn() {

		// checkbxHandle(By.xpath("//a[@id='menu_admin_employmentStatus']"),true);
		checkbxHandle(By.xpath("//input[@id='ohrmList_chkSelectRecord_1']"), true);
		checkbxHandle(By.cssSelector("#ohrmList_chkSelectRecord_6"), true);

		return driver.findElement(empbtn);

	}

	public WebElement addBtn() {
		return driver.findElement(addbtn);

	}

	public WebElement enterName() {
		return driver.findElement(sendname);

	}

	public WebElement saveBtnclick() {
		return driver.findElement(savebtn);

	}

	public WebElement myInfoclickbtn() {
		return driver.findElement(myinfo);

	}

	public WebElement editBtn() {
		return driver.findElement(edit);

	}

	public WebElement sendFirstname() {
		return driver.findElement(fstName);

	}

	public WebElement sendlastName() {
		return driver.findElement(lstName);

	}

	public WebElement sendEmpID() {
		return driver.findElement(empId);

	}

	public WebElement senddriverlicense() {
		return driver.findElement(DLN);

	}

	public WebElement genderBtn() {
		return driver.findElement(gender);

	}

	public WebElement licenseExpiredate() {

		return driver.findElement(expirelicensedt);

	}

	public void datepicker() {
		WebElement select = driver.findElement(By.xpath("//input[@id='personal_txtLicExpDate']"));
		select.click();
		Select selectdrpMth = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		selectdrpMth.selectByVisibleText("Jun");

		Select selectdropYr = new Select(
				driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[2]")));
		selectdropYr.selectByValue("2023");

	}

	public void selectDate() {
		dateSelect();

	}

	public void selectNationality() {
		Select selectctry = new Select(driver.findElement(By.xpath(" //select[@id='personal_cmbNation']")));
		selectctry.selectByVisibleText("Nepalese");
	}

	public void dateSelect() {

		List<WebElement> allDates = driver.findElements(By.xpath("//tbody//td"));
		for (WebElement date : allDates) {
			String dt = date.getText();
			if (dt.equals("12")) {
				date.click();
				break;
			}
		}

	}

	public WebElement selectMaritalStatus() {
		
		Select selectMs = new Select(driver.findElement(maritalstatus));
		selectMs.selectByIndex(2);
		return driver.findElement(maritalstatus);

	}
	
	public WebElement DOB() {
		driver.findElement(dob).clear();
		driver.findElement(dob).sendKeys("1989-04-14");
		return driver.findElement(dob);

	}
	public WebElement saveBtn() {
		driver.findElement(save).click();
		return driver.findElement(save);

	}
	
	
	
	private void checkbxHandle(By by, boolean ischecked) {

		WebElement empStatusElm = driver.findElement(by);
		boolean empstatebox = empStatusElm.isSelected();

		if (ischecked == true) { // wants to check the box

			if (empstatebox == true) {
				System.out.println("check box is already selected");
				
			} else {
				empStatusElm.click();
			}

		} else { // wants to uncheck the box
			if (empstatebox == true) {
				empStatusElm.click(); // this will uncheck the box
			} else {
				System.out.println("check box is not checked");
			}
		}

	}

}
