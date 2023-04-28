package utilityPackage;

import java.io.File;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports 
{

	public static com.aventstack.extentreports.ExtentReports reportSetUp(String reportName,String testName)
	{
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"ExtentReports"+File.separator+reportName+".html");
		htmlreporter.config().setDocumentTitle(reportName);
		htmlreporter.config().setReportName(testName);
		htmlreporter.config().setTheme(Theme.DARK);
		
		com.aventstack.extentreports.ExtentReports ext =new com.aventstack.extentreports.ExtentReports();
		ext.attachReporter(htmlreporter);
		ext.setSystemInfo("Tester", "Rishikesh");
		ext.setSystemInfo("Site", "OrangeHRM");
		
		return ext;
		
	}
}
