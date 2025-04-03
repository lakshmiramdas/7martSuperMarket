package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButon;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	
	public AddNewUserPage clickonNewButton() {
		newbutton.click();
		return new AddNewUserPage(driver);

	}

	public void ClickOnNew() {
		newbutton.click();

	}

	public SearchUserPage clickonSearchButton() {
		searchButon.click();
		return new SearchUserPage(driver);

	}

	

	

}
