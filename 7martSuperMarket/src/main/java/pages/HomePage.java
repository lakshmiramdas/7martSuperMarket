package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility waitutility=new WaitUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement AdminLogout;
	@FindBy(xpath = "/html/body/div/nav/ul[2]/li/div/a[2]")
	WebElement Logout;
	@FindBy(xpath ="/html/body/div/div[1]/section/div/div/div[1]/div/a")
	WebElement MoreInfo;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[3]/div/a")
	 WebElement categorymoreinfo;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[4]/div/a")
	WebElement subcategorymoreinfo;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[9]/div/a")
	WebElement managenewsmoreinfo;
public AdminUsersPage ClickOnMoreInfo()
{
	MoreInfo.click();
	return new AdminUsersPage(driver) ;
}

public HomePage clickOnAdmin()
{	
	waitutility.waitForElementToClick(driver, AdminLogout);
	AdminLogout.click();
	return this;
}
public HomePage clickonLogout()
{	
	Logout.click();
	return this;
}
public AddCategoryPage ClickonCategoryMoreInfo()
	{
		categorymoreinfo.click();
		return new AddCategoryPage(driver);
	}


public DemoSubCategoryPage demoSubCategoryMoreInfo() 
{
	
	subcategorymoreinfo.click();
	return new DemoSubCategoryPage(driver);
	
}
public EnterNewsInformationPage clickOnmoreInfo() {
	JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
	javaExecutor.executeScript("window.scrollBy(0,1000)");// scroll down
	javaExecutor.executeScript("arguments[0].click();", managenewsmoreinfo);
	return new EnterNewsInformationPage(driver);
}
}