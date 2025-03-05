package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserCreation 
{
	WebDriver driver;
	Select s;
	//Actions ac;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement Adminmodule;
	
	@FindBy(id="btnAdd")
	WebElement buttonAdd;
	
	@FindBy(id="systemUser_userType")
	WebElement userRole;
	
	@FindBy(id="systemUser_employeeName_empName")
	WebElement employeeName;
	
	@FindBy(id="systemUser_userName")
	WebElement username;
	
	@FindBy(id="systemUser_status")
	WebElement userStatus;
	
	@FindBy(id="systemUser_password")
	WebElement password;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id="btnSave")
	WebElement save;
	
	public void userCreation(String userrole,String empname,String uname,String enable,String passw,String cpass) throws InterruptedException
	{
//		ac = new Actions(driver);
//		ac.moveToElement(Adminmodule).click().perform();
//		ac.moveToElement(buttonAdd).click().perform();
		
		Adminmodule.click();
		Thread.sleep(1000);
		buttonAdd.click();
		Thread.sleep(1000);
		
		s = new Select(userRole);
		s.selectByVisibleText(userrole);
		Thread.sleep(1000);
		
		employeeName.sendKeys(empname);
		username.sendKeys(uname);
		Thread.sleep(1000);
		
		s = new Select(userStatus);
		s.selectByVisibleText(enable);
		Thread.sleep(1000);
		
		password.sendKeys(passw);
		confirmPassword.sendKeys(cpass);
		Thread.sleep(1000);
		save.click();
	}

}
