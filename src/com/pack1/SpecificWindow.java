package com.pack1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SpecificWindow {

	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		WebDriver Driver = new ChromeDriver();
		Driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		Driver.manage().window().maximize();
		//Use action class for scroll the page
		Actions ac = new Actions(Driver);
		Robot r = new Robot();
				
		try
        {
			Thread.sleep(3000);;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
		
		Driver.navigate().refresh();
		Thread.sleep(3000);
		//Handling popup msg
		//ac.sendKeys(Keys.ESCAPE).build().perform();
		//Press ESCAPE button in keyboard
		r.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);;	
		//Release the ESCAPE button
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(4000);;
		
		//To scroll window we need to use javascript executor but in selenium v4 above javascript executor is deprecated and scroll is
	   //working using ACTION Class.
		ac.scrollByAmount(0, 400).perform();
		
		
		//Click on rail dristi and holiday packages button
				Driver.findElement(By.xpath("//*[contains(text(),'RAIL DRISHTI')]")).click();
				try
		        {
					Thread.sleep(3000);;
		        }
		        catch (InterruptedException e)
		        {
		            e.printStackTrace();
		        }
				Driver.findElement(By.xpath("//*[contains(text(),'HOLIDAY PACKAGES')]")).click();
				try
		        {
					Thread.sleep(3000);;
		        }
		        catch (InterruptedException e)
		        {
		            e.printStackTrace();
		        }
				Driver.findElement(By.xpath("//*[contains(text(),'GALLERY')]")).click();
				
				Set<String>wd = Driver.getWindowHandles();
				//List<String> wd1 = new ArrayList(wd);
				System.out.println(wd);
				
				Iterator<String> It = wd.iterator();
		        while (It.hasNext()) 
				{
				
					Driver.switchTo().window(It.next());
					String titles = Driver.getTitle();
					System.out.println(titles);
					Thread.sleep(3000);
					
					String childtitle = "IRCTC Tourism Official Website | Incredible India Travel & Tour Package";
					if (titles.contains(childtitle)) 
					{
					
						Thread.sleep(3000);
						Driver.switchTo().window(childtitle);
						Thread.sleep(2000);
						Driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
					}
				}
		
		

	}

}
