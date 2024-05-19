package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class compareExcelFile {
	
	public void ComparingExcel() {
	
	try {
        FileInputStream file1 = new FileInputStream("./TestData/RealStation.xlsx");
        FileInputStream file2 = new FileInputStream("./TestData/ExpectedStation.xlsx");
        Workbook workbook1 = WorkbookFactory.create(file1);
        Workbook workbook2 = WorkbookFactory.create(file2);
        Sheet sheet1 = workbook1.getSheetAt(0);
        Sheet sheet2 = workbook2.getSheetAt(0);

        int rows1 = sheet1.getPhysicalNumberOfRows();
        int rows2 = sheet2.getPhysicalNumberOfRows();

        for (int i = 0; i < Math.max(rows1, rows2); i++) {
            Row row1 = sheet1.getRow(i);
            Row row2 = sheet2.getRow(i);
            if (row1 == null || row2 == null) {
                // Handle null rows
                continue;
            }
            int cells1 = row1.getPhysicalNumberOfCells();
            int cells2 = row2.getPhysicalNumberOfCells();
            for (int j = 0; j < Math.max(cells1, cells2); j++) {
                Cell cell1 = row1.getCell(j);
                Cell cell2 = row2.getCell(j);
                if (cell1 == null || cell2 == null) {
                    // Handle null cells
                    continue;
                }
                String value1 = cell1.getStringCellValue();
                String value2 = cell2.getStringCellValue();
                if (!value1.equals(value2)) {
                    System.out.println("Difference found at row " + (i + 1) + ", column " + (j + 1));
                    System.out.println("File 1: " + value1);
                    System.out.println("File 2: " + value2);
                }
            }
        }
        file1.close();
        file2.close();
        workbook1.close();
        workbook2.close();
    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
