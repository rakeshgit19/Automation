package com.pack1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		WebDriver Driver = new ChromeDriver();
		Driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		Driver.manage().window().maximize();
		//Use action class for scroll the page
		Actions ac = new Actions(Driver);
		Robot r = new Robot();
		String Parent = Driver.getWindowHandle();
				
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
		Thread.sleep(2000);
		Driver.switchTo().frame(0);
		 
		
		Thread.sleep(14000);;
		
		//To scroll window we need to use javascript executor but in selenium v4 above javascript executor is deprecated and scroll is
	   //working using ACTION Class.
		ac.scrollByAmount(0, 400).perform();
		
		Driver.findElement(By.xpath("//*[contains(text(),'GALLERY')]")).click();
		Thread.sleep(2000); 
		
		//Switch windows one by one so for that we need to use arraylist to store all windows id
		ArrayList<String>allwinid = new ArrayList(Driver.getWindowHandles());
		System.out.println(allwinid);
//		//switch to Gallery window and get the page title
//		String title1=Driver.switchTo().window(allwinid.get(1)).getTitle();
//		System.out.println(title1);
//		String pageurl = Driver.getCurrentUrl();
//		System.out.println(pageurl);
//		Thread.sleep(2000); 
		
		for(String child:allwinid)
		{
			if (!Parent.equals(child)) {
				
				Driver.switchTo().window(child);
				Thread.sleep(2000);
				Driver.findElement(By.xpath("//a[contains(text(),' Virtual Tour')]//following::a[2]")).click();
			}
		}
		
		//switch to iframe
		Driver.switchTo().frame(0);
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@fill='none']")).click();
		

	}

}
