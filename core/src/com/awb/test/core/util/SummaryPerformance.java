package com.awb.test.core.util;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class is a holder for all the Page Summary info.
 * It has a class variable (pagePerformanceSummaries) which contains page summary for each individual page
 * 
 * @author sshyamala
 */
public class SummaryPerformance {
       
	private Hashtable<String, SummaryPerformanceBean> pagePerformanceSummaries = new Hashtable<String, SummaryPerformanceBean>();
	
    
    /**
     * PerformanceCapture instance
     */
    private static SummaryPerformance instance = new SummaryPerformance();
    
    /**
     * Default Constructor
     */
    private SummaryPerformance() { }
    
    /**
     * Return the instance of this object.
     * 
     * @return The instance of this object 
     */
    public static SummaryPerformance getInstance() { return instance; }
    
    
    public void add(PerformanceCaptureBean pagePerformance) {
    	    
    	SummaryPerformanceBean pageSummary = pagePerformanceSummaries.get(pagePerformance.getPageName());
    	if (pageSummary == null) {
    		pageSummary = new SummaryPerformanceBean(pagePerformance.getPageName());    	
    		pagePerformanceSummaries.put(pageSummary.getPageName(), pageSummary);
    	}
    		    	
    	pageSummary.add(pagePerformance);
    }
    
    public ArrayList<SummaryPerformanceBean> getPageSummaries()
    {
    	return new ArrayList<SummaryPerformanceBean>(pagePerformanceSummaries.values());
    }
            
}