package com.cornerstone.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cornerstone.qa.base.BasePage;
import com.cornerstone.qa.util.ElementUtil;

public class OrderConformationPage extends BasePage {
	private WebDriver driver;
	private By orderconformationtext = By.xpath("//div[@class='orderConfirmation']/h1[contains(text(),'Thank you')]");
	public OrderConformationPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);		
	}
	public String getconformationtext() {
		elementUtil.waitForElementPresent(orderconformationtext, 20);
		String OrderConformationText =	elementUtil.doGetText(orderconformationtext);
		return OrderConformationText;
	}
}
