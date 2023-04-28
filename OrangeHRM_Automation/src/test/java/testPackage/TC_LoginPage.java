package testPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomPackage.LoginPom;
import utilityPackage.CaptureScreenshots;
import utilityPackage.DataReader;
import utilityPackage.LaunchBrowser;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TC_LoginPage 
{
	public WebDriver driver;
	LoginPom login; 
	DataReader data;
	String url="https://opensource-demo.orangehrmlive.com/";
	
	
	@BeforeClass
	  public void setUp() 
	 {
		 driver=LaunchBrowser.OpenBrowser("chrome");
		 driver.navigate().to(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 }

	@BeforeMethod
	  public void objectInit() 
	{
		login = new LoginPom(driver);
		data = new DataReader();
	}
  

	@Test
  	public void userLogin() throws EncryptedDocumentException, IOException 
	{
		
	login.enterUserName(data.readData(1, 0, "Sheet1"));
	login.enterPassword(data.readData(0, 1, "Sheet1"));
	login.clickLogin();
	
	}
 
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("Test Case Passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			CaptureScreenshots.capturePageScreenshot(driver);
			System.out.println("Test Case Failed");
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			CaptureScreenshots.capturePageScreenshot(driver);
			System.out.println("Test Case skipped");
		}
	}

  

@AfterClass
  public void tearDown() 
  {
	  driver.quit();
  }

}
