package PomClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Timedropdown {
	WebDriver driver;

	public Timedropdown(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void dateSelection() {
		WebElement inputElement = driver.findElement(By.xpath("//td[@id=\"tdDateFromTo\"]/input"));

		String value = inputElement.getAttribute("value");

		System.out.println("Value of the input: " + value);

		DateFormat originalFormat = new SimpleDateFormat("dd-MMM-yy EEE", Locale.ENGLISH);
		Date currentDate = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.DATE, 30);
		Date futureDate = cal.getTime();
		
		DateFormat targetFormat = new SimpleDateFormat("dd-MMM-yy EEE", Locale.ENGLISH);
		String formattedFutureDate = targetFormat.format(futureDate);
		System.out.println("The future date "+formattedFutureDate);

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+formattedFutureDate+"')", inputElement);

	}

}
