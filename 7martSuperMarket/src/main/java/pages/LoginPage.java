package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//aal the methods are written in the main java pages and also x path is located
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signinbutton;
	@FindBy(xpath = "//li[text()='Dashboard']")
	WebElement dashBoard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;
	
	public void enterUsernameAndPassword(String uname,String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
	}
	
	public HomePage clickonSingnInButton()
	{
		signinbutton.click();
		return new HomePage(driver) ;
	}
	public boolean isDashBoardDisplayed() {
		return dashBoard.isDisplayed();
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}


