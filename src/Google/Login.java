package Google;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login 
{

	WebDriver driver;
	
	//in POM we cant use properties file because there is no logic of use of property file in POM as we can itself retrive the pom files in 
	//executable file using page classes.So properties file is not required to use in pom.
	
	//Creating login page class
	@FindBy(id="txtUsername")
	WebElement username;
	@FindBy(id="txtPassword")
	WebElement password;
	@FindBy(id="btnLogin")
	WebElement loginbutton;
	
	public void AdminLogin(String user,String pass) throws InterruptedException
	{ 
		username.sendKeys(user);
		password.sendKeys(pass); 
		Thread.sleep(1000);
		loginbutton.click();
	}
}
