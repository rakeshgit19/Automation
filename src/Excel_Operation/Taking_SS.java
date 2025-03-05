package Excel_Operation;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Taking_SS {

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
		driver.get("https://orangehrm.qedgetech.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//Java time Stamp
		DateFormat df = new SimpleDateFormat("");
		Date d = new Date();
		String datef = df.format(d);
		
		//Take screenshot and store
	    File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   
	    //copy screenshot into local system
	    FileUtils.copyFile(screen, new File(""));
	    
	    driver.close();

	}

}
