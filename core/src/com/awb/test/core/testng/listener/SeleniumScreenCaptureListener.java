package com.awb.test.core.testng.listener;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.awb.test.core.util.CommonSelenium;
import com.awb.test.core.util.ScreenshotCapture;
import com.awb.test.core.util.Utils;

/**
 * This class is added to testng task to listen for events.
 * 
 * One of things it does it take a screenshot when a test fails.
 * 
 * It uses the selenium screen capture feature, and captures only
 * what the user sees in the browser.
 * 
 * Beware: this may work some selenium implementations and/or 
 * combination of browsers.
 * 
 * It may be useful to also to turn off the default listeners.
 * 
 * Example usage:
 * 
 * <pre>
 * <testng outputdir="results/" groups="calendar" useDefaultListeners="true"
                listener="org.uncommons.reportng.HTMLReporter,org.uncommons.reportng.JUnitXMLReporter,com.epocrates.test.core.testng.listener.SeleniumScreenCaptureListener">
 * </pre>
 * 
 * @author sshyamala
 */
public class SeleniumScreenCaptureListener extends TestListenerAdapter {
    
    /**
     *  logging object, logging conf is defined in conf/log4j.properties
     */
    protected static Logger log = Logger.getLogger(SeleniumScreenCaptureListener.class);
    
    /**
     * testng utils class
     */
    private TestNGUtils testNGUtils = new TestNGUtils();
    
    /**
     * utils class
     */
    private Utils utils = new Utils();
    
    /**
     * div id number. needed for selenium command list toggle.
     */
    private int divIdNumber = 0;
    
    /*
     * logdiv prefix. needed for selenium command list toggle.
     */
    //private final String DIVIDPREFIX = "logdiv"; 
   
    /**
     * Do actions after a test case execution failure.
     * 
     * @param result 
     */
    @Override
    public void onTestFailure(ITestResult result) { if(utils.doReportingOnTestFail()) doReporting(result); }

    /**
     * Do actions after a test case execution skipped.
     * 
     * @param result 
     */
    @Override
    public void onTestSkipped(ITestResult result) { }

    /**
     * Do actions after a test case execution success (no reported fail
     * during test case execution).
     * 
     * @param result 
     */
    @Override
    public void onTestSuccess(ITestResult result) { if(utils.doReportingOnTestSuccess()) doReporting(result); }
   
    /**
     * This method is invoked after all the tests have run and all their Configuration methods have been called.
     */
    @Override
    public void onFinish(ITestContext context) { 
    	if (testNGUtils.capturePageLoadPerformance())
    	{
	    	try {	    			    		
	    		testNGUtils.savePageSummaryPerformance(utils.getBasePagePerformanceDirectory());
	    	}
	        catch(Exception e) { log.error(e); }
    	}
    }
    
    
    /**
     * This method does all reporting into TestNG/ReportsNG.
     * 
     * @param result 
     */
    private void doReporting(ITestResult result) {
            
        try {
           
            String path = utils.getBaseScreenshotsDirectory();
           
            String screenshotFilename = path + utils.getFirstToken(result.getName(), " ") + Long.toHexString( System.currentTimeMillis()) + "." + ScreenshotCapture.PNG;
        
            createScreenshot(screenshotFilename);
            testNGUtils.appendToReport(result, screenshotFilename, divIdNumber++);
       
        }
        catch(Exception e) { log.error(e); }
   
    }
    
    /**
     * Create the screenshot in JPG format.
     * 
     * @param screenshotFilename the name of the screenshot image file
     * 
     * @throws Exception 
     */ 
    private void createScreenshot(String screenshotFilename) throws Exception {
       
        try { 
           
            log.debug("Filename to save screenshot to: " + screenshotFilename + "|" + CommonSelenium.getInstance().getSelenium());
            //CommonSelenium.getInstance().getSelenium().captureEntirePageScreenshot(screenshotFilename, ""); 
           // File scrFile =((TakesScreenshot)CommonSelenium.getInstance().getSelenium()).getScreenshotAs(OutputType.FILE);
           // FileUtils.copyFile(scrFile, new File(screenshotFilename));
           
        }
        catch(Exception e) { throw e; }
       
   }
   
}