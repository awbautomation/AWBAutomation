package com.awb.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.awb.test.core.pages.BasePage;
import com.awb.test.core.util.ValidationResult;
import com.awb.test.pages.base.AWBObjectPage;

public class PortfolioWCPage extends AWBObjectPage{
	public PortfolioWCPage()
	{
		
	}
	public PortfolioWCPage(BasePage basePage) {
		
		inheritSession(basePage);
		waitForPageToLoad(getTimeout());
						
		validate();
	}
	
	/**
	 * Validate that we are on the Portfolio WC page
	 */
	public void validate() {

		super.validate();
		
		assertTitle("Portfolio WC");
		
	}
	public List<ValidationResult>VerifyAllElementsInPage()
	{
		List<ValidationResult> vrList = new ArrayList<ValidationResult>();
		ValidationResult vr_po=verifyOpenClaims();
		vrList.add(vr_po);
		ValidationResult vr_ad=verifyTotalLitigatedClaims();
		vrList.add(vr_ad);
		ValidationResult vr_in=verifyAverageClaimDuration();
		vrList.add(vr_in);
		ValidationResult vr_re=verifyAverageReportingLagTime();
		vrList.add(vr_re);	
		ValidationResult vr_cs=verifyWCClaimSynopsis();
		vrList.add(vr_cs);
		ValidationResult vr_cb=verifyWCTotalIncurredByCostBreakdown();
		vrList.add(vr_cb);
		ValidationResult vr_pc=verifyIndemnityAmountByPaymentCode();
		vrList.add(vr_pc);
		ValidationResult vr_apc=verifyMedicalAmountByPaymentCode();
		vrList.add(vr_apc);
		ValidationResult vr_epc=verifyExpenseAmountByPaymentCode();
		vrList.add(vr_epc);
		ValidationResult vr_nc=verifyTopNewClaims();
		vrList.add(vr_nc);
		ValidationResult vr_rc=verifyTopReserveChanges();
		vrList.add(vr_rc);		
		return vrList;   	
	}
	public ValidationResult verifyOpenClaims()
	{
		String locator="//table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/div";
		String elementName="openClaims Div";
		String msg="Verify openClaims Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyTotalLitigatedClaims()
	{
		String locator="//table/tbody/tr/td[5]/table/tbody/tr[2]/td/div";
		String elementName="TotalLitigatedClaims Div";
		String msg="Verify TotalLitigatedClaims Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyAverageClaimDuration()
	{
		String locator="//table/tbody/tr[2]/td/table/tbody/tr/td[7]/table/tbody/tr[2]/td/div";
		String elementName="AverageClaimDuration Div";
		String msg="Verify AverageClaimDuration Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyAverageReportingLagTime()
	{
		String locator="//table/tbody/tr[2]/td/table/tbody/tr/td[9]/table/tbody/tr[2]/td/div";
		String elementName="AverageReportingLagTime Div";
		String msg="Verify AverageReportingLagTime Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyWCClaimSynopsis()
	{
		String locator="//table/tbody/tr/td/table/tbody/tr[2]/td/div";
		String elementName="WCClaimSynopsis Div";
		String msg="Verify WCClaimSynopsis Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyWCTotalIncurredByCostBreakdown()
	{
		String locator="//table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr[2]/td/div";
		String elementName="WCTotalIncurredByCostBreakdown Div";
		String msg="Verify WCTotalIncurredByCostBreakdown Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyIndemnityAmountByPaymentCode()
	{
		String locator="//table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div";
		String elementName="IndemnityAmountByPaymentCode Div";
		String msg="Verify IndemnityAmountByPaymentCode Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyMedicalAmountByPaymentCode()
	{
		String locator="//table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/div";
		String elementName="MedicalAmountByPaymentCode Div";
		String msg="Verify MedicalAmountByPaymentCode Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyExpenseAmountByPaymentCode()
	{
		String locator="//table/tbody/tr[4]/td/table/tbody/tr/td[5]/table/tbody/tr[2]/td/div";
		String elementName="ExpenseAmountByPaymentCode Div";
		String msg="Verify ExpenseAmountByPaymentCode Div";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyTopNewClaims()
	{
		String locator="//*[@id='divGrid1']";
		String elementName="TopNewClaims grid";
		String msg="Verify TopNewClaims Grid";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyTopReserveChanges()
	{
		String locator="//*[@id='divGrid3']";
		String elementName="TopReserveChanges grid";
		String msg="Verify TopReserveChanges Grid";
		ValidationResult vr = new ValidationResult(locator, elementName);
		boolean check=isElementPresent(By.xpath(locator));	
		vr.addValidation(check, msg);
		return vr;			
	}
}
