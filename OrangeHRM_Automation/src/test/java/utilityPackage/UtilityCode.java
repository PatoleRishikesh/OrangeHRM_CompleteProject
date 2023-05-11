package utilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityCode 
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
	
	
	public String readData(int row,int cell, String sheetName) throws EncryptedDocumentException, IOException
	{
		String cellValue= "";
		String path = System.getProperty("user.dir")+File.separator+"src\\test\\resources\\TestData\\TestData.xlsx";
		
		FileInputStream file= new FileInputStream(path);
		
		Sheet s = WorkbookFactory.create(file).getSheet(sheetName);
		
		Cell c= s.getRow(row).getCell(cell);
		
		CellType type = c.getCellType();
		
		if(type==CellType.STRING)
			{
				cellValue =c.getStringCellValue();
			}
		else if (type == CellType.NUMERIC)
			{
				double data = c.getNumericCellValue();
				cellValue= Double.toString(data);
			}
	
		return cellValue;
			
	}
}
