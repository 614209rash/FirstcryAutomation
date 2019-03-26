package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	private WebElement element = null;
	private List<WebElement> elements = null;
	private static Home_Page objHome_Page;

	// using singleton pattern
	private Home_Page() {

	}

	public static Home_Page getInstance() {
		if (objHome_Page == null) {
			return new Home_Page();
		}
		return objHome_Page;
	}

	public WebElement textbox_SearchBar(WebDriver driver) throws Exception {
		try {
			element = driver.findElement(By.id("search_box"));
			System.out.println("Search Bar is found on the Home Page");
		} catch (Exception e) {
			System.out.println("SearchBar is not found on the Home Page");
			throw (e);
		}
		return element;
	}

	public WebElement hyperLink_ContactUs(WebDriver driver) throws Exception {
		try {
			element = driver.findElement(By.xpath("(//*[contains(text(),'Contact Us')])[1]"));
			System.out.println("hyperLink_ContactUs is found on the Home Page");
		} catch (Exception e) {
			System.out.println("hyperLink_ContactUs is not found on the Home Page");
			throw (e);
		}
		return element;
	}

	public WebElement menu_ToysBooksSchool(WebDriver driver) throws Exception {
		try {
			element = driver.findElement(By.xpath("//*[@class='menu-container media-pros']/ul/li[4]"));
			System.out.println("menu_ToysBooksSchool is found on the Home Page");
		} catch (Exception e) {
			System.out.println("menu_ToysBooksSchool is not found on the Home Page");
			throw (e);
		}
		return element;
	}

	public List<WebElement> subMenu_ToysBooksSchool(WebDriver driver) throws Exception {
		try {
			elements = driver.findElements(By.xpath("//*[@class='menu-option-container menu4']/div/ul/li/a"));
			System.out.println("subMenu_ToysBooksSchool is found on the Home Page");
		} catch (Exception e) {
			System.out.println("subMenu_ToysBooksSchool is not found on the Home Page");
			throw (e);
		}
		return elements;
	}

}
