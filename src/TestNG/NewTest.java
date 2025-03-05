package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class NewTest 
{
  WebDriver driver;
  
  @BeforeTest
  public void Lunch() 
  {
	  driver = new ChromeDriver();
	  driver.navigate().to("https://orangehrm.qedgetech.com");
	  driver.manage().window().maximize();
	  Reporter.log("Browser opened successfully",true);
	   
  }
  @Test(expectedExceptions =ElementNotInteractableException.class,description = "testing login link",priority=1,enabled=true)
  public void login() throws InterruptedException  
  {
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	   driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
	   driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	   Reporter.log("login success",true);
	   Thread.sleep(3000);
  }

  @AfterTest
  public void logout() throws InterruptedException 
  {
	 driver.close();
	 Reporter.log("Application closed successfully",true);
  }

}
