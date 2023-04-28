package utilityPackage;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser 
{

static WebDriver driver;
	
	public static WebDriver OpenBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//String path= System.getProperty("user.dir")+File.separator+"src"+File.separatorChar+"test"+File.separator+"resources"+File.separator+"Browser"+File.separator+"chromedriver.exe";
			//	System.setProperty("webdriver.chroome.driver",path); 
			ChromeOptions option= new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver= new ChromeDriver(option);
		}
	/*	else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}*/
		return driver;
		
	}
	
}
