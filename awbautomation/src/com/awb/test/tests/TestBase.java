package com.awb.test.tests;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.awb.test.pages.HomePage;
import com.awb.test.pages.base.AWBBasePage;
import com.awb.test.pages.base.LoginPage;
import com.awb.test.core.util.ConsoleValidationResultPrinter;
import com.awb.test.core.util.IValidationResultPrinter;
import com.awb.test.core.util.ValidationResult;
import com.awb.test.core.util.AuthorName;
import com.awb.test.core.util.TestAuthor;
import com.awb.test.core.util.ThreadLocalValidationResultsHolder;
import com.thoughtworks.selenium.SeleneseTestCase;


/*
 *  @author sshyamala
 * This class is to be extended from actual test classes. It provides functionalities that is common to all test cases (eg. login)
 */
public class TestBase extends SeleneseTestCase {
	
	protected static Logger log = Logger.getLogger(TestBase.class);
	
	/** All tests will start from the Home Page and after test completes it must return back to Home Page
	 *  Since we are re-using the browser, we have to do this, so all tests start from a known state 
	 */
	protected HomePage homePage = null;
	 
	/** Flaged to signify that the test passed.
	 *  If test didn't pass, at the end of the test, 
	 *  we will close the browser so that the next test will start new
	 */
	protected boolean testPassed = false;
	protected Method currentMethod;
	
	
	/**
	 * Set the testPassed to true to signify test passed and go to Home Page
	 * This must be invoked at the end of each tests.	 
	 * @param page
	 */
	public void setTestPassed(AWBBasePage page) {
		if (page instanceof HomePage)
			homePage = (HomePage)page;
		else
		{
			page.goHome();
			homePage = new HomePage(page);
		}
		
		testPassed = true; 
	}
	
	/**
     * This method is ran before each test method
     */
    @BeforeMethod(alwaysRun=true)
    public void runBeforeTest() { testPassed = false; }
    
    /**
     * This method is ran after each test method
     */
    @AfterMethod(alwaysRun=true)
    public void runAfterTest() {
    	    	        	    	
    	// If test did not pass, close the browser so that the next test can start new. 
    	// We do not know the state in which the test fails at. This is to prevent test interference. 
    	if (!testPassed && homePage!=null)
    	{
    		homePage.stop();
    		homePage = null;
    	}
    }
    
    /**
     * This method is ran after all tests are completed in this class
     */
    @AfterClass(alwaysRun=true)
    public void tearDown() {
                
        
        
    }
    @SuppressWarnings("unchecked")
    @BeforeMethod(alwaysRun = true)
    public void storeMethod(Method method) throws ClassNotFoundException {
	com.awb.test.core.util.ThreadLocalValidationResultsHolder.getValidationResultHolder()
		.setTestName(
			method.getDeclaringClass() + "_" + method.getName());
	Class authorCls = Class
		.forName("com.awb.test.core.util.TestAuthor");
	// Get author name on the method. If it is null, get the author name on
	// the class.
	TestAuthor author = (TestAuthor) method.getAnnotation(authorCls);
	if (author == null) {
	    author = (TestAuthor) method.getDeclaringClass().getAnnotation(
		    authorCls);
	}
	// If author info is set either on the class or on the method, populate
	// the author in validation result holder.
	if (author != null) {
	    ThreadLocalValidationResultsHolder.getValidationResultHolder()
		    .setAuthor(author.name());
	} else
	// The author is not specified.
	{
	    ThreadLocalValidationResultsHolder.getValidationResultHolder()
		    .setAuthor(AuthorName.UNSPECIFIED);
	}
	currentMethod = method;
    }
   
    /**
     * login to cmc application, username/password defaulted from properties config
     * @throws Exception
     */
	protected void login() throws Exception {
		
		if (homePage != null) return;		
		LoginPage loginPage = new LoginPage();				
		homePage = new HomePage(loginPage);					
	}
	public void printValidationResults(List<ValidationResult> lvr) {
		if (lvr != null) {
		    IValidationResultPrinter vrp = new ConsoleValidationResultPrinter();
		    vrp.printValidationResult(lvr, currentMethod);
		}
	    }
	 public Method getCurrentMethod() {
			return currentMethod;
		    }
	 public boolean isValid(List<ValidationResult> lvr) {
			if (lvr != null) {
			    for (ValidationResult vres : lvr) {
				if (vres != null)
				    if (!vres.isValid())
					return false;
			    }
			}
			return true;
		    }
	 public String getFailedValidations(List<ValidationResult> lvr) {
			StringWriter sw = new StringWriter(1000);
			PrintWriter pw = new PrintWriter(sw);
			if (lvr != null) {
			    Iterator<ValidationResult> vrItr = lvr.iterator();
			    while (vrItr.hasNext()) {
				ValidationResult vr = vrItr.next();
				if (vr != null) {
				    pw.print(vr.failedValidationsToString());
				}
			    }
			}
			return sw.toString();
		    }

}
