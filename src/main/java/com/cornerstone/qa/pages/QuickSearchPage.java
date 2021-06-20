package com.cornerstone.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cornerstone.qa.base.BasePage;
import com.cornerstone.qa.util.ElementUtil;

public class QuickSearchPage extends BasePage{	
	
	private WebDriver driver;
	private By addtocart = By.cssSelector("#quickSearch > div > section > ul > li:nth-child(1) > article > figure > figcaption > div > a");
	private By selectsearcheditem = By.xpath("//div[contains(@id,'quickSearch')]//a[text()='Hand Soap']");
	
	public QuickSearchPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	public String checkSearchProductShown()	{
		String SearchedItem = elementUtil.doGetText(selectsearcheditem);
		return SearchedItem;
	}	
	public ProductDescriptionPage addProductToCart() {

		elementUtil.waitForElementPresent(addtocart, 20);
		elementUtil.doClick(addtocart);
		return new ProductDescriptionPage(driver);
	}

}
