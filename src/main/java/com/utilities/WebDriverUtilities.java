package com.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtilities {
	/**
	 * 
	 * This method is used for maximizing the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {

		driver.manage().window().maximize();

	}

	/**
	 * This method is used for minimizing the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {

		driver.manage().window().minimize();

	}

	/**
	 * This method will wait for all the FindElement and findElements operation to
	 * be performed
	 * 
	 * @param driver
	 */
	public void waitForElementLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	/**
	 * The method will wait until the specified element is visibile in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementTobeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	/**
	 * This method will handle dropdown through index
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown through value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown through visibleText
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value, WebElement element) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	/**
	 * This method will perform mouse over on the particular element
	 * @param driver
	 * @param element
	 */
	public void mouseoverAction(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	

	/**
	 * This method will perform double click on the webPage
	 * @param driver
	 */
	
	public void doubleClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClickonElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform Rightclick on the element
	 * @param driver
	 * @param element
	 */
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform dragdrop on the element
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */

	public void dragAndDrop(WebDriver driver, WebElement srcElement,WebElement targetElement) {
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
	}
	
	/**
	 * This method will move Cursor anywhere in webPage based on offset value
	 * @param driver
	 * @param xOffset
	 * @param yOffset
	 */
	
	
	public void moveAcrossWebPage(WebDriver driver,int xOffset,int yOffset) {
		Actions act=new Actions(driver);
		act.moveByOffset(xOffset, yOffset).click().perform();
	}
	
	/**
	 * This method is used for scrolling the page vertically by 500 pixels
	 * @param driver
	 */
	public void scrollActions(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}
	
	/**
	 * This method is scrolling until the element located
	 * @param driver
	 * @param element
	 */
	public void scrollActions(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+");", element);
	}
	/**
	 * This method use to accept for alert popup
	 * @param driver
	 */
	public void alertPopUp(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method use to cancel the confirmation  popup
	 * @param driver
	 */
	public void cancelPopUp(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used for sending the text in alert popup
	 * @param driver
	 * @param Text
	 */
	public void sendTextToAlertPopup(WebDriver driver,String Text) {
		driver.switchTo().alert().sendKeys(Text);
	}
	
	
	/**
	 * This method is used to capture the alert text and return to the user
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
	return 	driver.switchTo().alert().getText();
	}
	
	/**
	 * This method is used to handle the frame by index value
	 * @param driver
	 * @param index
	 */
	
	public void  handleFrame(WebDriver driver, int index) {
		 	driver.switchTo().frame(index);
		}
	/**
	 * This method is used to handle the frame by id or name
	 * @param driver
	 * @param idorname
	 */
	public void  handleFramebyValue(WebDriver driver, String idorname) {
	 	driver.switchTo().frame(idorname);
	}
	/**
	 * This method is used to switch the immediate parent
	 * @param driver
	 */
	
	public void  switchToParentFrame(WebDriver driver) {
	 	driver.switchTo().parentFrame();
	}
	
	/**
	 * This method is used to switch the default page
	 * @param driver
	 */
	public void  switchToDefaultPage(WebDriver driver) {
	 	driver.switchTo().defaultContent();
	}
	
	/**
	 * The method will switch the control from parent window
	 * to child window 
	 * @param driver
	 * @param partialWinTitle
	 */
	
	public void switchToWindow(WebDriver driver, String partialWinTitle) 
	{
		//step1: Capture all the window IDs
		Set<String> allWindowIds = driver.getWindowHandles();
		
		//step2:iterate through individual Ids
		for(String winId:allWindowIds) {
			//step3 switch to each id and capture the titles
			String currentTitle = driver.switchTo().window(winId).getTitle();
			
			//Step4: Compare the title with required reference
			if(currentTitle.contains(partialWinTitle)) {
				break;
			}
		}
		
	}
	
	/**
	 * This method will take screenshot and return the absolute path of it
	 * @param driver
	 * @param screenshot
	 * @return
	 * @throws Throwable
	 */
	public String takeScreenShot(WebDriver driver, String screenshot) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshot\\"+screenshot+".png");
		Files.copy(src,dst);//common IO tool
		
		return dst.getAbsolutePath();//attach screenshot to extent reports
	}
	
	/**
	 * 
	 * This method will take a screenshot .
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 * 
	 */
	public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		String date= toString().replace(" ", "-").replace(":", "-");
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		screenshotName = screenshotName+date;
		File destination= new File("./Screenshot/"+screenshotName+".png");
		FileUtils.copyFile(src, destination);	
		return destination.getAbsolutePath();
	}
	
	
	
	
	
	
	

}
