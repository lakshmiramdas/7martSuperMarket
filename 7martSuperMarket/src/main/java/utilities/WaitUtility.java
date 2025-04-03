package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	 public WebDriver driver;
	 public void waitForElementToClick(WebDriver driver,WebElement element)
	 {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	 }


	public void waitforElementTobePresent(WebDriver driver,WebElement element)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) element));
	}
	
}