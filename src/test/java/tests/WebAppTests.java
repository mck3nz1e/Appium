package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import ScreenShots.screenCaptureBase64;
import pageObjects.practiceForm;

public class WebAppTests extends BaseClass {

	@Test
	public void happyPath() throws Exception {
		
		driver.get("http://www.demoqa.com/automation-practice-form");

		practiceForm objects = new practiceForm(driver);

		objects.givenName("Scott");
		objects.surname("McKenzie");
		objects.email("testing@test.co.uk");
		driver.findElement(By.id("userName-label")).click();
		objects.gender_Male();
		objects.contactNumber("07123456789");
		driver.findElement(By.id("userName-label")).click();

		objects.hobbies_sport();
		objects.address("21 Test Street \nTest Town");
		driver.findElement(By.id("userName-label")).click();

		objects.submitForm();

		String actualText = objects.modalHeader();
		String expectedText = "Thanks for submitting the formz";
		
		String temp = screenCaptureBase64.CaptureScreenShot64(driver);
		MediaEntityBuilder.createScreenCaptureFromBase64String(temp).build();

		Assert.assertEquals(actualText, expectedText);
	}
	
}
