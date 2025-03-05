package Excel_Operation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Specific_Row {

	public static void main(String[] args) throws IOException 
	{
		//Read data from excel
		FileInputStream fis = new FileInputStream("C://Users//pc//Desktop//Book1.xlsx");
				
		//get workbook from excel
		XSSFWorkbook wb = new XSSFWorkbook(fis);
				
		//get sheet from excel
		XSSFSheet sh = wb.getSheet("login");
		
		//get 2nd row first coloumn
		int rc = sh.getLastRowNum();
		System.out.println(rc);
		 
		//print second row and first coloumn
		String cell1 = sh.getRow(1).getCell(0).getStringCellValue();
		System.out.println(cell1);
		
		//print second row and second coloumn data
		String cell2 = sh.getRow(1).getCell(1).getStringCellValue();
		System.out.println(cell2);
		

	}

}
