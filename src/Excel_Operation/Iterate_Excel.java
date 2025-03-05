package Excel_Operation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Iterate_Excel {

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
		
		for (int i = 0; i <= rc; i++) 
		{
		
			String second = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(second);
			String third = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(third);
		}
		fis.close();

	}

}
