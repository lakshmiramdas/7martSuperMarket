package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AddNewUserPage;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AddNewUserPageTest extends Base {

	LoginPage loginpage;
	HomePage homePage;
	AdminUsersPage adminUsersPage;
	AddNewUserPage addnewuserpage;
	FakerUtility fakerutility;

	@Test
	public void VerifyAddNewUserPage() throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(2, 0, "Loginpage");
		String password = ExcelUtility.getStringData(2, 1, "Loginpage");
		String name = ExcelUtility.getStringData(1, 0, "AddNewUserPage");
		String pass = ExcelUtility.getStringData(1, 1, "AddNewUserPage");
		loginpage.enterUsernameAndPassword(username, password);
		homePage = loginpage.clickonSingnInButton();
		adminUsersPage = homePage.ClickOnMoreInfo();
		addnewuserpage = adminUsersPage.clickonNewButton().enterDetails(name, pass).clickOnSave();

		boolean isAlertDisplayed = addnewuserpage.isalertDisplayed();
		System.out.println("Alert Displayed:" + isAlertDisplayed);
		Assert.assertTrue(isAlertDisplayed, Constant.ALERTMESSAGEFORADDNEWUSERPAGE);

	}
}
