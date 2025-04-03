package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchUserPage {
	public WebDriver driver;
	
	public SearchUserPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	
	}

@FindBy(xpath = "//input[@id='un']")
WebElement username;
@FindBy(xpath = "//select[@name='ut']")
WebElement usertype;
@FindBy(xpath = "//button[@value='sr']")
WebElement searchButton;
@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody")
WebElement  table;


public SearchUserPage addDetails(String uname)
{
	username.sendKeys(uname);
	Select select=new Select(usertype);
	select.selectByVisibleText("Admin");
	return this;
}
public SearchUserPage clickOnSearch()
{
	searchButton.click();
	 return this;
	 
}
public boolean isTableDisplayed() {
	return table.isDisplayed();
}


}
