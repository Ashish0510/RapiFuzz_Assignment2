package PomClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelWriter;

public class DropDown {
	WebDriver driver;

	public DropDown(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtStationFrom")
	WebElement fromElement;

	public void clickonFromField() throws InterruptedException {

		System.out.println("printing the from field");
		fromElement.click();

		Thread.sleep(2000);

		fromElement.clear();
//		
		Thread.sleep(2000);

		fromElement.sendKeys("DEL");

		Thread.sleep(5000);

		WebElement fourthStation = driver.findElement(By.xpath("(//div[@class='autocomplete'])[1]/div[5]/div[1]"));

		String selectedStation = fourthStation.getText();
		fourthStation.click();

		Thread.sleep(3000);

		System.out.println("fetching the from field text ");

		System.out.println("Selected station: " + selectedStation);

	}

	public void FetchTheStations() throws InterruptedException {

		System.out.println("printing the from field");
		fromElement.click();

		Thread.sleep(2000);

		fromElement.clear();
//		
		Thread.sleep(2000);

		fromElement.sendKeys("DEL");

		List<WebElement> RealStation = driver.findElements(By.xpath("(//div[@class='autocomplete'])[1]/div/div[1]"));
		List<String> excelData = new ArrayList<>();
		for (WebElement ele : RealStation) {
			// ele.getText();
			System.out.println(ele.getText());

			excelData.add(ele.getText());

		}

		ExcelWriter writer = new ExcelWriter();
		ExcelWriter.writeToExcel(excelData, "./TestData/RealStation.xlsx");
		
       
		Thread.sleep(3000);
		WebElement fourthStation = driver.findElement(By.xpath("(//div[@class='autocomplete'])[1]/div[5]/div[1]"));
		fourthStation.click();
		
		Thread.sleep(3000);
		
	}
}
