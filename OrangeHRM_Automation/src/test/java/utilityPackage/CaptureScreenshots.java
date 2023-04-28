package utilityPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshots 

{
	
	public static String capturePageScreenshot(WebDriver driver) throws IOException 
	{
		String path= System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"Screenshots"+File.separator+System.currentTimeMillis()+".png";
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File destn = new File(path);
		FileHandler.copy(source, destn);
		return path;
	}


}
