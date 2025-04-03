package testscript;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;

import pages.AdminUsersPage;
import pages.DemoSubCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class TestDemoSubCategoryPage extends Base {
	LoginPage loginpage;
	HomePage homePage;
	AdminUsersPage adminUsersPage;

	DemoSubCategoryPage demosubcatetegory;

	@Test
	public void verifyAddNewSubCategoryPage() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		loginpage.enterUsernameAndPassword(username, password);
		demosubcatetegory = loginpage.clickonSingnInButton().demoSubCategoryMoreInfo().clickOnAddNewSubCategory()
				.enterSubCategoryDetails().save();

		boolean isAlertDisplayed = demosubcatetegory.isAlertDisplayed();
		System.out.println("Alert Displayed:" + isAlertDisplayed);
		Assert.assertTrue(isAlertDisplayed, Constant.ALERTMESSAGEFORADDNEWCATEGORY);

	}

}
