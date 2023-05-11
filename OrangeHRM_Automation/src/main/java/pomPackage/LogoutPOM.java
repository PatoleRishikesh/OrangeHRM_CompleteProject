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

public class LogoutPOM 
{
	WebDriverWait wait;
	@FindBy	(xpath="//p[@class='oxd-userdropdown-name']") private WebElement profileDropdown;
	@FindBy (xpath="//a[text()='About']") private WebElement about;
	@FindBy (xpath="//a[text()='Support']") private WebElement support ;
	@FindBy (xpath="//a[text()='Change Password']") private WebElement changePassword;
	@FindBy (xpath="//a[text()='Logout']") private WebElement logoutBtn;
	
	
	public LogoutPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	public void clickProfile()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-userdropdown-name']")));
		
		profileDropdown.click();
	}
	
	public void clickLogout()
	{
		profileDropdown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));
		logoutBtn.click();
	}
}