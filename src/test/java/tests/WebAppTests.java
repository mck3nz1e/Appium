package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pageObjects.practiceForm;

public class WebAppTests extends BaseClass {

	@Test
	public void happyPath() throws Exception {

		test = extent.createTest("happyPath", "This is a happy path end to end scenario.");
		test.log(Status.INFO, "Happy Path Test 1 Started.");

		driver.get("http://www.demoqa.com/automation-practice-form");
		test.log(Status.PASS, "Navigate to the practice form");

		practiceForm objects = new practiceForm(driver);
		
		objects.givenName("Scott");
		test.log(Status.PASS, "Entered first name.");

		objects.surname("McKenzie");
		test.log(Status.PASS, "Entered surnname.");

		objects.email("testing@test.co.uk");
		test.log(Status.PASS, "Entered email address.");

		driver.findElement(By.id("userName-label")).click();
		
		objects.gender_Male();
		test.log(Status.PASS, "Selected gender.");

		objects.contactNumber("07123456789");
		test.log(Status.PASS, "Entered mobile number.");

		driver.findElement(By.id("userName-label")).click();

		objects.hobbies_sport();
		test.log(Status.PASS, "Selected sport as a hobby.");

		objects.address("21 Test Street \nTest Town");
		test.log(Status.PASS, "Entered address.");

		driver.findElement(By.id("userName-label")).click();

		objects.submitForm();
		test.log(Status.PASS, "Submitted form.");

		String actualText = objects.modalHeader();
		String expectedText = "Thanks for submitting the form";

		Assert.assertEquals(actualText, expectedText);
		test.log(Status.PASS, "Asserted the modal title.");

		test.log(Status.INFO, "Test complete");
	}
}
