package com.cornerstone.qa.testcases;

import org.jsoup.select.Evaluator.ContainsText;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cornerstone.qa.base.BaseTest;
import com.cornerstone.qa.util.ConstantUtil;

public class PlaceOrderUsingQuickSearchTest extends BaseTest{
	@Test(priority = 1)
	public void verifyTheProductAndAddProductToCartTest() {
		quickSearchPage = homePage.searchProductUsingQuickSearch(ConstantUtil.Searched_Product);
		String SearchedProduct = quickSearchPage.checkSearchProductShown();
		System.out.println("Searched Product = " + SearchedProduct );
		Assert.assertEquals(SearchedProduct, ConstantUtil.Searched_Product);	
		productDescriptionPage = quickSearchPage.addProductToCart();

	}
	@Test(priority = 2)
	public void verifyProductTileInTheCartTest() {
		String ProductName = productDescriptionPage.getProductNameinCart();
		System.out.println("Product in the cart = "+ProductName);
		Assert.assertEquals(ProductName, ConstantUtil.Searched_Product);
	}
	@Test(priority = 3)
	public void verifyProductQuentyInTheCartTest() {
		String ProductQuenty = productDescriptionPage.getProductsQuentity();
		System.out.println("Product quenty in the cart = "+ProductQuenty);
		Assert.assertEquals(ProductQuenty, "1");
	}
	@Test(priority = 4)
	public void verifyProductPriceTest() {
		checkOutPage=productDescriptionPage.checkoutProduct();
		String ProductPrice = checkOutPage.getProductPrice();
		System.out.println("Product price "+ProductPrice);
		Assert.assertEquals(ProductPrice, ConstantUtil.Cart_Price_Value);
	}
	@Test(priority = 5)
	public void verifyShippingAddressTest() {	
		checkOutPage.continueAsGuest(prop.getProperty("Email"));
		checkOutPage.enterShippingAddress(prop.getProperty("FirstName"), prop.getProperty("LastName"), prop.getProperty("AddressLineOne"), prop.getProperty("City"), prop.getProperty("PostCode"), prop.getProperty("Phone"));
	}
	@Test(priority = 6)
	public void verifyShippingPriceTest() {
		String ShippingPrice= checkOutPage.getShippingPrice();
		System.out.println("Shipping price "+ShippingPrice);
		Assert.assertEquals(ShippingPrice, ConstantUtil.Shipping_Price_Value);
	}
	@Test(priority = 7)
	public void verifyPaymentProcess() {
		orderConformationPage = checkOutPage.completePaymentProcess(prop.getProperty("CreditCardNumber"), prop.getProperty("ExpirationDate"), prop.getProperty("NameonCard"), prop.getProperty("CVVNumber"));		
	}
	@Test(priority = 8)
	public void verifyOrderConformation() {
		String OrderConformationText = orderConformationPage.getconformationtext();
		System.out.println("Order conformation text = "+OrderConformationText);
		Assert.assertTrue(OrderConformationText.contains("Thank you"));	
	}

	@Test(priority = 9)
	public void verifyProductPriceWithShippingCostTest() {
		String ProductPriceWithShippingCost=
		checkOutPage.getFinalProductPriceWithShippingCost();
		System.out.println("Product price with shipping = "+ProductPriceWithShippingCost);
		Assert.assertEquals(ProductPriceWithShippingCost,ConstantUtil.Product_Price_with_Shipping); }


}
