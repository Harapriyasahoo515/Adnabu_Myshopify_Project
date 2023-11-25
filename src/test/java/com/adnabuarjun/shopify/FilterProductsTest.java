package com.adnabuarjun.shopify;

import org.testng.annotations.Test;

import com.pageRepo.CartPage;
import com.pageRepo.CatalogPage;
import com.pageRepo.HomePage;
import com.pageRepo.ProductPurchasePage;
import com.utilities.BaseClass;

public class FilterProductsTest extends BaseClass{

	@Test
	public void filterProducts() throws Throwable
	{
		HomePage homePage = new HomePage(driver);
		homePage.clickOnCatalogLink();
		
		CatalogPage catalogPage = new CatalogPage(driver);
		catalogPage.selectproduct();
		
		ProductPurchasePage productPurchasePage = new ProductPurchasePage(driver);
		productPurchasePage.addProductToCart();
	}
	
	@Test(dependsOnMethods = "filterProducts" )
	public void removeProductTest()
	{
		CartPage cartPage = new CartPage(driver);
		cartPage.removeProductInCart();
	}
	
}
