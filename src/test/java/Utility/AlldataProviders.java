package Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import TestCases.BaseClass;

public class AlldataProviders extends BaseClass {
	
	
	@DataProvider(name="logindetails")
	public String[][] logindetails() throws InterruptedException, IOException {
		
		logger.info("All Data provider is running");
		ReadExcelFile excelFile=new ReadExcelFile();
		File file=new File("./TestData/organgeExcel.xlsx");
		logger.info("All Data provider has completed");
		return excelFile.getcellvalue(file);
	}
	//./TestData/OrangeExcel1.xlsx

	@DataProvider(name="wronglogindetails")
	public String[][] Wronglogindetails() throws InterruptedException, IOException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"txtUsername\"]")));
		logger.info("All Data provider is running");
		ReadExcelFile excelFile=new ReadExcelFile();
		File file=new File("./TestData/OrangeExcel1.xlsx");
		logger.info("All Data provider has completed");
		return excelFile.getcellvalue(file);
	}

}
