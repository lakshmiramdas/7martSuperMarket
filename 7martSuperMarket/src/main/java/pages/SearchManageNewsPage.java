package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchManageNewsPage {
	public WebDriver driver;

	public SearchManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement newstitle;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchbutton2;
	@FindBy(xpath = "/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr/td/span/center")
	WebElement tablemessage;
	
	public SearchManageNewsPage clickonSearch()
	{
		searchbutton.click();
		return new SearchManageNewsPage(driver);
	}
	public SearchManageNewsPage enterNewsTitle(String newtitle)
	{
		newstitle.sendKeys(newtitle);
		return this;
	}
	public SearchManageNewsPage clickonSearch2()
	{
		searchbutton2.click();
		return this;
	}
	public boolean isTableDisplayed()
	{
		return tablemessage.isDisplayed();
	}
}
