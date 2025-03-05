package com.pack1;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Pop_Window {

	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		WebDriver Driver = new ChromeDriver();
		Driver.navigate().to("https://raildrishti.indianrailways.gov.in/raildrishti/raildrishtiv3/");
		Driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions ac = new Actions(Driver);
		Robot r = new Robot();
		//Parent window id 
		String parentid = Driver.getWindowHandle();
		System.out.println(parentid);
		
		//scroll the page down
		ac.scrollByAmount(0, 3000).perform();
		
		//search the new pop link
		Driver.findElement(By.xpath("//*[contains(text(),'Retiring Room Booking')]")).click();
		Thread.sleep(2000);
		//click on the popup message
		String alert = Driver.switchTo().alert().getText();
		System.out.println(alert);
		Driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		//get windows id
		Set<String>winid = Driver.getWindowHandles();
		System.out.println(winid);
		
		for (String child : winid) {
			
			//Parent id should not equal to child window
			if (!parentid.equals(child)) {
				
				Driver.switchTo().window(child);
				Thread.sleep(2000);
				Driver.findElement(By.xpath("//*[@id = 'reload-button']")).click();
				Thread.sleep(2000);
				String url = Driver.getCurrentUrl();
				System.out.println(url);
				String pagetitle = Driver.getTitle();
				System.out.println("page title is = " +pagetitle);
				Driver.close();
			}
		}
		

	}

}
