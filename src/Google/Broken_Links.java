package Google;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_Links 
{

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		
		List<WebElement>l =  driver.findElements(By.tagName("a"));
		l.size();
		
		for (int i = 0; i < l.size(); i++) 
		{
		
			String url = l.get(i).getAttribute("href");
			System.out.println(url);
			
			URL links = new URL(url);
			HttpURLConnection con = (HttpURLConnection)links.openConnection();
			con.connect();
			int responsecode = con.getResponseCode();
			
			if (responsecode==200) 
			{
			
				System.out.println("its valid link=" +url);
			} else {
				
				System.out.println("its invalid link=" +url);    
			}
		}

	}

}
