package com.cornerstone.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cornerstone.qa.base.BasePage;
import com.cornerstone.qa.util.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	// 1. By Locators:
	private By searchButton = By.cssSelector("button[id*='quick-search-expand']");
	private By quicksearchbox = By.cssSelector("#nav-quick-search");
	private By selectsearcheditem = By.xpath("//div[contains(@id,'quickSearch')]//a[text()='Hand Soap']");
	private By cart = By.xpath("//span[text()='Cart']");
	private By viewcart = By.xpath("//div[contains(@class,'-viewCart')]/a[contains(text(),' View Cart')]");

	//2.Constructor of the page class

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	//3. page actions: features of the page in the form methods

	public String getHomepageTitle() {
		return driver.getTitle();
	}

	public boolean isSearchbuttonExist() {
		return elementUtil.doIsDisplayed(searchButton);	
	}

	public QuickSearchPage searchProductUsingQuickSearch(String searchitem) {
		elementUtil.doClick(searchButton);
		elementUtil.doSendKeys(quicksearchbox,searchitem);
		return new QuickSearchPage(driver);
	}	
	public String checkSearchProductShown()	{
		String SearchedItem = elementUtil.doGetText(selectsearcheditem);
		return SearchedItem;

	}	
	public void selectSearchedITem() {
		elementUtil.clickWhenReady(selectsearcheditem, 20);
	}

	public ProductDescriptionPage gotoProductDescriptionPage() {
		elementUtil.clickWhenReady(cart, 20);
		elementUtil.clickWhenReady(viewcart, 20);
		return new ProductDescriptionPage(driver);
	}

}
