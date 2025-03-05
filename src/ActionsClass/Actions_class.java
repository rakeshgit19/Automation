package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_class {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://flipkart.com");
		//https://jqueryui.com/droppable
		driver.manage().window().maximize();
		Actions ac = new Actions(driver);
		Thread.sleep(3000);
		//move mouse action
		ac.moveToElement(driver.findElement(By.xpath("//img[@alt='Fashion']"))).click().perform();
		Thread.sleep(3000);
		ac.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'More in ')] //following::a[4]"))).click().perform();
		
		//scroll the scroll bar
		ac.scrollByAmount(0, 10000);
		
		

	}

}
