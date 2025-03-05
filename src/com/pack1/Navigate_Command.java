package com.pack1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Navigate_Command {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	
	static WebDriver Driver;
	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		WebDriver Driver = new ChromeDriver();
		Driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		Driver.manage().window().maximize();
		//Thread.sleep(3000);
		Actions ac = new Actions(Driver);
		Robot r = new Robot();
		
		//Driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//get title of the page
		String pagetitle1 = Driver.getTitle();
		System.out.println(pagetitle1);
		//get current url of the loaded page
		String currenturl1 = Driver.getCurrentUrl();
		System.out.println(currenturl1);
		Thread.sleep(3000);
		
		//Verify url is secure or not
		if (currenturl1.contains("https")) {
			
			System.out.println("url is secure");
		}
		else {
			System.out.println("url is not secure");
		}
		
		//Verify url is startswith "https"
		if (currenturl1.startsWith("https")) {
			System.out.println("url startswith https");
			
		}
		else {
			System.out.println("url not startswith https");
		}
		
		Driver.navigate().back();
		//get title of the page
		String pagetitle2 = Driver.getTitle();
		System.out.println(pagetitle2);
		//get current url of the loaded page
		String currenturl2 = Driver.getCurrentUrl();
		System.out.println(currenturl2);
		Thread.sleep(3000);
		
		Driver.navigate().forward();
		//get title of the page
		String pagetitle3 = Driver.getTitle();
		System.out.println(pagetitle3);
		//get current url of the loaded page
		String currenturl3 = Driver.getCurrentUrl();
		System.out.println(currenturl3);
		Thread.sleep(3000);
		
		Driver.navigate().refresh();
		//get title of the page
		String pagetitle4 = Driver.getTitle();
		System.out.println(pagetitle4);
		//get current url of the loaded page
		String currenturl5 = Driver.getCurrentUrl();
		System.out.println(currenturl5);
		Thread.sleep(3000);
		
		//Handling popup msg
		//ac.sendKeys(Keys.ESCAPE).build().perform();
		//Press ESCAPE button in keyboard
		r.keyPress(KeyEvent.VK_ESCAPE);
		
		//Release the ESCAPE button
		r.keyRelease(KeyEvent.VK_ESCAPE);
		
		//find height and width of the irctc logo.so for that first we need to store that logo in webelement and get the dimension
		//then we can get the height and weight of the logo from the dimension.
		
		WebElement dimension = Driver.findElement(By.xpath("//img[@alt='Indian railway LOGO']"));
		Dimension dim = dimension.getSize();
		System.out.println(dim);
		//Height of the logo
		System.out.println(dim.getHeight());
		//width of the logo
		System.out.println(dim.getWidth());
		
		//find no of links present in the irctc webpage.so for that first we need to store all the link the count all the links then
		//print to the console.so for storing the links we need to use List.
		
		List<WebElement>links = Driver.findElements(By.tagName("a"));
		//Now get the no of sizes of the links
		int size1 = links.size();
		System.out.println(size1);
		
		//Now print all the links to the console
		for (int i = 0; i <= links.size(); i++) {
			
			try {
				
				String linklist = links.get(i).getText();
				System.out.println(linklist);
			} catch (Exception e) {
				
				System.out.println("exception handled");
			}
			} 
		Thread.sleep(3000);
		//Using SELECT class
		
		//Clicking Register button
		Driver.findElement(By.xpath("//*[contains(text(),'REGISTER')]")).click();
		Thread.sleep(3000);
		
		//Fill the details to register
		Driver.findElement(By.xpath("//*[@id ='userName']")).sendKeys("Rakeshibm");
		Thread.sleep(1000);
		Driver.findElement(By.xpath("//*[@id ='userName']//following::input[1]")).sendKeys("Rakesh Kumar Dalai");
		Thread.sleep(1000);
		Driver.findElement(By.xpath("//*[@id ='userName']//following::input[2]")).sendKeys("Rakesh@123");
		Thread.sleep(1000);
		Driver.findElement(By.xpath("//*[@id ='userName']//following::input[3]")).sendKeys("Rakesh@123");
		Thread.sleep(1000);
		Driver.findElement(By.xpath("//*[@id ='userName']//following::input[4]")).sendKeys("rakesh.dalai1490@gmail.com");
		Thread.sleep(3000);
		Select country = new Select(Driver.findElement(By.xpath("//select[@type='text']")));
		country.selectByVisibleText("+93 - Afghanistan");
		Thread.sleep(1000);
		//To find dropdown listbox is multiple or not
		Boolean boole = country.isMultiple();
		System.out.println(boole);
		
		//By using getOptions() method we can retrive all the dropdown list box items. So for that we need to store all the items in list
		List<WebElement> box = country.getOptions();
		System.out.println(box.size());
		Thread.sleep(1000);
		
		for (int i = 0; i <= box.size(); i++) {
			
		try {
			
			String items = box.get(i).getText();
			 System.out.println(items);
			 
		} catch (Exception e) {
			
			System.out.println("Exception Handled");
		}
		
		 
		 
		}
		
		if (box.contains("India")) {
			
			System.out.println("list box is true");
			
		}
		else {
			System.out.println("list box is not true");
		}  
		
		//Handling multiple windows
		//Get single window id
		String winid = Driver.getWindowHandle();
		System.out.println(winid);
		Thread.sleep(1000);
		
		//Press back button
		Driver.navigate().back();
		
		//Get Parent window id		
		String parent = Driver.getWindowHandle();		
		System.out.println(parent);
		Thread.sleep(3000);
		
		//To scroll window we need to use javascript executor but in selenium v4 above javascript executor is deprecated and scroll is
		//working using ACTION Class.
		/*
		 * // JavascriptExecutor js = (JavascriptExecutor)Driver; //
		 * js.executeScript("Window.ScrollBy(0,500)",""); //
		 * js.executeScript("Window.ScrollTo(0,document.body.ScrollHeight)");
		 */		
		ac.scrollByAmount(0, 400).perform();
		Thread.sleep(1000);
		//Click on rail dristi and holiday packages button
		Driver.findElement(By.xpath("//*[contains(text(),'RAIL DRISHTI')]")).click();
		Thread.sleep(2000); 
		Driver.findElement(By.xpath("//*[contains(text(),'HOLIDAY PACKAGES')]")).click();
		Thread.sleep(2000); 
		Driver.findElement(By.xpath("//*[contains(text(),'GALLERY')]")).click();
		Thread.sleep(2000); 
		
		//switch to window
		Set<String> allwin = Driver.getWindowHandles();
		System.out.println(allwin);
		
		//Switch windows one by one so for that we need to use arraylist to store all windows id
		ArrayList<String>allwinid = new ArrayList(Driver.getWindowHandles());
		System.out.println(allwinid);
		//switch to Gallery window and get the page title
		String title1=Driver.switchTo().window(allwinid.get(1)).getTitle();
		System.out.println(title1);
		String pageurl = Driver.getCurrentUrl();
		System.out.println(pageurl);
		Thread.sleep(2000); 
		
		//switch to irctc tourism window and get the page title and page url
		String title2 = Driver.switchTo().window(allwinid.get(2)).getTitle();
		System.out.println(title2);
		String pageurl2 = Driver.getCurrentUrl();
		System.out.println(pageurl2);
		Thread.sleep(2000); 
		
		//switch to Rail Dristi window and get the page title and url
		String title3 = Driver.switchTo().window(allwinid.get(3)).getTitle();
		System.out.println(title3);
		String pageurl3 = Driver.getCurrentUrl();
		System.out.println(pageurl3);
		String dristiid = Driver.getWindowHandle();
		System.out.println("Rail drishti window id is = "+dristiid);
		Thread.sleep(2000); 
		
//		//Scroll the window
//		ac.scrollByAmount(0, 3000).perform();
//		Thread.sleep(2000); 
//		//click on the Retiring room booking link
//		Driver.findElement(By.xpath("//*[contains(text(),'Retiring Room Booking')]")).click();
//		Thread.sleep(2000);
//		//Handling alert
//		String alert = Driver.switchTo().alert().getText();
//		System.out.println(alert);
//		Driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		Set<String>wd = Driver.getWindowHandles();
		List<String> wd1 = new ArrayList(wd);
		System.out.println(wd1);
		
		/*
		 * for (String child : wd1) {
		 * 
		 * //Parent id should not equal to child window if (!dristiid.equals(child)) {
		 * 
		 * Driver.switchTo().window(child); Thread.sleep(2000);
		 * Driver.findElement(By.xpath("//*[@id = 'reload-button']")).click();
		 * Thread.sleep(2000); String url = Driver.getCurrentUrl();
		 * System.out.println(url); String pagetitle = Driver.getTitle();
		 * System.out.println("page title is = " +pagetitle); } }
		 */
		Thread.sleep(3000);
//		Iterator<String> I = wd1.iterator();
//		while (I.hasNext()) 
//		{
//		
//			Driver.switchTo().window(I.next());
//			String titles = Driver.getTitle();
//			System.out.println(titles);
//			Thread.sleep(3000);
//			
//			String childtitle = "IRCTC Tourism Official Website | Incredible India Travel & Tour Package";
//			if (titles.contains(childtitle)) 
//			{
//			
//				Thread.sleep(3000);
//				Driver.switchTo().window(childtitle);
//				Thread.sleep(2000);
//				Driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
//			}
//		}
		
		
		
		
		
		 if (SwitchToRightWindow("IRCTC Tourism Official Website | Incredible India Travel & Tour Package",wd1)) 
		 {
		      System.out.println(Driver.getTitle()); 
		 }
		 
				
		//switch to recently opened browser
//		String title4 = Driver.switchTo().window(allwinid.get(4)).getTitle();
//		System.out.println(title4); 
//		String pageurl4 = Driver.getCurrentUrl();
//		System.out.println(pageurl4);
//		Driver.close();
		
		//Now close the browser one by one
		
		//span[contains(text(),'This site can’t be reached')] 
		
		//Driver.switchTo().window(Driver.findElement(By.xpath("")));
		
	}
	 public static boolean SwitchToRightWindow(String stitle,List<String>wd1) throws InterruptedException
	  
	 {
	 
	 for(String sw:wd1) {
	 
	  String webpagetitle = Driver.switchTo().window(sw).getTitle();
	 
	 if (webpagetitle.contains(stitle)) 
	 {
	 
	 // Driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
	 System.out.println("found the right window"); 
	 return true; 
	 }
	  
	 }Thread.sleep(3000); 
	 return false; 
	 }
	 

	
	
	
	
}
