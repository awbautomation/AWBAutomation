package com.awb.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.awb.test.core.pages.BasePage;
import com.awb.test.core.util.ValidationResult;
import com.awb.test.pages.base.AWBObjectPage;

public class ReportingPage extends AWBObjectPage{
	public ReportingPage()
	{
		
	}
	public ReportingPage(BasePage basePage) {
		
		inheritSession(basePage);
		waitForPageToLoad(getTimeout());
						
		validate();
	}
	
	/**
	 * Validate that we are on the Reporting Page
	 */
	public void validate() {

		super.validate();
		
		assertTitle("Reporting");
		
	}
	public List<ValidationResult>VerifyAllElementsInPage()
	{
		List<ValidationResult> vrList = new ArrayList<ValidationResult>();
		ValidationResult vr_po=verifyFinancialComparison();
		vrList.add(vr_po);
		ValidationResult vr_ad=verifyClaimCountbyState();
		vrList.add(vr_ad);
		ValidationResult vr_in=verifyLegalProviderReport();
		vrList.add(vr_in);
		ValidationResult vr_re=verifyWCScorecard();
		vrList.add(vr_re);
		ValidationResult vr_at=verifyClaimCountbyAccidentType();
		vrList.add(vr_at);
		ValidationResult vr_bu=verifyClaimCountByBusinessUnit();
		vrList.add(vr_bu);
		ValidationResult vr_pb=verifyClaimCountbyPartofBody();
		vrList.add(vr_pb);				
		return vrList;    	
	}
	public ValidationResult verifyFinancialComparison()
	{
		String locator="//table/tbody/tr/td/table/tbody/tr[2]/td/div";
		String elementName="FinancialComparison Div";
		String msg="Verify FinancialComparison Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		click(By.linkText("Next"));
		return vr;			
	}
	
	public ValidationResult verifyClaimCountbyState()
	{
		String locator="//table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div";
		String elementName="ClaimCountbyState Div";
		String msg="Verify ClaimCountbyState Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		click(By.linkText("Next"));
		return vr;			
	}
	public ValidationResult verifyLegalProviderReport()
	{
		String locator="//table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div";
		String elementName="LegalProviderReport Div";
		String msg="Verify LegalProviderReport Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		click(By.linkText("Next"));
		return vr;			
	}
	public ValidationResult verifyWCScorecard()
	{
		String locator="//table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div";
		String elementName="WCScorecard Div";
		String msg="Verify WCScorecard Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		click(By.linkText("Next"));
		return vr;			
	}
	public ValidationResult verifyClaimCountbyAccidentType()
	{
		String locator="//table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div";
		String elementName="ClaimCountbyAccidentType Div";
		String msg="Verify ClaimCountbyAccidentType Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		click(By.linkText("Next"));
		return vr;			
	}
	public ValidationResult verifyClaimCountByBusinessUnit()
	{
		String locator="//table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div";
		String elementName="ClaimCountByBusinessUnit Div";
		String msg="Verify ClaimCountByBusinessUnit Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		click(By.linkText("Next"));
		return vr;			
	}
	public ValidationResult verifyClaimCountbyPartofBody()
	{
		String locator="//table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div";
		String elementName="ClaimCountbyPartofBody Div";
		String msg="Verify ClaimCountbyPartofBody Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		click(By.linkText("Next"));
		return vr;			
	}
}
