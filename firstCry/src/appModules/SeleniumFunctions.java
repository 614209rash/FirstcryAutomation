package appModules;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.IntSetup;

public class SeleniumFunctions {

	public void waitForElement(WebDriver driver, WebElement element, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void compareTitle(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
		System.out.println("actualTitle of Page" + actualTitle);
		assertEquals(expectedTitle, actualTitle);

	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

}
