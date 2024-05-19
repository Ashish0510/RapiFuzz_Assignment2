package Utility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCases.BaseClass;

public class ListenerClass extends BaseClass implements ITestListener{
	ExtentSparkReporter htmlReporter;
	ExtentReports reporters;
	ExtentTest test;

	public void config() {

		File file = new File("./AllExtentReports/ExtentReport");
		htmlReporter = new ExtentSparkReporter(file);
		reporters = new ExtentReports();
		reporters.attachReporter(htmlReporter);

		// adding environment information
		reporters.setSystemInfo("Machine", "Hp");
		reporters.setSystemInfo("Os", "window 11");
		reporters.setSystemInfo("Browser", "Chrome");
		reporters.setSystemInfo("Implemented By", "QA");
		reporters.setSystemInfo("Username", "Ashish");

		// changing the report look and feel
		htmlReporter.config().setDocumentTitle("Erail Automation");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Erail Inbox");

	}

	public void onStart(ITestContext result) {
		config();

	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		test = reporters.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("The " + result.getName() + " is passed", ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult result) {
		test = reporters.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("The " + result.getName() + " is failed", ExtentColor.RED));

	
			ScreenshotUtility t1 = new ScreenshotUtility();
				try {
					t1.takeScrenshot(driver);;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
	}

	public void onTestSkipped(ITestResult result) {
		test = reporters.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("The " + result.getName() + " is skipped", ExtentColor.ORANGE));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onFinish(ITestContext context) {
		reporters.flush();

	}


}
