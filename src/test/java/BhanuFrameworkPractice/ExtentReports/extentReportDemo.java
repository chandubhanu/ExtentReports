package BhanuFrameworkPractice.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extentReportDemo {
	ExtentReports extent;
@BeforeTest
public void config() {
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
reporter.config().setReportName("WebAutomationResults");
reporter.config().setDocumentTitle("TestResults");
 extent=new ExtentReports();
extent.attachReporter(reporter);
extent.setSystemInfo("Tester", "Bhanu");
}
	@Test
	public void initialDemo() {
		ExtentTest test=extent.createTest("Intial Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		test.fail("Log in do not match");
		extent.flush();
	}
}
