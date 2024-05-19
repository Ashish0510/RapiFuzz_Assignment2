package TestCases;

import java.util.List;

import org.testng.annotations.Test;

import PomClasses.DropDown;
import PomClasses.Timedropdown;
import Utility.ExcelWriter;
import Utility.compareExcelFile;

public class AllTestClasses extends BaseClass {
	
	
	@Test(priority = 1)
	
	public void TestCase1() throws InterruptedException {
		DropDown dpDown=new DropDown( driver);
		
		dpDown.clickonFromField();
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 2)
	public void towriteinExcel() {
		 List<String> dataList = List.of("Denduluru", "Delang", "Delhi","Delhi Azadpur","Delhi Cantt");
		 ExcelWriter writer=new ExcelWriter();
		  ExcelWriter.writeToExcel(dataList, "./TestData/ExpectedStation.xlsx");
	}
	
	
	@Test(priority = 3)
	public void toComapreTheExcelFile() throws InterruptedException{
		
		DropDown dpDown=new DropDown(driver);
		
		dpDown.FetchTheStations();
		compareExcelFile excelFile=new compareExcelFile();
		excelFile.ComparingExcel();
		
	}
	
	@Test(priority = 4)
	public void selectTheDate() {
		Timedropdown tdTimedropdown=new Timedropdown(driver);
		
		tdTimedropdown.dateSelection();
	}
}
