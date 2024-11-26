package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import applicationLayer.AdminEmployee;
import config.Base;
import utilities.ExcelFileUtil;

public class AppTest extends Base{
	String inputpath ="./FileInput/employee.xlsx";
	String outputpath ="./FileOutput/DataDrivenResults.xlsx";
	@Test
	public void startTest() throws Throwable
	{
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc = xl.rowcount("EmpData");
		for(int i=1;i<=rc;i++)
		{
			String firstname = xl.getCellData("EmpData", i, 0);
			String middlename = xl.getCellData("EmpData", i, 1);
			String lastname = xl.getCellData("EmpData", i, 2);
			AdminEmployee emp = PageFactory.initElements(driver, AdminEmployee.class);
			boolean res =emp.addEmp(firstname, middlename, lastname);
			if(res)
			{
				xl.setCellData("EmpData", i, 3, "pass", outputpath);
			}
			else
			{
				
				xl.setCellData("EmpData", i, 3, "fail", outputpath);
			}
		}
		
	}
}
