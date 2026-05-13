package api.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static Workbook wb;
	public static FileInputStream file;
	public static DataFormatter formatter;
	
	public static Object[][] getExcelData(String path, String sheetName) {
		
		try {
			file=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb=new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet=wb.getSheet(sheetName);
		int row=sheet.getPhysicalNumberOfRows();
		int col=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data=new Object[row-1][col];
		
		for(int i=1;i<row; i++){
			Row rows=sheet.getRow(i);
			
			for(int j=0;j<col;j++) {
				Cell cell=rows.getCell(j);
				formatter = new DataFormatter();
				data[i-1][j]=formatter.formatCellValue(cell);
			}
		}
		try {
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	
	}
	
	public static Object[][] getUserNames(String path, String sheetName) {

        try {

            file = new FileInputStream(path);
            wb = new XSSFWorkbook(file);

            Sheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();

            // only 1 column
            Object[][] data = new Object[rows - 1][1];

            formatter = new DataFormatter();

            for (int i = 1; i < rows; i++) {

                Row row = sheet.getRow(i);

                // username column index = 1
                Cell cell = row.getCell(1);

                data[i - 1][0] = formatter.formatCellValue(cell);
            }

            wb.close();
            file.close();

            return data;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}
