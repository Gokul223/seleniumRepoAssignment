package week7.day1Assign;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] ReadData(String filename, int sheetindex) throws IOException {
		XSSFWorkbook book = new  XSSFWorkbook("./dataSheet/"+filename+".xlsx");
		XSSFSheet sheetAt = book.getSheetAt(sheetindex);
		XSSFRow row = sheetAt.getRow(0);
		XSSFCell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		int rowCount = sheetAt.getLastRowNum();
		System.out.println("row count : " + rowCount);
		int colCount = row.getLastCellNum();
		System.out.println("Column Count : " + colCount);
		String[][] data = new String [rowCount][colCount];
		for (int i = 1; i <=rowCount; i++) {				
			for (int j = 0; j <colCount; j++) {
				String eachcell = sheetAt.getRow(i).getCell(j).getStringCellValue();
				System.out.println(eachcell);
				data[i-1][j] = eachcell;
			}

		}
		book.close();
		return data;

	}
}
