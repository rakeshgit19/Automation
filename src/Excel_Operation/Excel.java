package Excel_Operation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException 
	{
		//Read data from excel
		FileInputStream fis = new FileInputStream("C://Users//pc//Desktop//Book1.xlsx");
		
		//get workbook from excel
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		//get sheet from excel
		XSSFSheet sh = wb.getSheet("login");
		
		//get first row from sheet
		XSSFRow r = sh.getRow(0);
		
		//count number of rows in sheet
		int rowcount = sh.getLastRowNum();
		System.out.println(rowcount);
		
		//count number of coloumns in sheet
		int cellcount = r.getLastCellNum();
		System.out.println(cellcount);
		
		fis.close();
		wb.close();

	}

}
