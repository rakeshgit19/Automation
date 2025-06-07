package TestAction;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Google.Login;
import Google.Logout;

public class Orange1 
{

	  WebDriver driver;
	  Actions ac;
	  String path = "C:\\Automation Programme\\Automation_Project\\src\\Testdata\\drive.xlsx";
	  FileInputStream fis ;
	  XSSFWorkbook wb;
	  XSSFSheet sh;
	  XSSFRow r;
	  int rc;
	  int cc;
	  String urname;
	  String psword;
	 
	 
	 
	 
	@BeforeTest
	public void lunch() throws InterruptedException
	{
	    driver =  new org.openqa.selenium.chrome.ChromeDriver();
		driver.get("https://orangehrm.qedgetech.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}
	
	@Test
	public void login() throws InterruptedException, IOException
	{
		   fis = new FileInputStream(path);
		   wb = new XSSFWorkbook(fis);
		   sh = wb.getSheet("Sheet1");
		   r = sh.getRow(0);
		  //count no of rows in sheet 
		   rc = sh.getLastRowNum();
		  System.out.println("No of rows are=" +rc); 
		  
		  //count no of cell in sheet
		   cc = r.getLastCellNum();
		  System.out.println("No of columns are=" +cc);
		
		    urname = sh.getRow(1).getCell(0).getStringCellValue();
			System.out.println(urname);
			 psword = sh.getRow(1).getCell(1).getStringCellValue();
			System.out.println(psword);
		
		Login log = PageFactory.initElements(driver, Login.class);
		log.AdminLogin(urname,psword );
		Thread.sleep(2000);
	}
		
	@AfterTest
	public void logout() throws InterruptedException
	{
		Logout lo = PageFactory.initElements(driver, Logout.class);
		lo.pageLogout();
		Thread.sleep(2000);
		driver.close();
		
}
}
