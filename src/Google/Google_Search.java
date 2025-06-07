package Google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Search 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("India");
		
		Thread.sleep(3000);
		
		List<WebElement> l = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		
		String expval = "India";
		
		for (WebElement we:l) 
		{
			String data = we.getText();
			System.out.println(data);
			
			if (data.contains(expval)) 
			{
				we.click();	
			}
		}
		

	}

}
