package testscript;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class HomePageTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
  @Test
  public void verifyUserCanLogout() throws IOException {
	  LoginPage loginPage = new LoginPage(driver);
	  String username=ExcelUtility.getStringData(2, 0, "Loginpage");
	  String password=ExcelUtility.getStringData(2, 1, "Loginpage");
	  loginPage.enterUsernameAndPassword(username, password);
	  homePage=loginPage.clickonSingnInButton().clickOnAdmin().clickonLogout();
	  
	  String expected=driver.getTitle();
	  String actual="Login | 7rmart supermarket";
	  System.out.println("Title:"+driver.getTitle());
	  Assert.assertEquals(expected, actual, Constant.ERORRMESSAGEFORLOGIN);
	  
	  
  }
}
