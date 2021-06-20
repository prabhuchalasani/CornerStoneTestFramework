package com.cornerstone.qa.base;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.cornerstone.qa.pages.CheckOutPage;
import com.cornerstone.qa.pages.HomePage;
import com.cornerstone.qa.pages.OrderConformationPage;
import com.cornerstone.qa.pages.ProductDescriptionPage;
import com.cornerstone.qa.pages.QuickSearchPage;

public class BaseTest {

	public BasePage basePage;
	public HomePage homePage;
	public QuickSearchPage quickSearchPage;
	public ProductDescriptionPage productDescriptionPage;
	public CheckOutPage checkOutPage;
	public OrderConformationPage orderConformationPage;
	public WebDriver driver;
	public Properties prop;

	@BeforeClass
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		homePage = new HomePage(driver);
		driver.get(prop.getProperty("url"));			
	}


	@AfterClass
	public void tearDown() { 
		driver.quit();
	}

}
