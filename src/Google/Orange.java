package Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pack1.ChromeDriver;

public class Orange {
	WebDriver driver;
	 Actions ac;
	@BeforeTest
	public void lunch() throws InterruptedException
	{
	    driver =  new org.openqa.selenium.chrome.ChromeDriver();
		driver.get("https://orangehrm.qedgetech.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test
	public void login() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("Qedge123!@#");
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
	}
		
	@AfterTest
	public void logout() throws InterruptedException
	{
		ac= new Actions(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='welcome']")).click();
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Logout')]"))).click().perform();
		
		Thread.sleep(2000);
		driver.close();
		
		
		
	}
		
		
		

	

}
