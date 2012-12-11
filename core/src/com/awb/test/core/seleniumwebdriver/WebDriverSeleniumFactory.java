package com.awb.test.core.seleniumwebdriver;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.DefaultSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import com.opera.core.systems.OperaDriver;

/**
 * This class returns a class implementing selenium interface.
 * 
 * This includes:
 * 
 * 1) DefaultSelenium
 * 2) WebDriverBackedSelenium
 * 
 * WebDriverBackedSelenium implementation classes that can be obtained are:
 * 
 * 1) FirefoxDriver
 * 2) IEdriver
 * 3) OperaDriver
 * 4) HtmlUnitDriver
 * 5) iPhoneDriver
 * 6) AndroidDriver
 * 
 * @author sshyamala
 */
public class WebDriverSeleniumFactory {

    /**
     * DefaultSelenium identifier key
     */
    public static final String DEFAULT = "DEFAULT";
    
    /**
     * Firefox WebDriver identifier key
     */
    public static final String FIREFOXWEBDRIVER = "FIREFOXWEBDRIVER";
    
     /**
      * Internet Explorer (IE) WebDriver identifier key
      */
    public static final String IEWEBDRIVER = "IEWEBDRIVER";
    
     /**
      * Chrome WebDriver identifier key
      */
    public static final String CHROMEWEBDRIVER = "CHROMEWEBDRIVER";
    
     /**
      * Opera WebDriver identifier key
      */
    public static final String OPERAWEBDRIVER = "OPERAWEBDRIVER";
    
     /**
      * HtmlUnit WebDriver identifier key
      */
    public static final String HTMLUNITDRIVER = "HTMLUNITDRIVER";
    
    /**
     * Default Constructor.
     */
    public WebDriverSeleniumFactory() { }
    
    /**
     * Use this method to return an instance of Selenium using
     * DefaultSelenium implementation.
     * 
     * @param serverHost the host name on which the Selenium Server resides
     * @param serverPort the port on which the Selenium Server is listening
     * @param browserStartCommand the command string used to launch the browser, e.g. "*firefox",
     *        "*iexplore" or "c:\\program files\\internet explorer\\iexplore.exe"
     * @param browserURL the starting URL including just a domain name. We'll start the browser
     *        pointing at the Selenium resources on this URL, e.g. "http://www.google.com" would send
     *        the browser to "http://www.google.com/selenium-server/SeleneseRunner.html"
     * 
     * @return Instance of a Selenium implementation class DefaultSelenium
     * 
     * @throws Exception 
     */
    public Selenium getSelenium(String serverHost, int serverPort, String browserStartCommand, String browserURL) throws Exception {
        
        try {
            
            checkForNullInput(serverHost, browserStartCommand, browserURL);
            
            return new DefaultSelenium(serverHost, serverPort, browserStartCommand, browserURL);
            
        }
        catch(Exception e) { throw e; }
    }
    
    /**
     * Use this constructor if you want to get an implementation of Selenium
     * using a WebDriver.
     * 
     * @param webDriverId the id of the WebDriver to use
     * @param browserURL the starting URL including just a domain name
     * 
     * @return Instance of a Selenium implementation class WebDriver
     * 
     * @throws Exception 
     */
    public WebDriver getSelenium(String webDriverId) throws Exception {
        
        
        // now set the selenium class per webDriverId
    	WebDriver driver = null; 
        
        if(webDriverId.equals(FIREFOXWEBDRIVER)) driver = new FirefoxDriver();
        
        else if(webDriverId.equals(IEWEBDRIVER)) driver = new InternetExplorerDriver();
        
        else if(webDriverId.equals(CHROMEWEBDRIVER)) driver = new ChromeDriver();
        
        else if(webDriverId.equals(OPERAWEBDRIVER)) driver = new OperaDriver();
        
        else if(webDriverId.equals(HTMLUNITDRIVER)) driver = new HtmlUnitDriver(true);
        
        // if the driver is still null then we got a non-matching or supported webDriverId
        if(driver == null) throw new Exception("Error: could not find a Selenium implementation for the webDriverId: " + webDriverId);
        
        // if we get here, things are good so navigate to the browserURL specified
        //webDriverBackedSelenium.get(browserURL);
        
        return driver;
        
    }
       
    /**
     * Check for null inputs.
     * 
     * @param serverHost the host name on which the Selenium Server resides
     * @param browserStartCommand the port on which the Selenium Server is listening
     * @param browserURL the starting URL including just a domain name
     * 
     * @throws Exception 
     */
    private void checkForNullInput(String serverHost, String browserStartCommand, String browserURL) throws Exception {
        
        if(serverHost == null) throw new Exception("serverHost cannot be null."); 
        
        if(browserStartCommand == null) throw new Exception("browserStartCommand cannot be null.");
        
        if(browserURL == null) throw new Exception("browserURL cannot be null.");
        
    }
    
}