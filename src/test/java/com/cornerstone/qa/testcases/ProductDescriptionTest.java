package com.cornerstone.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cornerstone.qa.base.BaseTest;
import com.cornerstone.qa.util.ConstantUtil;

public class ProductDescriptionTest extends BaseTest {
	@Test(priority = 1) 
	public void verifyProductTileInTheCart() {
		homePage.gotoProductDescriptionPage();
		String ProductName = productDescriptionPage.getProductNameinCart();
		System.out.println("Product in the cart = "+ProductName);
		Assert.assertEquals(ProductName, ConstantUtil.Searched_Product);
		
	}
	public void verifyNumberofProductsInCart() {
		
		String ProductQuenty = productDescriptionPage.getProductsQuentity();
		System.out.println("Product quenty in the cart = "+ProductQuenty);
		Assert.assertEquals(ProductQuenty, "1");
	}
}
