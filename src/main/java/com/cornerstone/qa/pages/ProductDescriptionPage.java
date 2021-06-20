package com.cornerstone.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cornerstone.qa.base.BasePage;
import com.cornerstone.qa.util.ElementUtil;
import com.cornerstone.qa.util.JavaScriptUtil;

public class ProductDescriptionPage extends BasePage{
	private WebDriver driver;
	private By nameofproductincart = By.xpath("//td[contains(@class,'cart-item-title')]//a[text()='Hand Soap']");
	private By productquantity = By.cssSelector("input[class*='cart-item-qty-input'][value*='1']");
	private By checkoutproduct = By.xpath("//a[text()='Check out']");
	
	public ProductDescriptionPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		javaScriptUtil = new JavaScriptUtil(this.driver);
	}
	
	public String getProductPageurlvalue() {
		String UrlValue = driver.getCurrentUrl();	
		return UrlValue;
	}
	
	public String getProductNameinCart() {
		String ProductinCart = elementUtil.doGetText(nameofproductincart);
		return ProductinCart;
	}
	
	public String getProductsQuentity() {
		elementUtil.waitForElementPresent(productquantity, 20);
		String ProductQuenty = elementUtil.doGetattributetext(productquantity);
		return ProductQuenty;
	}
	public CheckOutPage checkoutProduct() {
		javaScriptUtil.scrollPageDown();
		elementUtil.doClick(checkoutproduct);
		return new CheckOutPage(driver);
	}
}
