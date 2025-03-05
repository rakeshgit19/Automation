package AutoIT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autoit {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		//This method works to perform desktop operation for download and upload file
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("")).click();
		Runtime.getRuntime().exec("C:\\Users\\pc\\Desktop\\AutoIT\\Download file.exe");

	}

}
