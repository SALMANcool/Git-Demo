package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generalUtilities.XLUtilities;
import pageObjects.pageObjectsLoginPage;

public class TC002_DDF_loginTest extends BaseClass
{
	
	@Test(dataProvider="Login Data")
	public void getData(String uname,String pwd)
	{
		pageObjectsLoginPage pg=new pageObjectsLoginPage(driver);
		pg.setUserName(uname);
		pg.setPassword(pwd);
		pg.clickSubmit();
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			pg.lnkLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@DataProvider(name="Login Data")
public String[][] getCellData() throws IOException
{
		String filePath=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
	//String filePath= "C:\\Users\\salman\\workspace\\portal\\Data\\TestDatasheet.xlsx";
	XLUtilities xl=new XLUtilities();
	int rowCount=xl.getRowCount(filePath, "sheet1");
	int colCount = xl.getCellCount(filePath, "Sheet1", rowCount);
	String [][] cellValue=new String[rowCount][colCount];	
	for (int i = 1; i < rowCount; i++) 
	{
	for(int j=0;j<colCount;j++)
	{
		cellValue[i-1][j] = xl.getCellData(filePath, "Sheet1", i, j);
	}
	}
return cellValue;
}
}
