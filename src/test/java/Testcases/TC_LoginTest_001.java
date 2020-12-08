package Testcases;
import java.lang.System.Logger;

import org.testng.annotations.Test;

import pageObjects.pageObjectsLoginPage;

public class TC_LoginTest_001 extends BaseClass
{	@Test
	public void loginTest()	{
	
	
	driver.get(baseURL);
	logger.info("open URL");
		pageObjectsLoginPage pg1=new pageObjectsLoginPage(driver);
		driver.manage().window().maximize();
	pg1.setUserName(username);
	logger.info("enter username");
	pg1.setPassword(password);
	logger.info("enter password");
	pg1.clickSubmit();
	logger.info("click on login button");
		
	}
}
