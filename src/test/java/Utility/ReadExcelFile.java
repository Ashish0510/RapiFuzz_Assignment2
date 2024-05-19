package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import TestCases.BaseClass;

public class ReadExcelFile extends BaseClass{
	public String[][] getcellvalue(File file3) throws InterruptedException, IOException{
		//logger.info(file3);
	//	logger.info("Excel file is execution started");
		/*FileInputStream file= new FileInputStream(file3);
		logger.info("fetched the file from All Data provider class");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheetAt(0);*/
		
		 FileInputStream fis = new FileInputStream(file3);
		 logger.info("fetched the file from All Data provider class");
         // Create a Workbook instance for Excel file
         Workbook workbook = WorkbookFactory.create(fis);

         logger.info(" Get the first sheet from the workbook");
         Sheet sheet = workbook.getSheetAt(0); // You can change the index as needed

		
		
		int ttlrow=sheet.getLastRowNum()+1;
		System.out.println(ttlrow);
		
		int ttlcolumn=sheet.getRow(0).getLastCellNum();
		System.out.println(ttlcolumn);
		DataFormatter formatter=new DataFormatter();
		
		
		 String a[][] = new String[ttlrow-1][ttlcolumn];
		
		 int i;
		 int j;
		
		for( i=1;i<ttlrow;i++) {
			Thread.sleep(2000);
			
			for ( j=0;j<ttlcolumn;j++) {
				
				
				a[i-1][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
			logger.info("Excel file is execution completed");
			}
		return a;
	
		}
	

}
