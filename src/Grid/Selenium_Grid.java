package Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Selenium_Grid 
{

	public static void main(String[] args) throws MalformedURLException 
	{
		
		String huburl = "http://192.168.8.100:4444/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//here we will provide our node machine windows version if node machine is only one.If node machine is 
		//multiple machine then we cannot provide a single node machine windows version. so we will provide simply windows
		//without any version for multiple node machine if all node machine OS is windows.
		
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("firefox");
		
		WebDriver driver = new RemoteWebDriver(new URL(huburl),cap); 
		
		driver.get("https://google.com");
		driver.manage().window().maximize(); 
		String title = driver.getTitle();
		System.out.println(title);

	}

}
