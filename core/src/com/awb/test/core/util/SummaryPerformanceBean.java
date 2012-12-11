package com.awb.test.core.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.awb.test.core.data.DataArchive;
import com.awb.test.core.data.XLSXDataArchive;


/**
 * This class keeps track of page summary (total page load time, max page load time, average page load time, page hits) for a page.
 * It contains a class variable (pageLoadTime) which is a capture of each individual page load for the page.
 * This class then does the calculation for the total, average, max time
 * 
 * @author sshyamala
 */
public class SummaryPerformanceBean  {

    /**
     * Page load time (total)
     */
    private long totalPageLoadTime = 0;
    
    /**
     * Page load time (average)
     */
    private long averagePageLoadTime = 0;    
    
    /**
     * Page load time (max)
     */
    private long maxPageLoadTime = 0;
    
    /**
     * Page Hit
     */
    private long pageHit = 0;
        
    
    /**
     * The name of the page that was loaded
     */
    private String pageName = null;
    
    /**
     * a list of all the page load time for this page
     */
    private ArrayList<PerformanceCaptureBean> pageLoadTime = new ArrayList<PerformanceCaptureBean>();
    
    /**
     * flag to tell if total, average, page hits have been calculated or not
     */
    private boolean calculated = false;
    
    
    protected static Logger log = Logger.getLogger(SummaryPerformanceBean.class);
    
    /**
     * Default Constructor
     */
    public SummaryPerformanceBean(String pageName) { this.pageName = pageName; }
        
        
    /**
     * Add the Page level performance capture info to this summary
     * @param pagePerformance
     */
    public void add(PerformanceCaptureBean pagePerformance) {
    	    	
    	// just making sure we are adding page performance data to the right summary
    	if (getPageName().equals(pagePerformance.getPageName())) {
    		
    		pageLoadTime.add(pagePerformance);
    		
    		calculated = false;
    	}
    }
    
    /**
     * Get the page name (or message).
     * 
     * @return 
     */
    public String getPageName() { return pageName; }
    
        
    private void calculatePerformance() {
    	
    	totalPageLoadTime = 0;               
        averagePageLoadTime = 0;
        maxPageLoadTime = 0;
        pageHit = 0;
        
    	for (PerformanceCaptureBean pageTime : pageLoadTime) {
    		if (pageTime.getTime() > maxPageLoadTime)
    			maxPageLoadTime = pageTime.getTime();
    		
    		totalPageLoadTime += pageTime.getTime();
    		pageHit++;    		
    	}
    	
    	averagePageLoadTime = totalPageLoadTime / pageHit;
    	
    	calculated = true;
    }
    
    
    /**    
     * @return Total Page Load Time for this page
     */
    public long getTotalPageLoadTime() {
    	
    	if (!calculated)
    		calculatePerformance();
    	
    	return totalPageLoadTime; 
   	}
    
    /**    
     * @return Average Page Load Time for this page
     */    
    public long getAveragePageLoadTime() {
    	
    	if (!calculated)
    		calculatePerformance();
    	
    	return averagePageLoadTime; 
    }
    
    public long getMaxPageLoadTime() {
    	
    	if (!calculated)
    		calculatePerformance();
    	
    	return maxPageLoadTime; 
    }
    /**    
     * @return Total Page Hits for this page
     */
    public long getPageHit() {
    	
    	if (!calculated)
    		calculatePerformance();
    	
    	return pageHit; 
   	}
    
    /**
     * return true if average page load time is greater than specified threshold
     * @param ms	- threshold in milli-second
     * @return
     */
    public boolean isAverageTimeOverThreshold(long ms) {
    	
    	return (getAveragePageLoadTime() > ms);
    }
    
    /**
     * return true if max page load time is greater than specified threshold
     * @param ms	- threshold in milli-second
     * @return
     */
    public boolean isMaxTimeOverThreshold(long ms) {
    	
    	return (getMaxPageLoadTime() > ms);
    }
    
    /**
     * This method generate the page performance info for this particular page
     * (eg. Page Loaded From, Page Loaded, Load Time, Notes on hard-coded delays)
     * @param path: directory path to save file
     * @return file path of created file
     */
    public String generatePagePerformanceFile(String path) {

    	String savefile = null;
    	
    	try {
    		DataArchive dataArchive = new XLSXDataArchive();    	
	    	dataArchive.addData(new String[]{"Page Loaded From", "Page", "Load Time (milli sec)", "Note"});
	    	
	    	for (PerformanceCaptureBean pageTime : pageLoadTime) {
	    		String[] data = { pageTime.getFromPageName(), 
	    						  pageTime.getPageName(), 
	    						  String.valueOf(pageTime.getTime()),
	    						  pageTime.getSleepTimeString() };
	    		
	    		
					dataArchive.addData(data);
				
	    	}
    	    
	    	savefile = path + "PagePerformance_" + getPageName()+ ".xlsx";
			dataArchive.saveData(savefile);
						
    	} 
    	catch (Exception e) { log.error(e); }
    	
    	return savefile;
    }
}