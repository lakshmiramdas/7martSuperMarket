package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class AddCategoryPage {
	public WebDriver driver;
	FileUploadUtility fileupload = new FileUploadUtility();
	WaitUtility wait = new WaitUtility();
	PageUtilities pageutility = new PageUtilities();

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement entercategory;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement selectcategorydiscout;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div/div/form/div/div[2]/div/div/div[2]/ul")
	WebElement selectcategorysecondoption;
	@FindBy(xpath = "//input[@type='file']")
	WebElement choosefile;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div/div/form/div/div[4]/div[1]/label[2]/input")
	WebElement showOnTopMenuYes;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div/div/form/div/div[4]/div[1]/label[3]/input")
	WebElement showOnTopMenuNO;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div/div/form/div/div[4]/div[2]/label[2]/input")
	WebElement showonLeftMenuYes;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div/div/form/div/div[4]/div[2]/label[3]/input")
	WebElement showonLeftMenuNO;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement cancelButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public SearchListCategoryPage clickOnSearchButton()
	{
		searchbutton.click();
		return new SearchListCategoryPage(driver);
	}
	public AddCategoryPage clickonNewButton() {
		newbutton.click();
		return this;
	}
	public AddCategoryPage enterTheCategory(String category) {
		entercategory.sendKeys(category);
		return this;
	}

	public AddCategoryPage clickonCategoryselect() {
		selectcategorydiscout.click();
		return this;

	}

	public AddCategoryPage clickonCategoryselectsSecond() {
		selectcategorysecondoption.click();
		return this;

	}

	public AddCategoryPage chooseFile() {
		wait.waitForElementToClick(driver, choosefile);
		fileupload.fileuploadForSendKey(choosefile, Constant.PATH);
		return this;

	}

	public AddCategoryPage clickOnTopMenuYES() {
		showOnTopMenuYes.click();
		return this;
	}

	public AddCategoryPage clickOnLeftMenuYES() {
		showonLeftMenuYes.click();
		return this;
	}

	public AddCategoryPage clickOnSaveButton() {
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		javaExecutor.executeScript("window.scrollBy(0,1000)");// scroll down
		javaExecutor.executeScript("arguments[0].click();", savebutton);
		return this;
	}

	public AddCategoryPage clickOnCancelButton() {
		cancelButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
