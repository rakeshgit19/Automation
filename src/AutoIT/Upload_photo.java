package AutoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Upload_photo {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://orangehrm.qedgetech.com");
		driver.manage().window().maximize();
		Actions ac = new Actions(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='btnAdd']")).click();
		
		//fill the details
		driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys("Rakesh");
		driver.findElement(By.xpath("//*[@name='firstName']//following::input[1]")).sendKeys("Kumar");
		driver.findElement(By.xpath("//*[@name='firstName']//following::input[2]")).sendKeys("Dalai");
		driver.findElement(By.xpath("//*[@name='firstName']//following::input[3]")).clear();
		driver.findElement(By.xpath("//*[@name='firstName']//following::input[3]")).sendKeys("100");
		Thread.sleep(2000);
		//click on choose file to upload the photo
		ac.moveToElement(driver.findElement(By.xpath("//input[@name='photofile']"))).click().perform();
		Thread.sleep(10000);
		Runtime.getRuntime().exec("C://Users//pc//Desktop//AutoIT//Upload file.exe");
		
		

	}

}
