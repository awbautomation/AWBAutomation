package com.awb.test.pages;

import java.util.ArrayList;
import java.util.List;

import com.awb.test.pages.base.AWBBasePage;
import com.awb.test.core.pages.BasePage;
import com.awb.test.core.util.ValidationResult;

import org.openqa.selenium.By;

/**
 * This page models the AWB home page. This is where the user lands after successful login.
 * 
 * @author sshyamala
 *
 */
public class HomePage extends AWBBasePage{

	public HomePage(BasePage basePage) {
		
		inheritSession(basePage);
		waitForPageToLoad(getTimeout());
						
		validate();
	}
	
	/**
	 * Validate that we are on the Home page
	 */
	public void validate() {

		super.validate();
		
		assertTitle("Home");
		
	}
	public List<ValidationResult>VerifyAllNavigations()
	{
		List<ValidationResult> vrList = new ArrayList<ValidationResult>();
		ValidationResult vr_po=verifyPortfolioOverview();
		vrList.add(vr_po);
		ValidationResult vr_ad=verifyAdhocAnalysis();
		vrList.add(vr_ad);
		ValidationResult vr_in=verifyInsights();
		vrList.add(vr_in);
		ValidationResult vr_re=verifyReporting();
		vrList.add(vr_re);
		ValidationResult vr_se=verifySearchPage();
		vrList.add(vr_se);
		//ValidationResult vr_pw=verifyPortfolioWC();
		//vrList.add(vr_pw);		
		return vrList;    	
	}
	public ValidationResult verifyPortfolioOverview()
	{
		String locator="//div[@id='awbTabContainer']/ul/li[2]/a/span";
		String elementName="PortfolioOverview Link";
		String msg="Click PortfolioOverview Tab";
		ValidationResult vr = new ValidationResult(locator, elementName);
		click(By.xpath(locator));
		boolean check=verifyTitle("Portfolio Overview");	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyAdhocAnalysis()
	{
		String locator="//div[@id='awbTabContainer']/ul/li[4]/a/span";
		String elementName="AdhocAnalysis Tab";
		String msg="Clicking AdhocAnalysis Tab";
		ValidationResult vr = new ValidationResult(locator, elementName);
		click(By.xpath(locator));
		boolean check=verifyTitle("Adhoc Analysis");	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyInsights()
	{
		String locator="//div[@id='awbTabContainer']/ul/li[3]/a/span";
		String elementName="Insights Tab";
		String msg="Clicking Insights Tab";
		ValidationResult vr = new ValidationResult(locator, elementName);
		click(By.xpath(locator));
		boolean check=verifyTitle("Insights");	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyReporting()
	{
		String locator="//div[@id='awbTabContainer']/ul/li[5]/a/span";
		String elementName="Reporting Tab";
		String msg="Clicking Reporting Tab";
		ValidationResult vr = new ValidationResult(locator, elementName);
		click(By.xpath(locator));
		boolean check=verifyTitle("Reporting");	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifySearchPage()
	{
		String locator="//div[@id='awbTabContainer']/ul/li[6]/a/span";
		String elementName="Search Tab";
		String msg="Clicking Search Tab";
		ValidationResult vr = new ValidationResult(locator, elementName);
		click(By.xpath(locator));
		boolean check=verifyTitle("Pages - Search");	
		vr.addValidation(check, msg);
		return vr;			
	}
	public ValidationResult verifyPortfolioWC()
	{
		String locator="//div[@id='awbTabContainer']/ul/li[2]/ul/li[2]/a/span";
		String elementName="PortfolioWC Tab";
		String msg="Clicking PortfolioWC Tab";
		ValidationResult vr = new ValidationResult(locator, elementName);
		click(By.xpath(locator));
		boolean check=verifyTitle("Portfolio WC");	
		vr.addValidation(check, msg);
		return vr;			
	}
	public List<ValidationResult> VerifyWCBenefitsByStateLink()
	{
		List<ValidationResult> vrList = new ArrayList<ValidationResult>();
		ValidationResult vr_OR=VerifyWCBenefitsByStateLink_OR();
		vrList.add(vr_OR);	
		ValidationResult vr_WA=VerifyWCBenefitsByStateLink_WA();
		vrList.add(vr_WA);	
		ValidationResult vr_CA=VerifyWCBenefitsByStateLink_CA();
		vrList.add(vr_CA);
		ValidationResult vr_MT=VerifyWCBenefitsByStateLink_MT();
		vrList.add(vr_MT);
		ValidationResult vr_ID=VerifyWCBenefitsByStateLink_ID();
		vrList.add(vr_ID);
		ValidationResult vr_NV=VerifyWCBenefitsByStateLink_NV();
		vrList.add(vr_NV);
		ValidationResult vr_AZ=VerifyWCBenefitsByStateLink_AZ();
		vrList.add(vr_AZ);
		ValidationResult vr_WY=VerifyWCBenefitsByStateLink_WY();
		vrList.add(vr_WY);
		ValidationResult vr_UT=VerifyWCBenefitsByStateLink_UT();
		vrList.add(vr_UT);
		ValidationResult vr_NM=VerifyWCBenefitsByStateLink_NM();
		vrList.add(vr_NM);
		ValidationResult vr_CO=VerifyWCBenefitsByStateLink_CO();
		vrList.add(vr_CO);
		ValidationResult vr_TX=VerifyWCBenefitsByStateLink_TX();
		vrList.add(vr_TX);
		ValidationResult vr_OK=VerifyWCBenefitsByStateLink_OK();
		vrList.add(vr_OK);
		ValidationResult vr_KS=VerifyWCBenefitsByStateLink_KS();
		vrList.add(vr_KS);
		ValidationResult vr_NE=VerifyWCBenefitsByStateLink_NE();
		vrList.add(vr_NE);
		ValidationResult vr_SD=VerifyWCBenefitsByStateLink_SD();
		vrList.add(vr_SD);
		ValidationResult vr_ND=VerifyWCBenefitsByStateLink_ND();
		vrList.add(vr_ND);
		ValidationResult vr_MN=VerifyWCBenefitsByStateLink_MN();
		vrList.add(vr_MN);
		ValidationResult vr_IA=VerifyWCBenefitsByStateLink_IA();
		vrList.add(vr_IA);
		ValidationResult vr_MO=VerifyWCBenefitsByStateLink_MO();
		vrList.add(vr_MO);
		ValidationResult vr_AR=VerifyWCBenefitsByStateLink_AR();
		vrList.add(vr_AR);
		ValidationResult vr_LA=VerifyWCBenefitsByStateLink_LA();
		vrList.add(vr_LA);
		ValidationResult vr_MS=VerifyWCBenefitsByStateLink_MS();
		vrList.add(vr_MS);
		ValidationResult vr_AL=VerifyWCBenefitsByStateLink_AL();
		vrList.add(vr_AL);
		ValidationResult vr_TN=VerifyWCBenefitsByStateLink_TN();
		vrList.add(vr_TN);
		//ValidationResult vr_KY=VerifyWCBenefitsByStateLink_KY();
		//vrList.add(vr_KY);
		ValidationResult vr_IN=VerifyWCBenefitsByStateLink_IN();
		vrList.add(vr_IN);
		ValidationResult vr_MI=VerifyWCBenefitsByStateLink_MI();
		vrList.add(vr_MI);
		ValidationResult vr_OH=VerifyWCBenefitsByStateLink_OH();
		vrList.add(vr_OH);
		ValidationResult vr_WV=VerifyWCBenefitsByStateLink_WV();
		vrList.add(vr_WV);
		ValidationResult vr_VA=VerifyWCBenefitsByStateLink_VA();
		vrList.add(vr_VA);
		ValidationResult vr_PA=VerifyWCBenefitsByStateLink_PA();
		vrList.add(vr_PA);
		ValidationResult vr_NY=VerifyWCBenefitsByStateLink_NY();
		vrList.add(vr_NY);
		//ValidationResult vr_VT=VerifyWCBenefitsByStateLink_VT();
		//vrList.add(vr_VT);
		ValidationResult vr_NH=VerifyWCBenefitsByStateLink_NH();
		vrList.add(vr_NH);
		ValidationResult vr_ME=VerifyWCBenefitsByStateLink_ME();
		vrList.add(vr_ME);
		ValidationResult vr_MA=VerifyWCBenefitsByStateLink_MA();
		vrList.add(vr_MA);
		ValidationResult vr_CT=VerifyWCBenefitsByStateLink_CT();
		vrList.add(vr_CT);
		ValidationResult vr_NJ=VerifyWCBenefitsByStateLink_NJ();
		vrList.add(vr_NJ);
		ValidationResult vr_MD=VerifyWCBenefitsByStateLink_MD();
		vrList.add(vr_MD);
		ValidationResult vr_NC=VerifyWCBenefitsByStateLink_NC();
		vrList.add(vr_NC);
		ValidationResult vr_SC=VerifyWCBenefitsByStateLink_SC();
		vrList.add(vr_SC);
		ValidationResult vr_GA=VerifyWCBenefitsByStateLink_GA();
		vrList.add(vr_GA);
		ValidationResult vr_FL=VerifyWCBenefitsByStateLink_FL();
		vrList.add(vr_FL);
		ValidationResult vr_HI=VerifyWCBenefitsByStateLink_HI();
		vrList.add(vr_HI);
		ValidationResult vr_AK=VerifyWCBenefitsByStateLink_AK();
		vrList.add(vr_AK);				
		return vrList;
		
	}
	public ValidationResult VerifyWCBenefitsByStateLink_OR()
	{
		String locator="jvectormap1_or";
		String elementName="OR Link";
		String msg="Click OR link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Oregon Workers' Compensation Division");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;		
		
	}
	public ValidationResult VerifyWCBenefitsByStateLink_WA()
	{
		String locator="jvectormap1_wa";
		String elementName="WA Link";
		String msg="Click WA link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Labor & Industries (L&I), Washington State");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;			
	}
	public ValidationResult VerifyWCBenefitsByStateLink_CA()
	{
		String locator="jvectormap1_ca";
		String elementName="CA Link";
		String msg="Click CA link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("DWC homepage");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_MT()
	{
		String locator="jvectormap1_mt";
		String elementName="MT Link";
		String msg="Click MT link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Workers' Compensation Court Home Page");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_ID()
	{
		String locator="jvectormap1_id";
		String elementName="ID Link";
		String msg="Click ID link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Industrial Commission Forms");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_NV()
	{
		String locator="jvectormap1_nv";
		String elementName="NV Link";
		String msg="Click NV link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("State of Nevada -");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_AZ()
	{
		String locator="jvectormap1_az";
		String elementName="AZ Link";
		String msg="Click AZ link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Workers Compensation - Workmans Comp Service Center");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_WY()
	{
		String locator="jvectormap1_wy";
		String elementName="WY Link";
		String msg="Click WY link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Workers' Compensation Home");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_UT()
	{
		String locator="jvectormap1_ut";
		String elementName="UT Link";
		String msg="Click UT link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Utah Labor Commission");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_NM()
	{
		String locator="jvectormap1_nm";
		String elementName="NM Link";
		String msg="Click NM link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("New Mexico Workers Compensation Administration");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_CO()
	{
		String locator="jvectormap1_co";
		String elementName="CO Link";
		String msg="Click CO link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("CDLE - Work Comp:");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_TX()
	{
		String locator="jvectormap1_tx";
		String elementName="TX Link";
		String msg="Click TX link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Texas Workforce Commission - Workforce and Unemployment Resources");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_OK()
	{
		String locator="jvectormap1_ok";
		String elementName="OK Link";
		String msg="Click OK link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Workers Compensation - Workmans Comp Service Center");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_KS()
	{
		String locator="jvectormap1_ks";
		String elementName="KS Link";
		String msg="Click KS link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Kansas Department of Labor");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_NE()
	{
		String locator="jvectormap1_ne";
		String elementName="NE Link";
		String msg="Click NE link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Nebraska Workers' Compensation Court - Homepage");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_SD()
	{
		String locator="jvectormap1_sd";
		String elementName="SD Link";
		String msg="Click SD link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("South Dakota Department of Labor and Regulation - Workers' Compensation");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_ND()
	{
		String locator="jvectormap1_nd";
		String elementName="ND Link";
		String msg="Click ND link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("WSI: Welcome to Workforce Safety & Insurance");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_MN()
	{
		String locator="jvectormap1_mn";
		String elementName="MN Link";
		String msg="Click MN link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Workers' Compensation - Minnesota Department of Labor and Industry");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_IA()
	{
		String locator="jvectormap1_ia";
		String elementName="IA Link";
		String msg="Click IA link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Division of Workers' Compensation - Iowa Workforce Development Site");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_MO()
	{
		String locator="jvectormap1_mo";
		String elementName="MO Link";
		String msg="Click MO link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Missouri Labor | Workers' Compensation");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_AR()
	{
		String locator="jvectormap1_ar";
		String elementName="AR Link";
		String msg="Click AR link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Arkansas Workers' Compensation Commission");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_LA()
	{
		String locator="jvectormap1_la";
		String elementName="LA Link";
		String msg="Click LA link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Workers' Compensation for Employers - Louisiana Workforce Commission");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_MS()
	{
		String locator="jvectormap1_ms";
		String elementName="MS Link";
		String msg="Click MS link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Mississippi Workers' Compensation Commission");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_AL()
	{
		String locator="jvectormap1_al";
		String elementName="AL Link";
		String msg="Click AL link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Alabama Department of Labor - Workers' Compensation Home");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_TN()
	{
		String locator="jvectormap1_tn";
		String elementName="TN Link";
		String msg="Click TN link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Tennessee Department of Labor and Workforce Development");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_KY()
	{
		String locator="jvectormap1_ky";
		String elementName="KY Link";
		String msg="Click KY link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle(" ");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_IN()
	{
		String locator="jvectormap1_in";
		String elementName="IN Link";
		String msg="Click IN link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("WCB: Home");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_MI()
	{
		String locator="jvectormap1_mi";
		String elementName="MI Link";
		String msg="Click MI link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("WCA - Workers' Compensation Agency");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_OH()
	{
		String locator="jvectormap1_oh";
		String elementName="OH Link";
		String msg="Click OH link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Injured Worker");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_WV()
	{
		String locator="jvectormap1_wv";
		String elementName="WV Link";
		String msg="Click WV link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Workers' Compensation");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_VA()
	{
		String locator="jvectormap1_va";
		String elementName="VA Link";
		String msg="Click VA link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Virginia Workers' Compensation Commission");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_PA()
	{
		String locator="jvectormap1_pa";
		String elementName="PA Link";
		String msg="Click PA link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("L&I Home");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_NY()
	{
		String locator="jvectormap1_ny";
		String elementName="NY Link";
		String msg="Click NY link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("WCB Home Page");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_VT()
	{
		String locator="jvectormap1_vt";
		String elementName="VT Link";
		String msg="Click VT link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle(" ");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_NH()
	{
		String locator="jvectormap1_nh";
		String elementName="NH Link";
		String msg="Click NH link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Welcome | NH Department of Labor");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_ME()
	{
		String locator="jvectormap1_me";
		String elementName="ME Link";
		String msg="Click ME link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Maine Workers' Compensation Board");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_MA()
	{
		String locator="jvectormap1_ma";
		String elementName="MA Link";
		String msg="Click MA link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Worker's Compensation");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_CT()
	{
		String locator="jvectormap1_ct";
		String elementName="CT Link";
		String msg="Click CT link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("State of Connecticut Workers’ Compensation Commission");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_NJ()
	{
		String locator="jvectormap1_nj";
		String elementName="NJ Link";
		String msg="Click NJ link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Department of Labor and Workforce Development | Workers' Compensation");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_MD()
	{
		String locator="jvectormap1_md";
		String elementName="MD Link";
		String msg="Click MD link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle(" Maryland Workers' Compensation Commission");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_NC()
	{
		String locator="jvectormap1_nc";
		String elementName="NC Link";
		String msg="Click NC link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("NC Industrial Commission Home Page");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_SC()
	{
		String locator="jvectormap1_sc";
		String elementName="SC Link";
		String msg="Click SC link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Workers Compensation Commission - Home");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_GA()
	{
		String locator="jvectormap1_ga";
		String elementName="GA Link";
		String msg="Click GA link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("State Board of Workers' Compensation");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_FL()
	{
		String locator="jvectormap1_fl";
		String elementName="FL Link";
		String msg="Click FL link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("Florida Division of Workers' Compensation");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_HI()
	{
		String locator="jvectormap1_hi";
		String elementName="HI Link";
		String msg="Click HI link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("About Workers' Compensation — Department of Labor and Industrial Relations");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	public ValidationResult VerifyWCBenefitsByStateLink_AK()
	{
		String locator="jvectormap1_ak";
		String elementName="AK Link";
		String msg="Click AK link";
		ValidationResult vr = new ValidationResult(locator, elementName);
		String oldWid=getWindowId();
		String newWid=clickPopUp(By.id(locator));
		openWindow(newWid);
		boolean check=verifyTitle("DOLWD Division of Workers' Compensation");	
		vr.addValidation(check, msg);
		switchTo(oldWid);
		return vr;				
	}
	
	
	public void ClickPortfolioOverviewLink() {
		//waitForPageToLoad(getTimeout());
		click(By.xpath("//div[@id='awbTabContainer']/ul/li[2]/a/span"));
		//waitForPageToLoad(getTimeout());
	}
	public void ClickPortfolioWCLink() {
		click(By.xpath("//div[@id='awbTabContainer']/ul/li[2]/a/span"));
		click(By.xpath("//div[@id='awbTabContainer']/ul/li[2]/ul/li[2]/a/span"));
		//waitForPageToLoad(getTimeout());
	}
	public void ClickInsightsLink() {
		click(By.xpath("//div[@id='awbTabContainer']/ul/li[3]/a/span"));
		//waitForPageToLoad(getTimeout());
	}
	public void ClickAdhocAnalysisLink() {
		click(By.xpath("//div[@id='awbTabContainer']/ul/li[4]/a/span"));
		//waitForPageToLoad(getTimeout());
	}
	public void ClickReportingLink() {
		click(By.xpath("//div[@id='awbTabContainer']/ul/li[5]/a/span"));
		//waitForPageToLoad(getTimeout());
	}
	public void ClickSearchLink() {
		click(By.xpath("//div[@id='awbTabContainer']/ul/li[6]/a/span"));
		//waitForPageToLoad(getTimeout());
	}
	
}
