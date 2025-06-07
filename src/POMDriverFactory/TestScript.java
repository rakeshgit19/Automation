package POMDriverFactory;

import org.testng.annotations.Test;

import POM.EmployeeCreation;
import POM.Login;
import POM.Logout;
import POM.UserCreation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestScript {
  WebDriver driver;
	
  @BeforeTest
  public void signIn() throws InterruptedException, MalformedURLException 
  {
	  
	  //Run the script in Selenium Grid
	    String huburl = "http://192.168.8.100:4444/wd/hub";
	    
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//here we will provide our node machine windows version if node machine is only one.If node machine is 
		//multiple machine then we cannot provide a single node machine windows version. so we will provide simply windows
		//without any version for multiple node machine if all node machine OS is windows.
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("firefox");
		
	  driver = new RemoteWebDriver(new URL(huburl),cap); 
		
	  
	 // driver = new ChromeDriver();
	  driver.get("https://orangehrm.qedgetech.com");
	  driver.manage().window().maximize();
	  //Now call the Class name
	  Login l = PageFactory.initElements(driver, Login.class);
	  //Now call the respective Method name which present in the respective class
	  l.AdminLogin("Admin","Qedge123!@#");
	  Thread.sleep(2000);
  }
  @Test(priority=0)
  public void usercreation() throws InterruptedException 
  {
	  Thread.sleep(2000);
	 //Now call the Class name
	  UserCreation uc = PageFactory.initElements(driver, UserCreation.class);
	//Now call the respective Method name which present in the respective class
	  uc.userCreation("ESS","Rakesh Kumar Dalai","RakeshQA2","Enabled","Rakesh@0989","Rakesh@0989");
	  Thread.sleep(2000);
  }
  @Test(priority=1)
  public void employeecreation() throws InterruptedException   
  {
	  Thread.sleep(2000);
	  //Now call the Class name
	  EmployeeCreation ec = PageFactory.initElements(driver, EmployeeCreation.class);
	  //Now call the respective Method name which present in the respective class
	  ec.employeeCreation("Rakesh","Kumar","Dalai","123");
  }

  @AfterTest
  public void signOut() throws InterruptedException 
  {
	  Thread.sleep(2000);
	  Logout lo = PageFactory.initElements(driver, Logout.class);
	  lo.pageLogout();
	  Thread.sleep(3000);
	  driver.close();
  }

}
