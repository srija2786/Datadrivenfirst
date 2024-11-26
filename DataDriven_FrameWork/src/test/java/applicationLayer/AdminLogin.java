package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
	//define Repository
		@FindBy(name="txtUsername")
		WebElement Objuser;
		@FindBy(xpath = "//input[@id='txtPassword']")
		WebElement Objpass;
		@FindBy(id="btnLogin")
		WebElement ObjLogin;
		//write method for  login
		public void login(String user,String pass)
		{
			Objuser.sendKeys(user);
			Objpass.sendKeys(pass);
			ObjLogin.click();
		}
}
