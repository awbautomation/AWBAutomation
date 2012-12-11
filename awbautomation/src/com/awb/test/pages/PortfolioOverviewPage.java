package com.awb.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.awb.test.core.pages.BasePage;
import com.awb.test.core.util.ValidationResult;
import com.awb.test.pages.base.AWBObjectPage;

public class PortfolioOverviewPage extends AWBObjectPage{
	public PortfolioOverviewPage()
	{
		
	}
	public PortfolioOverviewPage(BasePage basePage) {
		
		inheritSession(basePage);
		waitForPageToLoad(getTimeout());
						
		validate();
	}
	
	/**
	 * Validate that we are on the PortfolioOverview page
	 */
	public void validate() {

		super.validate();
		
		assertTitle("Portfolio Overview");
		
	}
	public List<ValidationResult>VerifyAllElementsInPage()
	{
		List<ValidationResult> vrList = new ArrayList<ValidationResult>();
		ValidationResult vr_po=verifyClaimSynopsisReport();
		vrList.add(vr_po);
		ValidationResult vr_ad=verifyClaimSynopsisByState();
		vrList.add(vr_ad);
		ValidationResult vr_in=verifyClaimWatchList();
		vrList.add(vr_in);
		ValidationResult vr_re=verifyTotalIncurredByCostBreakdown();
		vrList.add(vr_re);				
		return vrList;    	
	}
	public ValidationResult verifyClaimSynopsisReport()
	{
		String locator="//table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr[2]/td/div";
		String elementName="Claim Synopsis Report Link";
		String msg="Verify Claim Synopsis Report link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyClaimSynopsisByState()
	{
		String locator="//table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr[2]/td/div";
		String elementName="Claim Synopsis by State Link";
		String msg="Verify Claim Synopsis by State Link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyClaimWatchList()
	{
		String locator="//*[@id='Grid1']";
		String elementName="ClaimWatchList Text";
		String msg="Verify ClaimWatchList text";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyTotalIncurredByCostBreakdown()
	{
		String locator="//table/tbody/tr/td[3]/table/tbody/tr[2]/td/div";
		String elementName="Total Incurred by Cost Breakdown Link";
		String msg="Verify Total Incurred by Cost Breakdown";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));		
		vr.addValidation(check, msg);
		return vr;			
	}


}
