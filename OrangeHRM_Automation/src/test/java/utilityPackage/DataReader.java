package utilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataReader 
{

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
