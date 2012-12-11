package com.awb.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.awb.test.core.pages.BasePage;
import com.awb.test.core.util.ValidationResult;
import com.awb.test.pages.base.AWBObjectPage;

public class AdhocAnalysisPage extends AWBObjectPage{
	public AdhocAnalysisPage()
	{
		
	}
	public AdhocAnalysisPage(BasePage basePage) {
		
		inheritSession(basePage);
		waitForPageToLoad(getTimeout());
						
		validate();
	}
	
	/**
	 * Validate that we are on the Adhoc Analysis page
	 */
	public void validate() {

		super.validate();
		
		assertTitle("Adhoc Analysis");
		
	}
	public List<ValidationResult>VerifyAllElementsInPage()
	{
		List<ValidationResult> vrList = new ArrayList<ValidationResult>();
		ValidationResult vr_po=verifyType();
		vrList.add(vr_po);
		ValidationResult vr_ad=verifyName();
		vrList.add(vr_ad);
		ValidationResult vr_in=verifyDescription();
		vrList.add(vr_in);
		ValidationResult vr_re=verifyModified();
		vrList.add(vr_re);	
		ValidationResult vr_mby=verifyModifiedBy();
		vrList.add(vr_mby);			
		return vrList;    	
	}
	public ValidationResult verifyType()
	{
		String locator="//div[@id='WebPartWPQ2']/table[2]/thead/tr/th";
		String elementName="Type Text";
		String msg="Verify Type Text";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyName()
	{
		String locator="//div[@id='WebPartWPQ2']/table[2]/thead/tr/th[2]";
		String elementName="Name Text";
		String msg="Verify Name Text";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyDescription()
	{
		String locator="//div[@id='WebPartWPQ2']/table[2]/thead/tr/th[3]";
		String elementName="Description Text";
		String msg="Verify Description Text";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyModified()
	{
		String locator="//div[@id='WebPartWPQ2']/table[2]/thead/tr/th[4]";
		String elementName="Modified Text";
		String msg="Verify Modified Text";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyModifiedBy()
	{
		String locator="//table[2]/thead/tr/th[5]";
		String elementName="Modified By Text";
		String msg="Verify Modified By Text";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}

}
