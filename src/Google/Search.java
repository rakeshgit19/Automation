package Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@jsname ='vdLsw']//following::textarea[@title='Search']")).sendKeys("mphasis");
		
		//click on 5th element of mphasis link
		//driver.findElement(By.xpath("//ul[@class='G43f7e']/li[5]")).click();
		Thread.sleep(2000);
		
		//click outside of the search box
		driver.findElement(By.xpath("//form[@role='search']")).click();
		
		//click of google search button
		//driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[1]")).click();
		Thread.sleep(2000);
		//click on "I'M FEELING LUCKY" button
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[2]")).click();
		
		
		
		
		

	}

}
