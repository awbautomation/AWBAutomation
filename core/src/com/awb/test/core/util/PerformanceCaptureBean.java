package com.awb.test.core.util;
import java.util.Date;

/**
 * This class 
 * 
 * @author sshyamala
 */
public class PerformanceCaptureBean  {

    /**
     * Page load start time
     */
    private long startTime = 0;
    
    /**
     * Page load end time
     */
    private long endTime = 0;
    
    /**
     * Amount of time (milli-sec) hard-coded delay
     */
    private long sleepTime = 0;
    
    /**
     * The name of the page that was loaded
     */
    private String pageName = null;
    
    /**
     * The name of the page that was loaded from
     */
    private String fromPageName = null;
    
    /**
     * Default Constructor
     */
    public PerformanceCaptureBean() { }
    
    /**
     * Mark the start time.
     * 
     * @param fromPageName The name of the page that was loaded from
     */
    public void markStartTime(String fromPageName) { 
    	
    	this.startTime = getCurrentTime();
    	this.fromPageName = fromPageName;
    }
    
    /**
     * Mark the end time.
     * 
     * @param pageName The name of the page that has completed loading.
     */
    public void markEndTime(String pageName) { 
        
        this.endTime = getCurrentTime(); 
        this.pageName = pageName;
    
    }
    
    /**
     * Get the current time in <code>long</code> format.
     * 
     * @return the current time 
     */
    private long getCurrentTime() { return (new Date()).getTime(); }
    
    /**
     * Get the total time for page load.
     * 
     * @return 
     */
    public long getTime() { return endTime - startTime; }
    
    /**
     * Get the page name (or message).
     * 
     * @return 
     */
    public String getPageName() { return this.pageName; }
    
    /**     
     * @return The name of the page that was loaded from
     */
    public String getFromPageName() { return this.fromPageName; }
    
    /**
     * 
     * @param millis (in milli-sec) that page was put to sleep
     */
    public void addSleepTime(long millis) {
    	this.sleepTime += millis;    	
    }
    
    public long getSleepTime() { return this.sleepTime; }
    
    public String getSleepTimeString() {
    	    	
    	String s = "";
    	if (getSleepTime() > 0)
    		s = "* hard-coded delay for " + getSleepTime();
    	
    	return s;
    }
    
}
