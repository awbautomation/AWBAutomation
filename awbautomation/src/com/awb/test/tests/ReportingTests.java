package com.awb.test.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.awb.test.core.util.AuthorName;
import com.awb.test.core.util.TestAuthor;
import com.awb.test.core.util.ValidationResult;
import com.awb.test.flows.HomeNavFlow;
import com.awb.test.pages.ReportingPage;

@TestAuthor(name = AuthorName.SUMAN)
public class ReportingTests extends TestBase {

	public void setup() throws Exception {

	}
	 @Test(description="Smoke test on Reporting Page", groups = { "smoketest" })
	    public void testReportingPage() throws Exception {	    	       
	        
	        try {
	                                   
	        	if (homePage == null) { login(); }     
	        	ReportingPage re=HomeNavFlow.goToReporting(homePage);
	        	List<ValidationResult> vrList = re.VerifyAllElementsInPage();
	        	printValidationResults(vrList);
	        	Assert.assertTrue(isValid(vrList), getFailedValidations(vrList));   	 
	        }
	        catch(Exception e) { throw e; }
	        finally { }    
	    }
}
