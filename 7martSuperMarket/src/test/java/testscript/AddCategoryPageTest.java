package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AddCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AddCategoryPageTest extends Base {
	LoginPage loginpage;
	HomePage homePage;
	AddCategoryPage addcategorypage;
	FakerUtility fakerutility = new FakerUtility();

	@Test
	public void VerifyAddCategoryPage() throws AWTException, IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(2, 0, "Loginpage");
		String password = ExcelUtility.getStringData(2, 1, "Loginpage");
		loginpage.enterUsernameAndPassword(username, password);
		
		addcategorypage = loginpage.clickonSingnInButton().ClickonCategoryMoreInfo().clickonNewButton();
		String categoryName = fakerutility.getFakeCityName();
		addcategorypage.enterTheCategory(categoryName).clickonCategoryselect().chooseFile().clickOnSaveButton();

		boolean alertDisplayed = addcategorypage.isAlertDisplayed();
		System.out.println("Alert Displayed:" + alertDisplayed);
		Assert.assertTrue(alertDisplayed, Constant.ALERTMESSAGEFORADDNEWCATEGORY);

	}
}
