package com.awb.test.core.util;
import java.util.LinkedList;
import java.util.List;


/**
 * This class keeps track of page loading performance.
 * 
 * @author sshyamala
 */
public class PerformanceCapture {
    
    private PerformanceCaptureBean bean = null;
    
    /**
     * Queue object for collecting commands
     */
    private List<PerformanceCaptureBean> list = new LinkedList<PerformanceCaptureBean>();
    
        
    /**
     * PerformanceCapture instance
     */
    private static PerformanceCapture instance = new PerformanceCapture();
    
    /**
     * Default Constructor
     */
    public PerformanceCapture() { }
    
    /**
     * Return the instance of this object.
     * 
     * @return The instance of this object 
     */
    public static PerformanceCapture getInstance() { return instance; }
    
    /**
     * Stop the timer and mark the end time of the page load.
     * 
     * @param pageName the name of the page that just loaded 
     */
    public void stop(String pageName) { 
        
        this.bean.markEndTime(pageName);
        list.add(this.bean);
        
        this.bean = null;	// use a new bean next time
    }
    
    /**
     * Mark the start of page load.
     * 
     * @param fromPageName the name of the page that was loaded from
     */
    public void start(String fromPageName) {
        
        this.bean = new PerformanceCaptureBean();
        this.bean.markStartTime(fromPageName);
        
    }
    
    public void addSleepTime(long millis) {
    	if (this.bean!=null)
    		this.bean.addSleepTime(millis); 
    } 
    
    /**
     * Removes all commands in the list.
     */
    public void clear() { list.clear(); }
    
    /**
     * Get all of the commands in the list.
     * 
     * @return 
     */
    public List<PerformanceCaptureBean> getAllInList() { return this.list; }
    
    /**
     * Get the size of the list.
     * 
     * @return 
     */
    public int getSize() { return list.size(); }
    
    /**
     * Indicates if command list contains no commands
     * 
     * @return 
     */
    public boolean isEmpty() {
        
        return (getSize() == 0);
        
    }
            
}