package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtilities;

public class AddNewUserPage {
	public WebDriver driver;
	PageUtilities pageUtilities = new PageUtilities();

	public AddNewUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement selectdropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public AddNewUserPage enterDetails(String uname, String pass) {

		username.sendKeys(uname);
		password.sendKeys(pass);
		// Select select=new Select(selectdropdown);
		// select.selectByVisibleText("Admin");
		pageUtilities.selectByvisibleTest(selectdropdown, "Admin");
		return this;
	}

	public AddNewUserPage clickOnSave() {
		savebutton.click();
		return this;

	}

	public AddNewUserPage clickOnReset() {
		resetbutton.click();
		return this;
	}

	public boolean isalertDisplayed() {
		return alert.isDisplayed();
	}
}
