package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchUserPage;
import utilities.ExcelUtility;

public class SearchUserPageTest extends Base {
	LoginPage loginpage;
	HomePage homePage;
	AdminUsersPage adminUsersPage;
	SearchUserPage searchUserPage;

	@Test
	public void VerifySearchUserPage() throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(2, 0, "Loginpage");
		String password = ExcelUtility.getStringData(2, 1, "Loginpage");
		String name=ExcelUtility.getStringData(1, 0, "SearchUserPage");
		loginpage.enterUsernameAndPassword(username, password);
		homePage = loginpage.clickonSingnInButton();
		adminUsersPage = homePage.ClickOnMoreInfo();
		searchUserPage = adminUsersPage.clickonSearchButton().addDetails(name).clickOnSearch();
		
		boolean tableDisplayed = searchUserPage.isTableDisplayed();
		Assert.assertTrue(tableDisplayed, Constant.ERRORMESSAGEDISPLYEDONTHETABLE);

	}
}
