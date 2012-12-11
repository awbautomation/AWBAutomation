package com.awb.test.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.awb.test.core.util.AuthorName;
import com.awb.test.core.util.TestAuthor;
import com.awb.test.core.util.ValidationResult;
import com.awb.test.flows.HomeNavFlow;
import com.awb.test.pages.PortfolioWCPage;

@TestAuthor(name = AuthorName.SUMAN)
public class PortfolioWCTests extends TestBase {

	public void setup() throws Exception {

	}
	 @Test(description="Smoke test on PortfolioWC Page", groups = { "smoketest" })
	    public void testPortfolioWCPage() throws Exception {	
	    	          
	        
	        try {
	                                   
	        	if (homePage == null) { login(); }     
	        	PortfolioWCPage pw=HomeNavFlow.goToPortfolioWC(homePage);
	        	List<ValidationResult> vrList = pw.VerifyAllElementsInPage();
	        	printValidationResults(vrList);
	        	Assert.assertTrue(isValid(vrList), getFailedValidations(vrList));   	 
	        }
	        catch(Exception e) { throw e; }
	        finally { }    
	    }

}
