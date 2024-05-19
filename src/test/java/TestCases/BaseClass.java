package TestCases;
import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	
	import org.testng.annotations.BeforeTest;

	import Utility.ReadPropertyFile;

	public class BaseClass {
		public static WebDriver driver;
		public static Logger logger;
		@BeforeTest
		public void LaunchBrowser() throws InterruptedException {
			ReadPropertyFile file =new ReadPropertyFile();
			
			String Urll=file.getBaseUrl();
			driver=new ChromeDriver ();
			driver.manage().window().maximize();
			driver.get(Urll);
			logger = LogManager.getLogger(BaseClass.class.getName());
			
			Thread.sleep(2000);
		}
		
		

}
