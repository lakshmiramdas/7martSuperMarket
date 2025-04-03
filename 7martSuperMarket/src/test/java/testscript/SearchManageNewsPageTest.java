package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.EnterNewsInformationPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchManageNewsPage;
import utilities.ExcelUtility;

public class SearchManageNewsPageTest extends Base {
	LoginPage loginpage;
	HomePage homePage;
	EnterNewsInformationPage enternewspage;
	SearchManageNewsPage searchnewspage;

	@Test
	public void verifySearchManageNewsPageTest() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(2, 0, "Loginpage");
		String password = ExcelUtility.getStringData(2, 1, "Loginpage");
		String news=ExcelUtility.getStringData(1, 0, "SearchNewsPage");
		loginpage.enterUsernameAndPassword(username, password);
		enternewspage=loginpage.clickonSingnInButton().clickOnmoreInfo();
		enternewspage.clickonSearch().enterNewsTitle(news).clickonSearch2();
		
		boolean isTablemessageDisplayed= searchnewspage.isTableDisplayed();
		Assert.assertEquals(isTablemessageDisplayed, Constant.ERRORMESSAGEDISPLYEDONTHETABLE);
	}
}
