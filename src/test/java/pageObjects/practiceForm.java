/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Mck3nz1e-PC
 *
 */
public class practiceForm {

	WebDriver driver;

	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By emailAddress = By.id("userEmail");
	By genderMale = By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[3]/div[2]/div[1]/label");
	By mobileNumber = By.id("userNumber");
	By dateOfBirthSelector = By.id("dateOfBirthInput");
	By classSubjects = By.id("subjectsInput");
	By hobbiesSport = By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[7]/div[2]/div[1]/label");
	By addressBox = By.id("currentAddress");
	By stateSelector = By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[10]/div[2]/div/div/div[1]");
	By citySelector = By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[10]/div[3]");
	By submitButton = By.id("submit");
	By submitModal = By.cssSelector("#example-modal-sizes-title-lg");

	public practiceForm(WebDriver driver) {

		this.driver = driver;
	}
	
	public void givenName(String givenName) {
		driver.findElement(firstName).sendKeys(givenName);;
	}
	
	public void surname(String surname) {
		driver.findElement(lastName).sendKeys(surname);;
	}
	
	public void email(String emailAddy) {
		driver.findElement(emailAddress).sendKeys(emailAddy);;
	}
	
	public void gender_Male(){
		driver.findElement(genderMale).click();
	}
	
	public void contactNumber(String contactNumber) {
		driver.findElement(mobileNumber).sendKeys(contactNumber);
	}
	
	public void subjects(String subjects) {
		driver.findElement(classSubjects).sendKeys(subjects +(Keys.RETURN));
	}
	
	public void hobbies_sport() {
		driver.findElement(hobbiesSport).click();
	}
	
	public void address(String address) {
		driver.findElement(addressBox).sendKeys(address);
	}
	
	public void state(String state) {
		driver.findElement(stateSelector).sendKeys(state);
	}
	
	public void city(String city) {
		driver.findElement(citySelector).click();
		driver.findElement(citySelector).sendKeys(city);
	}
	
	public void submitForm() {
		driver.findElement(submitButton).sendKeys(Keys.RETURN);
	}
	
	public String modalHeader() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(submitModal)));
		return driver.findElement(submitModal).getText();
	}
}