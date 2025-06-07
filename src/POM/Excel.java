package POM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel {

	static WebDriver driver;
	static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	static XSSFRow r;
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
		
		
		
		// fis = new FileInputStream("C:\\Automation Programme\\data.xlsx");
		 fis = new FileInputStream("C:\\Automation Programme\\Automation_Project\\src\\POM\\data.xlsx");
		 wb = new XSSFWorkbook(fis);
		 sh = wb.getSheet("login");
		 
		 //get first row
		 r = sh.getRow(0);
		 
		 //count no of rows in sheet 
		int rc = sh.getLastRowNum();
		
		//count no of cell in sheet
		int cc = r.getLastCellNum();
		
		System.out.println("no of rows  are=" +rc);
		System.out.println("no of coloumns are=" +cc);
		
		//GET username and password
//		for (int i = 0; i <= rc; i++) 
//		{
//		
//			String username = sh.getRow(i).getCell(0).getStringCellValue();
//			System.out.println(username);
//			String password = sh.getRow(i).getCell(1).getStringCellValue();
//			System.out.println(password);
//		}
		
		//we will not aapply loop here simply taking only one row value
		String username = sh.getRow(1).getCell(0).getStringCellValue();
		System.out.println(username);
		String password = sh.getRow(1).getCell(1).getStringCellValue();
		System.out.println(password);
		
		driver = new ChromeDriver();
		driver.get("https://orangehrm.qedgetech.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}

}
