package com.cornerstone.qa.util;

import org.openqa.selenium.WebDriver;

public class ConstantUtil{
	
	WebDriver driver;

	public ConstantUtil(WebDriver driver) {
	this.driver = driver;
	}

	public static final String Home_Page_Title = "Cornerstone Demo";
	public static final String Searched_Product = "Hand Soap";
	public static final String Cart_Price_Value = "$15.00";
	public static final String Shipping_Price_Value = "$10.00";
	public static final String Product_Price_with_Shipping = "$25.00";
	public static final String Order_Conformation_Text = "Thank you";
	
	
	
}
