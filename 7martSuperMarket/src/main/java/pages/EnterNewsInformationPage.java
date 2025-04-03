package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterNewsInformationPage {
	public WebDriver driver;

	public EnterNewsInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement News;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div/h5")
	WebElement alert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;

	

	public EnterNewsInformationPage clickOnNewButton() {
		newbutton.click();
		return this;
	}

	public EnterNewsInformationPage enterNews(String discription) {
		News.sendKeys(discription);
		return this;
	}

	public EnterNewsInformationPage clickOnSave() {
		savebutton.click();
		return this;
	}
	public SearchManageNewsPage clickonSearch()
	{
		searchbutton.click();
		return new SearchManageNewsPage(driver);
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();

	}

}
