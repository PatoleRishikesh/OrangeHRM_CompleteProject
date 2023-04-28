package testPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

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
	ExtentReports ext;
	ExtentTest test;
	
	@BeforeClass
	  public void setUp() 
	 {
		ext= utilityPackage.ExtentReports.reportSetUp("Automation Report", "LoginPage"); 
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
	test = ext.createTest("Valid UserLogin");	
	login.enterUserName(data.readData(1, 0, "Sheet1"));
	login.enterPassword(data.readData(1, 2, "Sheet1"));
	login.clickLogin();
	
	}
 
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Case Passes"+result.getStatus());
			System.out.println("Test Case Passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
						
			test.log(Status.FAIL, "Test Case Failed"+result.getStatus());
			test.log(Status.FAIL, result.getTestName()+" Failure Exception : "+result.getThrowable());
			System.out.println("Test Case Failed");
			test.addScreenCaptureFromPath(utilityPackage.CaptureScreenshots.capturePageScreenshot(driver));
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			CaptureScreenshots.capturePageScreenshot(driver);
			test.log(Status.FAIL, "Test Case Skipped"+result.getStatus());
			test.log(Status.FAIL, result.getTestName()+" Skipped Exception : "+result.getThrowable());
			System.out.println("Test Case skipped");
		}
	}

  

@AfterClass
  public void tearDown() 
  {
	  driver.quit();
	  ext.flush();
  }

}
