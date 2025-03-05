package com.pack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeDriver {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException 
	{
		
	    WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
	    //WebDriver driver = new FirefoxDriver();
	    //lunching url
		driver.get("https://orangehrm.qedgetech.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("")).click();
		
		//get page title of the page
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		
		//get current url of the page
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
//		//string page sourcecode of the page
//		String sourcecode = driver.getPageSource();
//	    System.out.println(sourcecode);
//	    //length of the source code
//	    System.out.println(sourcecode.length());
		
		String expval = "orangehrm";
		//String actual = "https://orangehrm.qedgetech.com/symfony/web/index.php/dashboard";
		String actual = driver.findElement(By.xpath("//*[contains(text(),'Directory')]")).getText();
		System.out.println(actual);
		
		if (actual.contains(expval)) {
			
			System.out.println("pager loaded correctly");
			
		}
		else {
			System.out.println("page loaded incorrectly");   
		}
		
		Thread.sleep(3000);
		
		

	} 

}
