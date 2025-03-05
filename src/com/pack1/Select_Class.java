package com.pack1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Select_Class {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver Driver = new ChromeDriver();
		Driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		Driver.manage().window().maximize();
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
			
			
			
 		
		



	}

}
