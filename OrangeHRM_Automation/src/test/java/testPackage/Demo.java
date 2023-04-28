package testPackage;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo 
{
	public static void main(String[] args) {
		
		
		String path= System.getProperty("user.dir")+File.separator+"src\\test\\resources"+File.separator+"Browser"+File.separator+"chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	
	} 
}
