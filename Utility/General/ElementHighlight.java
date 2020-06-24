package General;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHighlight {

	WebDriver driver;

	public ElementHighlight(WebDriver driver) {

		this.driver = driver;

	}
	
	public void Highlighter(WebElement element_node) throws Exception {
				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", element_node);
		Thread.sleep(3000);
	}

}
