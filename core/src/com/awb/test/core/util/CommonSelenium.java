package com.awb.test.core.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CommonSelenium {

    /**
     * WebDriver object
     */
    private WebDriver driver = null;
    
    /**
     *  logging object
     */
    protected static Logger log = Logger.getLogger(CommonSelenium.class);
    
    /**
     * Reference to this object
     */
    private static CommonSelenium instance = new CommonSelenium();
    
    /**
     * Default Constructor
     */
    protected CommonSelenium() {}
    
    /**
     * Return the instance of this object.
     * 
     * @return The instance of this object 
     */
    public static CommonSelenium getInstance() { return instance; }
    
    /**
     * Set the selenium object to be shared
     * 
     * @param selenium 
     */
    public void setSelenium(WebDriver driver) { this.driver = driver; }
    
    /**
     * Get the selenium object being used in this session
     * 
     * @return 
     */
    public WebDriver getSelenium() { return this.driver; }
    
}