package com.awb.test.core.testng.listener;

import java.io.File;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import com.awb.test.core.util.ScreenshotCapture;


/**
 * This class is added to testng task to listen for events.
 * 
 * One of things it does it take a screenshot when a test fails.
 * 
 * Example usage:
 * 
 * <pre>
 * <testng outputdir="results/" groups="calendar" useDefaultListeners="true"
                listener="org.uncommons.reportng.HTMLReporter,org.uncommons.reportng.JUnitXMLReporter,com.epocrates.test.core.testng.listener.TestNGListener">
 * </pre>
 * 
 * @author sshyamala
 */
public class TestNGListener extends TestListenerAdapter {
    
    /**
     * The screenshots directory
     */
    private final String SCREENSHOTS_DIR = "screenshots";
    
    /**
     *  logging object, logging conf is defined in conf/log4j.properties
     */
    protected static Logger log = Logger.getLogger(TestNGListener.class);

   @Override
   public void onTestFailure(ITestResult result) {

       try {
 
           ScreenshotCapture screenshotCapture = new ScreenshotCapture();
           
           File file = new File("");
           
           String path = file.getAbsolutePath();
           
           String screenshotFileLocation = "file:///" + path + File.separator + SCREENSHOTS_DIR + File.separator + result.getName() + "." + ScreenshotCapture.JPG;
           
           log.debug("Failed test case screenshot file location: " + screenshotFileLocation);
           
           screenshotCapture.doScreenshot(path + File.separator + SCREENSHOTS_DIR + File.separator + result.getName(), ScreenshotCapture.JPG);
           
           Reporter.setCurrentTestResult(result);
           //System.out.println(file.getAbsolutePath());
           //Reporter.log(file.getAbsolutePath() + "<p>");
           //Reporter.log(screenshotFileLocation + "<p>");

           Object[] parameters = result.getParameters();
           Reporter.log("<p><font face=arial size=2 color=000099");
           if(parameters.length > 0) Reporter.log("<p>Total number of input parameters: " + parameters.length + "<p>");
           
           for(int i = 0; i < parameters.length; i++) {
               Reporter.log("Parameter: " + parameters[i]);
           }
           
           //Reporter.log("<p>Failed test case screenshot saved at screenshots/" + result.getName() + "." + ScreenshotCapture.JPG);
           Reporter.log("<b>Screenshot</b><br>");
           Reporter.log("<p><a href='" + screenshotFileLocation + "'>" +
                   "<img src='" + screenshotFileLocation + "' height='100' width='100'/></a>");
           Reporter.log("<p>");   
           Reporter.log("<font size=1>Click thumbnail image to view screenshot</font><p><br></font>");
               
           Reporter.setCurrentTestResult(null);
           
       }
       catch(Exception e) { log.error(e); }

   }


   @Override
   public void onTestSkipped(ITestResult result) { }

   @Override
   public void onTestSuccess(ITestResult result) { 
   
       /*
       File file = new File("");
           
       String path = file.getAbsolutePath();
           
       String screenshotFileLocation = path + "/" + SCREENSHOTS_DIR + "/" + String.valueOf(count) + "." + ScreenshotCapture.PNG;
       count++;
           
       log.debug("Filename to save screenshot to: " + screenshotFileLocation + "|" + CommonSelenium.getInstance().getSelenium());
       
       try { CommonSelenium.getInstance().getSelenium().captureEntirePageScreenshot(screenshotFileLocation, ""); }
       catch(Exception e) { log.error(e); }
   */
       try {
 
           ScreenshotCapture screenshotCapture = new ScreenshotCapture();
           
           File file = new File("");
           
           String path = file.getAbsolutePath();
           
           String screenshotFileLocation = "file:///" + path + File.separator + SCREENSHOTS_DIR + File.separator + result.getName() + "." + ScreenshotCapture.JPG;
           
           log.debug("Success test case screenshot file location: " + screenshotFileLocation);
           
           screenshotCapture.doScreenshot(path + File.separator + SCREENSHOTS_DIR + File.separator + result.getName(), ScreenshotCapture.JPG);
           
           Reporter.setCurrentTestResult(result);
           //System.out.println(file.getAbsolutePath());
           //Reporter.log(file.getAbsolutePath() + "<p>");
           //Reporter.log(screenshotFileLocation + "<p>");

           Object[] parameters = result.getParameters();
           Reporter.log("<p><font face=arial size=2 color=000099");
           if(parameters.length > 0) Reporter.log("<p>Total number of input parameters: " + parameters.length + "<p>");
           
           for(int i = 0; i < parameters.length; i++) {
               Reporter.log("Parameter: " + parameters[i]);
           }
           
           //Reporter.log("<p>Success test case screenshot saved at screenshots/" + result.getName() + "." + ScreenshotCapture.JPG);
           Reporter.log("<b>Screenshot</b><br>");
           Reporter.log("<p><a href='" + screenshotFileLocation + "'>" +
                   "<img src='" + screenshotFileLocation + "' height='100' width='100'/></a>");
           Reporter.log("<p>");   
           Reporter.log("<font size=1>Click thumbnail image to view screenshot</font><p><br></font>");
               
           Reporter.setCurrentTestResult(null);
           
       }
       catch(Exception e) { log.error(e); }
   }

   
}



