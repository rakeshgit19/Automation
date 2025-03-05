package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class PropertyFile {
	WebDriver driver;
	Properties p;
	FileInputStream fis;
  
  @BeforeMethod
  public void lunch() throws IOException, InterruptedException 
  {
	  driver = new ChromeDriver();
	  p = new Properties();
	  fis = new FileInputStream("C://Automation Programme//Automation_Project//src//TestNG//Repository.properties");
	  p.load(fis);
	  driver.get(p.getProperty("url"));
	  driver.manage().window().maximize();
	  Reporter.log("Browser lunch success",true);
	  Thread.sleep(2000);
	  
  }

  @Test
  public void login() throws InterruptedException 
  {
	   driver.findElement(By.xpath(p.getProperty("objusername"))).sendKeys("Admin");
	   driver.findElement(By.xpath(p.getProperty("objpassword"))).sendKeys("Qedge123!@#"); 
	   driver.findElement(By.xpath(p.getProperty("objlogin"))).click();
	   Reporter.log("login success",true);
	   Thread.sleep(3000);
  }
  
  @AfterMethod
  public void logout() 
  {
	  driver.close();
	  Reporter.log("Application closed successfully",true);
  }

}
