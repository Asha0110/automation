package pageObjectModelFB;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FaceBookSignUpPage {
	public WebDriver driver;

	@FindBy(name = "firstname")
	WebElement fname;
	@FindBy(name = "lastname")
	WebElement lname;
	@FindBy(name = "reg_email__")
	WebElement email;
	@FindBy(name = "reg_passwd__")
	WebElement newPass;
	@FindBy(name = "birthday_month")
	WebElement bMonth;
	@FindBy(name = "birthday_day")
	WebElement bDay;
	@FindBy(name = "birthday_year")
	WebElement bYear;
	@FindBy(xpath = "(//input[@ name='sex'])[1]") WebElement genderF;
	@FindBy(name = "websubmit")
	WebElement signUpBtn;

	public FaceBookSignUpPage(WebDriver driver) { // PageFactory constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void sendFname() {
		fname.sendKeys("Hope");
	}

	public void sendLname() {
		lname.sendKeys("Crestha");
	}

	public void sendEmail() {
		email.sendKeys("hope2@gmail.com");
	}

	public void sendPassWord() {
		newPass.sendKeys("Abc12345");
	}

	public void selectBMonth() {
		Select se = new Select(bMonth);
		se.selectByIndex(3);

	}

	public void selectBDay() {
		Select se1 = new Select(bDay);
		se1.selectByVisibleText("10");
	}

	public void selectBYear() {
		Select se2 = new Select(bYear);
		se2.selectByValue("2010");
	}

	public void selectGender() {
		genderF.click();

	}

	public void clickSignUp() {
		signUpBtn.click();
	}

}// ending
