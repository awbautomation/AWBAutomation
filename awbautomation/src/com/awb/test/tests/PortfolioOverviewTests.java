package com.awb.test.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.awb.test.flows.HomeNavFlow;
import com.awb.test.pages.PortfolioOverviewPage;
import com.awb.test.tests.TestBase;
import com.awb.test.core.util.AuthorName;
import com.awb.test.core.util.TestAuthor;
import com.awb.test.core.util.ValidationResult;


@TestAuthor(name = AuthorName.SUMAN)
public class PortfolioOverviewTests extends TestBase {
	public void setup() throws Exception {
        
	       
    }
      
   
    @Test(description="Smoke test on PortfolioOverview Page", groups = { "smoketest" })
    public void testPortfolioOverviewPage() throws Exception {
	
    	//setup();                
        
        try {
                                   
        	if (homePage == null) { login(); }     
        	PortfolioOverviewPage po=HomeNavFlow.goToPortfolioOverview(homePage);
        	List<ValidationResult> vrList = po.VerifyAllElementsInPage();
        	printValidationResults(vrList);
        	Assert.assertTrue(isValid(vrList), getFailedValidations(vrList));   	 
        }
        catch(Exception e) { throw e; }
        finally { }    
    }

}
