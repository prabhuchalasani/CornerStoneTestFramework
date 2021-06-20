package com.cornerstone.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cornerstone.qa.base.BaseTest;
import com.cornerstone.qa.util.ConstantUtil;

public class CornerStoneHomePageTest extends BaseTest{


	@Test(priority = 1) 
	public void verifyHomePageTitleTest() { 
		String title = homePage.getHomepageTitle();
	System.out.println("Home page title is : "+title); Assert.assertEquals(title,ConstantUtil.Home_Page_Title); }

	@Test(priority = 2) 
	public void verifySearchbuttonTest() {
		Assert.assertTrue(homePage.isSearchbuttonExist()); }

	/*@Test(priority = 3)
	
	public void verifySearchedItemShownTest() {
		homePage.searchProductUsingQuickSearch(ConstantUtil.Searched);
		String SearchedItem = homePage.checkSearchProductShown();
		System.out.println("Searched Item = " + SearchedItem);
		Assert.assertEquals(SearchedItem, ConstantUtil.SearchedItem);	
	}*/
}
