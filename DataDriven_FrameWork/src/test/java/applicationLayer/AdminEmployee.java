package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AdminEmployee {
	//define repository
		@FindBy(xpath = "//b[normalize-space()='PIM']")
		WebElement clickPim;
		@FindBy(xpath = "//input[@id='btnAdd']")
		WebElement clickAdd;
		@FindBy(xpath = "//input[@id='firstName']")
		WebElement FirstName;
		@FindBy(xpath = "//input[@id='middleName']")
		WebElement MiddleName;
		@FindBy(xpath = "//input[@id='lastName']")
		WebElement LastName;
		@FindBy(xpath = "//input[@id='employeeId']")
		WebElement Empid;
		@FindBy(xpath = "//input[@id='btnSave']")
		WebElement clicksave;
		@FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
		WebElement CaptureEID;
		public boolean addEmp(String fname,String mname,String lname)throws Throwable
		{
			clickPim.click();
			Thread.sleep(2000);
			clickAdd.click();
			Thread.sleep(2000);
			FirstName.sendKeys(fname);
			MiddleName.sendKeys(mname);
			LastName.sendKeys(lname);
			String Exp_Data =Empid.getAttribute("value");
			clicksave.click();
			Thread.sleep(2000);
			String Act_Data =CaptureEID.getAttribute("value");
			if(Act_Data.equals(Exp_Data))
			{
				
				Reporter.log(Exp_Data+"       "+Act_Data,true);
				return true;
			}
			else
			{
				Reporter.log(Exp_Data+"       "+Act_Data,true);
				return false;
			}
			
			
		}
}
