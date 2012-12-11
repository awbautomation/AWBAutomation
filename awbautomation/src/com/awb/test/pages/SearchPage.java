package com.awb.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.awb.test.core.pages.BasePage;
import com.awb.test.core.util.ValidationResult;
import com.awb.test.pages.base.AWBObjectPage;

public class SearchPage extends AWBObjectPage{
	public SearchPage()
	{
		
	}
	public SearchPage(BasePage basePage) {
		
		inheritSession(basePage);
		waitForPageToLoad(getTimeout());
						
		validate();
	}
	
	/**
	 * Validate that we are on the Search Page
	 */
	public void validate() {

		super.validate();
		
		assertTitle("Pages - Search");
		
	}
	public List<ValidationResult>VerifyAllElementsInPage()
	{
		List<ValidationResult> vrList = new ArrayList<ValidationResult>();
		ValidationResult vr_po=verifySearchSection();
		vrList.add(vr_po);
		ValidationResult vr_ad=verifyClaimDetails();
		vrList.add(vr_ad);
		ValidationResult vr_in=verifyFinancials();
		vrList.add(vr_in);
		ValidationResult vr_re=verifyVehicle();
		vrList.add(vr_re);
		ValidationResult vr_sr=verifySearchResults();
		vrList.add(vr_sr);				
		return vrList;    	
	}
	public ValidationResult verifySearchSection()
	{
		String locator="//table/tbody/tr/td/table/tbody/tr/td/div/div/div/div/div";
		String elementName="Serach div";
		String msg="Verify Serach div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyClaimDetails()
	{
		String locator="//table/tbody/tr/td/table/tbody/tr/td/div/div/div/div/div[3]/div[2]/div[2]/div[2]";
		String elementName="ClaimDetails div";
		String msg="Verify ClaimDetails div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyFinancials()
	{
		String locator="//table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table/tbody/tr/td/div/div/div/div/div[3]/div[2]/div[3]/div";
		String elementName="Financials div";
		String msg="Verify Financials div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyVehicle()
	{
		String locator="//table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table/tbody/tr/td/div/div/div/div/div[3]/div[2]/div[4]/div";
		String elementName="Vehicle div";
		String msg="Verify Vehicle div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifySearchResults()
	{
		String locator="//table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table/tbody/tr/td/div/div/div/div[2]/div";
		String elementName="SearchResults div";
		String msg="Verify SearchResults div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
}
