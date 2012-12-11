package com.awb.test.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.awb.test.core.util.AuthorName;
import com.awb.test.core.util.TestAuthor;
import com.awb.test.core.util.ValidationResult;
import com.awb.test.flows.HomeNavFlow;
import com.awb.test.pages.SearchPage;

@TestAuthor(name = AuthorName.SUMAN)
public class SearchTests extends TestBase {

	public void setup() throws Exception {

	}
	 @Test(description="Smoke test on Search Page", groups = { "smoketest" })
	    public void testSearchPage() throws Exception {	    	       
	        
	        try {
	                                   
	        	if (homePage == null) { login(); }     
	        	SearchPage se=HomeNavFlow.goToSearchPage(homePage);
	        	List<ValidationResult> vrList = se.VerifyAllElementsInPage();
	        	printValidationResults(vrList);
	        	Assert.assertTrue(isValid(vrList), getFailedValidations(vrList));   	 
	        }
	        catch(Exception e) { throw e; }
	        finally { }    
	    }
}
