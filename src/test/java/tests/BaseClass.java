package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.collect.ImmutableMap;

import ScreenShots.screenCaptureBase64;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	AppiumDriver<MobileElement> driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;

	@BeforeSuite
	public void reportSetup() {

		// start reporters
		htmlReporter = new ExtentSparkReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setup() {

		try {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.4");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "XD");
			caps.setCapability(MobileCapabilityType.UDID, "M3VR128UDG");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//		caps.setCapability(MobileCapabilityType.APP, "");
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, caps);
//			driver = new AndroidDriver<MobileElement>(url, caps);
//			driver = new IOSDriver<MobileElement>(url, caps);

		} catch (Exception e) {
			System.out.println("Cause is: " + e.getCause());
			System.out.println("Error message is: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterTest
	public void teardown() {

		driver.quit();
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {

			test.info(MarkupHelper.createLabel(result.getName() + "Test Case Failed", ExtentColor.RED));
			Thread.sleep(1000);
			String temp = screenCaptureBase64.CaptureScreenShot64(driver);
			test.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(temp).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.info(MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.GREEN));
		}

		else {

			test.skip(MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}

		extent.flush();
		driver.close();
	}

	@AfterSuite
	public void reportTeardown() {

		extent.flush();
	}
}
