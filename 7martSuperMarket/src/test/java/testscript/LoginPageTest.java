package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
  @Test(retryAnalyzer=retry.RetryClass.class,groups = {"smoke"})
  public void verifyUsercanloginWithInValidCredentials() throws IOException {
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	  LoginPage login=new LoginPage(driver);
	  login.enterUsernameAndPassword(username,password);
	  login.clickonSingnInButton();
	  String expected="Dashbord | 7mart supermarket";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected,Constant.ERORRMESSAGEFORLOGIN);
	  
	  
  }
  @Test(dataProvider = "credentials")//dataprovider can be run in the same class
 public void verifyUsercanloginWithInvalidCredentials(String uname,String pass) throws AWTException {
	  
	  LoginPage login=new LoginPage(driver);
	  login.enterUsernameAndPassword(uname, pass);
	  login.clickonSingnInButton();
	  boolean isAlertDisplayed = login.isAlertDisplayed();
	  System.out.println("Alert Displayed:" + isAlertDisplayed);
	  Assert.assertTrue(isAlertDisplayed,Constant.ALERTMESSAGEFORLOGINPAGE);
	  
  }

	@DataProvider(name="credentials")
	public Object testData()
	{
		Object data[][]= {{"carol","invalid"},{"invalid","1q2w3e4r"},{"invalid","invalid"}};
		return data;
		
	}
	
	@Test @Parameters({"username","password"})//we can run the function only in XML file.
	 public void verifyUsercanloginWithINValidUsernames(String username,String password) throws IOException {
	  
	  LoginPage login=new LoginPage(driver);
	  String uname=ExcelUtility.getStringData(1, 0, "Loginpage");
	  String pass=ExcelUtility.getStringData(1, 1, "Loginpage");
	  login.enterUsernameAndPassword(uname,pass);
	  String expected = driver.getTitle();
	  String actual = "Dashboard | 7rmart supermarket";
	  System.out.println("Title:" + driver.getTitle());
	  System.out.println("Actual Title:" + actual);
	  Assert.assertEquals(expected, actual, Constant.ERORRMESSAGEFORDASHBORD);
 }
	@Test(groups = {"smoke"})
	public void verifyUsercanloginWithValidPassword() throws IOException {
	  
	  LoginPage login=new LoginPage(driver);
	  String username=ExcelUtility.getStringData(2, 0, "Loginpage");
	  String password=ExcelUtility.getStringData(2, 1, "Loginpage");
	  login.enterUsernameAndPassword(username, password);
	  login.clickonSingnInButton();
	  String expected = driver.getTitle();
	  String actual = "Dashboard | 7rmart supermarket";
	  System.out.println("Title:" + driver.getTitle());
	  Assert.assertEquals(expected, actual, Constant.ERORRMESSAGEFORDASHBORD);
	 
 }
}
