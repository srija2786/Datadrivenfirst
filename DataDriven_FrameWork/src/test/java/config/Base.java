package config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import applicationLayer.AdminLogin;
import applicationLayer.AdminLogout;

public class Base {
	public static WebDriver driver;
	@BeforeTest
	public static void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AdminLogin verifyLogin=PageFactory.initElements(driver, AdminLogin.class);
		verifyLogin.login("Admin", "Qedge123!@#");
		
	}
	@AfterTest
	public static void tearDown() throws Throwable {
		AdminLogout verifyLgout=PageFactory.initElements(driver, AdminLogout.class);
		verifyLgout.logout();
		driver.quit();
	}
}
