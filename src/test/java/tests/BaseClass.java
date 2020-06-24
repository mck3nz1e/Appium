package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() {

		try {

			reporter = new ExtentHtmlReporter("./Reports/ExtentReport1.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);

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

}
