package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AddCategoryPage;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchListCategoryPage;
import utilities.ExcelUtility;

public class SearchListCategoryPageTest extends Base {
	LoginPage loginpage;
	HomePage homePage;
	AdminUsersPage adminUsersPage;
	AddCategoryPage addcategorypage;
	SearchListCategoryPage searchlistcategorypage;

	@Test
	public void verifySearchListCategoryPage() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(2, 0, "Loginpage");
		String password = ExcelUtility.getStringData(2, 1, "Loginpage");
		loginpage.enterUsernameAndPassword(username, password);

		searchlistcategorypage = loginpage.clickonSingnInButton().ClickonCategoryMoreInfo().clickOnSearchButton();

		String category = ExcelUtility.getStringData(1, 0, "SearchCategoryPage");
		searchlistcategorypage.typeCategory(category).clickSearchButton2();

		boolean tableDisplayed = searchlistcategorypage.tableDisplayed();
		Assert.assertTrue(tableDisplayed, Constant.ERRORMESSAGEDISPLYEDONTHETABLE);

	}
}
