package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.EnterNewsInformationPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class EnterNewsInformationPageTest extends Base {
	LoginPage loginpage;
	HomePage homePage;
	EnterNewsInformationPage enterNewsInformation;

	@Test
	public void VerifyEnterNewsInformationPage() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(2, 0, "Loginpage");
		String password = ExcelUtility.getStringData(2, 1, "Loginpage");
		loginpage.enterUsernameAndPassword(username, password);
		enterNewsInformation = loginpage.clickonSingnInButton().clickOnmoreInfo().clickOnNewButton()
				.enterNews("Wednesday sale-50%discount in selected goods").clickOnSave();
		
		boolean isAlertDisplayed=enterNewsInformation.isAlertDisplayed();
		System.out.println("Alert displayed:"+isAlertDisplayed);
		Assert.assertEquals(isAlertDisplayed, Constant.ALERTMESSAGEFORENTERNEWSPAGE);

	}
}
