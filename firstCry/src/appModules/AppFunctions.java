package appModules;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.FirstTimePopUp_Page;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.IntSetup;

public class AppFunctions {

	Home_Page objHome_Page =  Home_Page.getInstance();
	FirstTimePopUp_Page objFirstTimePopUp_page = FirstTimePopUp_Page.getInstance();
	SeleniumFunctions objSeleniumFunctions=new SeleniumFunctions();
	
	public void closePopup(WebDriver driver) throws Exception {
		objSeleniumFunctions.waitForElement(driver, objFirstTimePopUp_page.button_Close(driver), 90);
		objFirstTimePopUp_page.button_Close(driver).click();
	}

	public void captureSuggestions(WebDriver driver) throws Exception {
		String sTextBoxData = ExcelUtils.getCellData(IntSetup.iTestCaseRow, Constant.Col_Input);
		objHome_Page.textbox_SearchBar(driver).clear();
		objHome_Page.textbox_SearchBar(driver).sendKeys(sTextBoxData);
		List<WebElement> searchList = driver.findElements(By.xpath("//div[@id='searchlist']/ul/li"));
	}
	
	public void navigateContactUs(WebDriver driver) throws Exception {
		objHome_Page.hyperLink_ContactUs(driver).click();
			}

}
