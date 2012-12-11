package com.awb.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.awb.test.core.pages.BasePage;
import com.awb.test.core.util.ValidationResult;
import com.awb.test.pages.base.AWBObjectPage;

public class InsightsPage extends AWBObjectPage{
	public InsightsPage()
	{
		
	}
	public InsightsPage(BasePage basePage) {
		
		inheritSession(basePage);
		waitForPageToLoad(getTimeout());
						
		validate();
	}
	
	/**
	 * Validate that we are on the InsightsPage
	 */
	public void validate() {

		super.validate();
		
		assertTitle("Insights");
		
	}
	public List<ValidationResult>VerifyAllElementsInPage()
	{
		List<ValidationResult> vrList = new ArrayList<ValidationResult>();
		ValidationResult vr_po=verifyCurrentVsPriorPeriod();
		vrList.add(vr_po);
		ValidationResult vr_ad=verifyClaimCountByStateGraph();
		vrList.add(vr_ad);
		ValidationResult vr_in=verifyAverageClaimLagDays();
		vrList.add(vr_in);
		ValidationResult vr_re=verifyTopStates();
		vrList.add(vr_re);	
		ValidationResult vr_tb=verifyTopPartsofBody();
		vrList.add(vr_tb);			
		return vrList;    	
	}
	public ValidationResult verifyCurrentVsPriorPeriod()
	{
		String locator="//table/tbody/tr/td[7]/table/tbody/tr[2]/td/div";
		String elementName="CurrentVsPriorPeriod Div";
		String msg="Verify CurrentVsPriorPeriod Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyClaimCountByStateGraph()
	{
		String locator="//table/tbody/tr[2]/td/table/tbody/tr/td[9]/table/tbody/tr[2]/td/div";
		String elementName="ClaimCountByStateGraph IMG";
		String msg="Verify ClaimCountByStateGraph Img";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyAverageClaimLagDays()
	{
		String locator="//table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div";
		String elementName="AverageClaimLagDays Div";
		String msg="Verify AverageClaimLagDays Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyTopStates()
	{
		String locator="//table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div";
		String elementName="TopStates Div";
		String msg="Verify TopStates Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyTopPartsofBody()
	{
		String locator="//table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/div";
		String elementName="TopPartsofBody Div";
		String msg="Verify TopPartsofBody Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}

}
