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

public class DemoSubCategoryPage {
	PageUtilities pageUtility = new PageUtilities();
	FileUploadUtility fileUpload = new FileUploadUtility();
	WaitUtility wait = new WaitUtility();
	public WebDriver driver;

	public DemoSubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryDropdown;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement addSubCategory;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategoryTextField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	WebElement editSubCategory;
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div/h5")
	WebElement alertMessage;

	public DemoSubCategoryPage enterSubCategoryDetails() {
		pageUtility.selectByVisibleText(categoryDropdown, "Electronics");
		subCategoryTextField.sendKeys("Olaf2");
		fileUpload.fileuploadForSendKey(chooseFile, Constant.DOLLPATH);
		return this;
	}

	public DemoSubCategoryPage clickOnAddNewSubCategory() {
		addSubCategory.click();
		return this;
	}

	public DemoSubCategoryPage save() {
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		javaExecutor.executeScript("window.scrollBy(0,500)");// scroll down
		javaExecutor.executeScript("arguments[0].click();", save);
		wait.waitForElementToClick(driver, save);
		// save.click();
		return this;
	}
	
	public boolean isAlertDisplayed()
	{
		return alertMessage.isDisplayed();
	}

}
