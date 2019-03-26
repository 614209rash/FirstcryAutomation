package utility;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import utility.Constant;
import utility.ExcelUtils;

public abstract class IntSetup {
	public static WebDriver driver;
	private String sTestCaseName;
	public static int iTestCaseRow;
	


	@BeforeMethod
	public void beforeMethod(Method method) throws Exception {
		sTestCaseName = method.getName();
		System.out.println("*******Start******"+method.getName()+"*******Start******");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);

	}

	public static WebDriver OpenBrowser() throws Exception {
		try {
			System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(Constant.URL);
			System.out.println("Web application launched successfully");

		} catch (Exception e) {
			System.out.println("Class Utils | Method OpenBrowser | Exception desc : " + e.getMessage());
		}
		return driver;
	}

	@AfterMethod
	public void afterMethod(Method method) throws Exception {
	System.out.println("*******End******"+method.getName()+"*******End******");
	}

	@AfterClass
	public void afterClass() throws Exception {
		driver.close();
	}

}
