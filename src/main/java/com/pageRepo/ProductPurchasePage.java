package com.pageRepo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.WebDriverUtilities;

public class ProductPurchasePage {

	WebDriver driver;
	WebDriverUtilities webDriverUtilities = new WebDriverUtilities();
	
	public ProductPurchasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[contains(@class,'form__item--payment-button')]/button[@name='add']")
	private WebElement addToCartLink;
	
	@FindBy (xpath = "//div[contains(@class,'product-single')]/h1[contains(@class,'title')]")
	private WebElement productTitleLink;
	
	@FindBy (xpath = "//div[@class='list-view-item__title']/a")
	private WebElement productTitleInCartLink;
	
	@FindBy (xpath = "//a[contains(@href,'/cart')]")
	private WebElement cartIconLink;
	
	public void addProductToCart() throws Throwable
	{
		String prodTitle = productTitleLink.getText();
		System.out.println(prodTitle);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartLink));
		webDriverUtilities.mouseoverAction(driver, addToCartLink);
		addToCartLink.click();
		
		Thread.sleep(3000);
		cartIconLink.click();
		System.out.println(productTitleInCartLink.getText());
		assertTrue(prodTitle.equalsIgnoreCase(productTitleInCartLink.getText()), "Probaly product is not added in cart");
	}
}
