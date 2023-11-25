package com.pageRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.IpathConstant;
import com.utilities.WebDriverUtilities;

public class CatalogPage {

	WebDriver driver;
	WebDriverUtilities webDriverUtilities = new WebDriverUtilities();

	public CatalogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='Collection']/ul/li")
	private List<WebElement> allProductLinks;

	@FindBy(xpath = "//div[@id='Collection']/ul/li/div/dl//dd/span[contains(@class,'price-item--regular')]")
	private List<WebElement> priceOfProductLinks;

	@FindBy(xpath = "//select[@id='FilterTags']")
	private WebElement filterDropDown;
	
	
	public void selectproduct()
	{
		webDriverUtilities.handleDropDown(filterDropDown, IpathConstant.productFilterGold);
		for (int i = 0; i < allProductLinks.size(); i++) {
			for (WebElement price : priceOfProductLinks) {
				if (!(price.getText().contains("Sold out"))) {
					allProductLinks.get(i).click();
					break;
				}else
				{
					i++;
				}
			}
		}

	}

}
