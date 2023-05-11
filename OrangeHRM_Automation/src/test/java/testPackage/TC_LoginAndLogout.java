package testPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomPackage.LoginPom;
import pomPackage.LogoutPOM;
import utilityPackage.LaunchBrowser;
import utilityPackage.UtilityCode;

public class TC_LoginAndLogout 
{
	WebDriver driver;
	UtilityCode uCode;
	LoginPom loginPage;
	LogoutPOM logoutPage;
	
	@BeforeClass
	public void setup()
	{
		driver= LaunchBrowser.OpenBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@BeforeMethod
	public void initObject()
	{
		uCode= new UtilityCode();
		loginPage= new LoginPom(driver);
		logoutPage= new LogoutPOM(driver);
	}
	
	@Test (priority=0)
	public void loginTest() throws EncryptedDocumentException, IOException
	{
		loginPage.enterUserName(uCode.readData(1, 0, "Sheet1"));
		loginPage.enterPassword(uCode.readData(1, 1, "Sheet1"));
		loginPage.clickLogin();
		
	}
	
	@Test(priority = 1)
	public void logoutTest()
	{
		logoutPage.clickLogout();
	}
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
}
