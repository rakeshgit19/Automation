package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dragndrop {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		Actions ac = new Actions(driver);
		Thread.sleep(3000);
		
		//switch to frame
		driver.switchTo().frame(0);
		
		//perform dragand drop
		WebElement origin = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement destination = driver.findElement(By.xpath("//*[@id='droppable']"));
		ac.dragAndDrop(origin, destination).perform();
		Thread.sleep(3000);
		//click double click
		ac.doubleClick(driver.findElement(By.xpath("//*[@id='draggable']")));
		
		//click right click
		ac.contextClick(driver.findElement(By.xpath("//*[@id='draggable']")));
		
		//click and hold left mouse
		ac.clickAndHold(origin);
		
		//to return to window 
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		//scroll
		ac.scrollByAmount(0, 1000);
		
	}

}
