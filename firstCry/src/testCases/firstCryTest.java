package testCases;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import appModules.AppFunctions;
import appModules.SeleniumFunctions;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.IntSetup;

public class firstCryTest extends IntSetup {

	AppFunctions objAppFunctions = new AppFunctions();
	SeleniumFunctions objSeleniumFunctions = new SeleniumFunctions();
	Home_Page objHome_Page =  Home_Page.getInstance();

	@Test(priority = 1, enabled = true)
	public void validateSuggestionTest() throws Exception {
		driver = OpenBrowser();
		objAppFunctions.closePopup(driver);
		objAppFunctions.captureSuggestions(driver);

	}

	@Test(priority = 2, enabled = true)
	public void validateContactUs() throws Exception {
		objAppFunctions.navigateContactUs(driver);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		String expectedTitle = ExcelUtils.getCellData(IntSetup.iTestCaseRow, Constant.Col_Input);
		objSeleniumFunctions.compareTitle(driver, expectedTitle);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
	}

	@Test(priority = 3, enabled = true)
	public void validatePuzzleSubMenu() throws Exception {
		Boolean flag = false;
		objSeleniumFunctions.mouseHover(driver, objHome_Page.menu_ToysBooksSchool(driver));
		int count = objHome_Page.subMenu_ToysBooksSchool(driver).size();
		System.out.println("No of subMenu under menu menu_ToysBooksSchool " + count);
		for (int i = 0; i < count; i++) {
			WebElement element = objHome_Page.subMenu_ToysBooksSchool(driver).get(i);
			String actualTextSubMenu = element.getAttribute("title");
			System.out.println("actualText of SubMenu :: " + actualTextSubMenu);
			if (actualTextSubMenu.contains("Puzzles")) {
				flag = true;
			}
		}
		if (flag) {
			String expectedTitle = ExcelUtils.getCellData(IntSetup.iTestCaseRow, Constant.Col_Input);
			objSeleniumFunctions.compareTitle(driver, expectedTitle);
		} else {
			System.out.println("Not Present");
		}
	}
}
