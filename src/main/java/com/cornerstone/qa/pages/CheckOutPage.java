package com.cornerstone.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cornerstone.qa.base.BasePage;
import com.cornerstone.qa.util.ElementUtil;
import com.cornerstone.qa.util.JavaScriptUtil;

public class CheckOutPage extends BasePage {
	private WebDriver driver;
	private By email = By.cssSelector("input[name='email']");
	private By aggreeprivacypolicy = By.xpath("//span[text()='Yes, I agree with the ']");
	private By continueasguest = By.xpath("//button[text()='Continue as guest']");
	private By firstname = By.xpath("//input[@id='firstNameInput']");
	private By lastname = By.xpath("//input[@id='lastNameInput']");
	private By addresslineone = By.xpath("//input[@id='addressLine1Input']");
	private By city = By.xpath("//input[@id='cityInput']");
	private By postcode = By.xpath("//input[@id='postCodeInput']");
	private By phonenumner = By.xpath("//input[@id='phoneInput']");
	private By shippingaddresscontinue = By.xpath("//button[@id='checkout-shipping-continue']");
	private By creditcardnumber = By.xpath("//input[@id='ccNumber']");
	private By productprice = By.xpath("//div[contains(@class,'--total')]//span[@data-test='cart-price-value']");
	private By shippingprice = By.xpath("//span[@class='shippingOption-price']");
	private By testgateway = By.xpath("//span[text()='Test Gateway']");
	private By expirationdate = By.xpath("//input[@id='ccExpiry']");
	private By cvvnumner = By.xpath("//input[@id='ccCvv']");
	private By nameoncard = By.xpath("//input[@id='ccName']");
	private By placeorder = By.xpath("//button[text()='Place Order']");


	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		javaScriptUtil = new JavaScriptUtil(this.driver);
	}

	public String getCheckoutPageURL() {
		String carturl = driver.getCurrentUrl();
		return carturl;
	}
	public void continueAsGuest(String email) {
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doClick(aggreeprivacypolicy);
		elementUtil.doClick(continueasguest);
	}
	public String getProductPrice() {
		String ProductPrice = elementUtil.doGetText(productprice);
		return ProductPrice;
		
		
	}
	public void enterShippingAddress(String FirstName,String LastName,String AddressLineOne,String City,String PostCode,String Phone) {
		elementUtil.doSendKeys(firstname, FirstName);
		elementUtil.doSendKeys(lastname, LastName);
		elementUtil.doSendKeys(addresslineone, AddressLineOne);
		javaScriptUtil.scrollPageDown();
		elementUtil.doSendKeys(city, City);
		elementUtil.doSendKeys(postcode, PostCode);
		elementUtil.doSendKeys(phonenumner, Phone);
	}
	
	public String getShippingPrice() {
		elementUtil.waitForElementPresent(shippingprice, 40);
		String ShippingPrice = elementUtil.doGetText(shippingprice);
		return ShippingPrice;
	}
	
	public String getFinalProductPriceWithShippingCost() {
		String FinalProductPriceWithShipping = elementUtil.doGetText(productprice);
		return FinalProductPriceWithShipping;
		}

	public OrderConformationPage completePaymentProcess(String CardNumber,String ExpirationDate,String NameOnCard,String CVVNumber) {
		elementUtil.waitForElementToBeClickable(shippingaddresscontinue, 20);
		javaScriptUtil.clickElementByJS(shippingaddresscontinue);
		elementUtil.waitForElementPresent(testgateway, 20);
		elementUtil.doSendKeys(creditcardnumber, CardNumber);
		elementUtil.doSendKeys(expirationdate, ExpirationDate);
		elementUtil.doSendKeys(nameoncard, NameOnCard);
		elementUtil.doSendKeys(cvvnumner, CVVNumber);
		elementUtil.doClick(placeorder);
		return new OrderConformationPage(driver); 				
	}
}
