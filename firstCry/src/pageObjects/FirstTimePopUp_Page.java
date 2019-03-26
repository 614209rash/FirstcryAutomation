package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTimePopUp_Page {
	private static WebElement element = null;
	private static FirstTimePopUp_Page objFirstTimePopUp_Page;

	// using singleton pattern
	private FirstTimePopUp_Page() {

	}

	public static FirstTimePopUp_Page getInstance() {
		if (objFirstTimePopUp_Page == null) {
			return new FirstTimePopUp_Page();
		}
		return objFirstTimePopUp_Page;
	}

	public  WebElement button_Close(WebDriver driver) throws Exception {
		try {
			element = driver.findElement(By.xpath("//*[text()='Close']/following-sibling::div"));
			System.out.println("button_Close is found on the FirstTimePopUp");
		} catch (Exception e) {
			System.out.println("button_Close not found on the FirstTimePopUp");
		}
		return element;
	}

}
