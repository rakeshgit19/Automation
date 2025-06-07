package Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Logout 
{
    WebDriver driver;
	Actions ac;
	public Logout(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(id="welcome")
	WebElement welcome;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement lout;
	
	public void pageLogout() throws InterruptedException
	{
	
		Thread.sleep(1000);
		ac = new Actions(driver);
		ac.moveToElement(welcome).click().perform();;
		//welcome.click();  
		Thread.sleep(1000);
		ac.moveToElement(lout).click().perform(); ;
		//lout.click();
		
	}

}
