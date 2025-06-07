package Google;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	   // driver.findElement(By.xpath("//div[@class='LX3sZb']//a[normalize-space()='Gmail']")).click();
	    
	    List<WebElement> l = driver.findElements(By.tagName("a"));
	    System.out.println(l.size());
	    
	    String link = "Gmail";
	    Thread.sleep(3000);
	    
	    try {
			
	    	for (WebElement wb:l) 
		    {
				String list = wb.getText();
				System.out.println(list);
				
				if (list.contains(link)) 
				{
					wb.click();
					
				}
			}
		} 
	    
	    catch (StaleElementReferenceException e) 
		{
			
			System.out.println("Exception handled");
		}
	    
	    Thread.sleep(7000);
	    driver.findElement(By.xpath("//div[@class='header__aside']/a[2]")).click();
	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("rakesh.dalai1490@gmail.com");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	    
	}

}
