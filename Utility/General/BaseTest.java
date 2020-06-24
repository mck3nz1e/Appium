/**
 * 
 */

package General;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author Scott
 *
 */

public class BaseTest {

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void SetUp() {

		reporter = new ExtentHtmlReporter("./Reports/ExtentReport1.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@AfterMethod(alwaysRun = true)
	public void GetResult(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail(MarkupHelper.createLabel(result.getName() + "Test Case Failed", ExtentColor.RED));
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {

			logger.pass(MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.GREEN));
		}

		else {

			logger.skip(MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
		}
	}

	@AfterSuite(alwaysRun = true)
	public void TearDown() {

		extent.flush();
	}
}
