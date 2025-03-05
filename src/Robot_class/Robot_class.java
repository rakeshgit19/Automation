package Robot_class;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Robot_class {

	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		//Robot class apply to perform keyboard functionality
		WebDriver Driver = new ChromeDriver();
		Driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		Driver.manage().window().maximize();
		Thread.sleep(2000);
		Robot r = new Robot();
		Driver.navigate().refresh();
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);

	}

}
