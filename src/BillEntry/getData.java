package BillEntry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getData {
	
	public static String[][] readExcel(String fileName, String sheetName) throws IOException{		
		File file = new File("C:\\Selenium8\\TestData3.xlsx");	
		FileInputStream ips = new FileInputStream(file);
		
		Workbook Wb = new XSSFWorkbook(ips);
		Sheet Sh = Wb.getSheet(sheetName);
		
		
		int rowNum =Sh.getLastRowNum() + 1;		
		int colNum = Sh.getRow(0).getLastCellNum();		
		String[][] data = new String[rowNum][colNum];		
		
		for (int i=0; i< rowNum; i++){	
			System.out.println("i:"+i);
			Row row = Sh.getRow(i);	
		
			for( int j =0; j < colNum; j++){
				System.out.println("j:"+j);
				String value = row.getCell(j).getStringCellValue();	
					data[i][j] = value;	
}		
}
		return data;		


	}
}
