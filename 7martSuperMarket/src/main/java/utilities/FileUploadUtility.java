package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	
	public void fileuploadForSendKey(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	public void fileuploadForRoboClass(WebElement element,String path) throws AWTException
	{
		StringSelection stringSelect=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelect, null);
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);//virtual keys
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
}
