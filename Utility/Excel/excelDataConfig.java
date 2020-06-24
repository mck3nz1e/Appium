package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet Sheet1;
	
	public excelDataConfig(String ExcelPath) {
		
		try {
			
			File src =new File(ExcelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
						
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
	}
	
	public String getData(int SheetNumber, int row, int column) {
		
		Sheet1 = wb.getSheetAt(SheetNumber);
		String data = Sheet1.getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	
	public double getDataNumber(int SheetNumber, int row, int column) {
		
		Sheet1 = wb.getSheetAt(SheetNumber);
		double data = Sheet1.getRow(row).getCell(column).getNumericCellValue();
		
		return data;
				
	}
	
	public String WriteData(String ExcelPath, int SheetNumber, int row, int column, String CellValue) throws IOException {
					
		Sheet1 = wb.getSheetAt(SheetNumber);
		XSSFCell cell = Sheet1.getRow(row).createCell(column);
		cell.setCellValue(CellValue);
		FileOutputStream fos = new FileOutputStream(ExcelPath);
		wb.write(fos);
		wb.close();

		return CellValue;
		
	}
}


