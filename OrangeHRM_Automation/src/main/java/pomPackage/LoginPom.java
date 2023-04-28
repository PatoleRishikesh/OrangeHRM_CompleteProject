package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPom 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@placeholder='Username']") private WebElement userName ;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginBtn;
	
	
	public LoginPom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait	= new WebDriverWait (driver,Duration.ofSeconds(10));
	}
	
	public void enterUserName(String name)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		userName.sendKeys(name);
	}
	
	public void enterPassword(String pwd)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		loginBtn.click();
	}
}
