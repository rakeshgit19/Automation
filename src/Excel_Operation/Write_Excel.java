package Excel_Operation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Excel {

	public static void main(String[] args) throws IOException 
	{
		//Read data from excel
		FileInputStream fis = new FileInputStream("C://Users//pc//Desktop//Book1.xlsx");
								
		//get workbook from excel
		XSSFWorkbook wb = new XSSFWorkbook(fis);
								
		//get sheet from excel
		XSSFSheet sh = wb.getSheet("login");
		
		//write some text to excel
		sh.getRow(1).createCell(2).setCellValue("pass");
		
		//writing into the same result coloumn
		FileOutputStream fos = new FileOutputStream("C://Users//pc//Desktop//Book1.xlsx");
		wb.write(fos);
		fos.close();
		wb.close();



	}

}
