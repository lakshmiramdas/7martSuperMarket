package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchListCategoryPage {
	public WebDriver driver;
	
	public SearchListCategoryPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
WebElement searchbutton;
@FindBy(xpath = "//input[@class='form-control']")
WebElement category;
@FindBy(xpath = "//button[@type='submit']")
WebElement searchbutton2;
@FindBy(xpath = "/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr/td/span/center")
WebElement tableDisplay;

public SearchListCategoryPage clickOnSearchButton()
{
	searchbutton.click();
	return this;
}
public SearchListCategoryPage typeCategory(String categoryname)
{
	category.sendKeys(categoryname);
	return this;
}

public SearchListCategoryPage clickSearchButton2()
{
	searchbutton2.click();
	return this;
}
public boolean tableDisplayed()
{
	return tableDisplay.isDisplayed();
}
}
