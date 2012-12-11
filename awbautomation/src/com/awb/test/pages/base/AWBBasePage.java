package com.awb.test.pages.base;

import org.openqa.selenium.By;

import com.awb.test.core.pages.BasePage;

/**
 * This class provide the common functionalities among all AWB Pages
 * eg. goHome
 * 
 * @author sshyamala 
 */
public class AWBBasePage extends BasePage {

	/**
	 * Stop the performance capture, 
	 * this method will be invoked by all sub-classes no need to stop the timer on a per-class basis 
	 */
	protected void validate() {    	
    	//stopPerformanceCapturePageLoaded();
	}
	
	
	public By cssLocator(String locator) {
		return By.cssSelector(locator);
	}
	public By xpathLocator(String locator){
		return By.xpath(locator);
	}
	public By classLocator(String locator){
		return By.className(locator);
	}
	public By idLocator(String locator){
		return By.id(locator);
	}
	public By linktextLocator(String locator){
		return By.linkText(locator);
	}
	public By partialLinkTextLocator(String locator){
		return By.partialLinkText(locator);
	}
	public By nameLocator(String locator){
		return By.name(locator);
	}
	public By tagNameLocator(String locator){
		return By.tagName(locator);
	}
	public void goHome() {  }
	public void clickLogoutLink() { }
	
}
