package POM;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EmployeeCreation 
{
	WebDriver driver;
	Actions ac;

	   @FindBy(id="menu_pim_viewPimModule")
	   WebElement pim;
	  
	   @FindBy(id="btnAdd")
	   WebElement addbutton;
	  
	   @FindBy(id="firstName")
	   WebElement firstname;
	  
	   @FindBy(id="middleName")
	   WebElement middlename;
	  
	   @FindBy(id="lastName")
	   WebElement lastname;
	  
	   @FindBy(id="employeeId")
	   WebElement employeeid;
	   
	   @FindBy(id="btnSave")
	   WebElement save;
	  
	   public void employeeCreation(String fname,String mname,String lname,String empid) throws InterruptedException
	   {
		   Thread.sleep(1000);
		   pim.click();
		   Thread.sleep(1000);
		   addbutton.click();;
		   Thread.sleep(1000);
		   firstname.sendKeys(fname);
		   Thread.sleep(1000);
		   middlename.sendKeys(mname);
		   Thread.sleep(1000);
		   lastname.sendKeys(lname);
		   Thread.sleep(1000);
		   employeeid.clear();
		   employeeid.sendKeys(empid);
		   save.click();
		   Thread.sleep(4000);
	   }
}
