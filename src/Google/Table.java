package Google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		List<WebElement> table = driver.findElements(By.xpath("//table[@id='countries']//tbody//tr[position() =2]"));
		String r = driver.findElement(By.xpath("//table[@id='countries']//tbody//tr[position() =2]")).getText();
		System.out.println(r);
		String sr = driver.findElement(By.xpath("//table[@id='countries']//tbody//tr[position()= 3]//td[5]")).getText();
		System.out.println(sr);
		
		
		//table.size();-
		//driver.findElement(By.xpath("//table[@id='countries']//tr//td[2]//td[contains(text(),'Albania')]"));
		
		for (int i = 0; i < table.size(); i++) {
			
			String data = table.get(i).getText();
			System.out.println(data);
			
			//if data contains ALBANIA the get the code
			if (data.contains("Albania")) {
				System.out.println("its true");
				//table.get(i).click();
				table.get(i).getText();
				System.out.println(table);
				
			}
			else {
				System.out.println("its false");
			}		}
		
		

	}

}
