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

public class ResetUserPageTest extends Base {
	LoginPage loginpage;
	HomePage homePage;
	AdminUsersPage adminUsersPage;
	AddNewUserPage addnewuserpage;
	

	@Test
	public void VerifyResetButton() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(2, 0, "Loginpage");
		String password = ExcelUtility.getStringData(2, 1, "Loginpage");
		String name = ExcelUtility.getStringData(1, 0, "AddNewUserPage");
		String pass = ExcelUtility.getStringData(1, 1, "AddNewUserPage");
		loginpage.enterUsernameAndPassword(username, password);
		homePage = loginpage.clickonSingnInButton();
		addnewuserpage = homePage.ClickOnMoreInfo().clickonNewButton().enterDetails(name, pass).clickOnReset();
		
		String expected = driver.getTitle();
		String actual = "Admin Users | 7rmart supermarket";
		System.out.println("Title:" + driver.getTitle());
		Assert.assertEquals(expected, actual, Constant.ERORRMESSAGEFORDADMINUSERPAGE);

	}
}
