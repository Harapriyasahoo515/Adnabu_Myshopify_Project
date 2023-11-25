package com.pageRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@id='SiteNav']/li/a/span[text()='Catalog']")
	private WebElement catalogLink;
	
	public void clickOnCatalogLink()
	{
		catalogLink.click();
	}
}
