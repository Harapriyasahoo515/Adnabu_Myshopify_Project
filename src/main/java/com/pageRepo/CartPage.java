package com.pageRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utilities.WebDriverUtilities;

public class CartPage {
	WebDriver driver;
	WebDriverUtilities webDriverUtilities = new WebDriverUtilities();

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table//tbody/tr[contains(@class,'cart__row')]/td[contains(@class,'cart__meta')]/p/a")
	private WebElement removeProductInCartLink;

	@FindBy (xpath = "//div[@class='list-view-item__title']/a")
	private WebElement productTitleInCartLink;
	
	
	public void removeProductInCart()
	{
		removeProductInCartLink.click();
//		Assert.assertTrue(!(productTitleInCartLink.isDisplayed()), "Product is still in cart | Product is not removed from cart");
	}


}
