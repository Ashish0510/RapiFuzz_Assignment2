package Utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ListOfStringExcelWrite {
	
	public static void writeToExcel(List<String[]> data, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Data");

            int rowNum = 0;
            for (String[] rowData : data) {
            	Row row = sheet.createRow(rowNum++);
              //  Cell cell = row.createCell(0); // Create cells in the first column
               // cell.setCellValue(rowData);
            }

            // Write the workbook to a file
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}
