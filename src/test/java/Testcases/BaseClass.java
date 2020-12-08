package Testcases;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import generalUtilities.ReadPropertiesFile;

public class BaseClass {
	public static ReadPropertiesFile rpf= new ReadPropertiesFile();
public static WebDriver driver;

String baseURL=rpf.getApplicationURL();
public String username=rpf.getUsername();
public String password=rpf.getPassword();
public static  Logger logger;
@Parameters("browser")
@BeforeClass
public static void OpenHomePage(String br)
{
	  logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome"))
		{
	System.setProperty("webdriver.chrome.driver",rpf.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
				{
			System.setProperty("webdriver.gecko.driver",rpf.getFirefoxPath());
			driver= new FirefoxDriver();
				}
		else if(br.equals("ie"))
		{
	System.setProperty("webdriver.ie.driver",rpf.getIEPath());
	driver= new InternetExplorerDriver();
}
driver.get(rpf.getApplicationURL());
}
@AfterClass
public void tearDown()
{
	driver.quit();
}
}
