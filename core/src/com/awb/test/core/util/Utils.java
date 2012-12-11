package com.awb.test.core.util;

import java.io.File;
import java.util.StringTokenizer;

/**
 * This class is a utility class that can be used by other classes to do stuff.
 * 
 * @author sshyamala
 */
public class Utils {
    
    /**
     * The screenshots directory
     */
    public final String SCREENSHOTS_DIR = "screenshots";
    
    public final String PAGEPERFORMANCE_DIR	= "performance";
    
    /**
     * Linked image file prefix, we need it for proper syntax
     * when adding links to html since we are linking local files.
     */
    public final String LINKIMAGEFILEPREFIX = "file:///";
    
    
    /**
     * Default Constructor
     */
    public Utils() { }
    
    /**
     * Return the base directory of test execution
     * 
     * @return
     * 
     * @throws Exception 
     */
    public String getBaseDirectory() throws Exception {
        
        try { return (new File("")).getAbsolutePath(); }
        catch(Exception e) { throw e; }
           
    }
    
    /**
     * Return the directory where screenshot should be created.
     * 
     * This method always appends a "/" to the end to the end of the string
     * returned.
     * 
     * @return
     * 
     * @throws Exception 
     */
    public String getBaseScreenshotsDirectory() throws Exception {
        
        try { return getBaseDirectory() + File.separator + SCREENSHOTS_DIR + File.separator; }
        catch(Exception e) { throw e; }
           
    }
    
    /**
     * Return the directory where page performance files should be created.
     * 
     * This method always appends a "/" to the end to the end of the string
     * returned.
     * 
     * @return
     * 
     * @throws Exception 
     */
    public String getBasePagePerformanceDirectory() throws Exception {
        
        try { return getBaseDirectory() + File.separator + PAGEPERFORMANCE_DIR + File.separator; }
        catch(Exception e) { throw e; }
           
    }
    
    /**
     * This method returns the boolean value of the <code>doReportingOnTestSuccess</code>
     * setting in the properties file.
     * 
     * If no valid setting, this return value is <code>false</code>.
     * 
     * @return 
     */
    public boolean doReportingOnTestSuccess() { 
        
        if(CommonProperties.getInstance().get("doReportingOnTestSuccess") == null) return false;
        return (new Boolean(CommonProperties.getInstance().get("doReportingOnTestSuccess"))); 
    
    }
    
    /**
     * This method returns the boolean value of the <code>doReportingOnTestFail</code>
     * setting in the properties file.
     * 
     * If no valid setting, this return value is <code>false</code>.
     * 
     * @return 
     */
    public boolean doReportingOnTestFail() { 
        
        if(CommonProperties.getInstance().get("doReportingOnTestFail") == null) return false;
        return (new Boolean(CommonProperties.getInstance().get("doReportingOnTestFail"))); 
    
    }
    
    /**
     * Return the first token in the string separated by the given
     * <code>delimiter</code>.
     * 
     * @param s the string to tokenize
     * @param delimiter the speration character(s)
     * 
     * @return The first token 
     */
    public String getFirstToken(String s, String delimiter) {
        
        StringTokenizer st = new StringTokenizer(s, delimiter);
        return st.nextToken();
        
    }
    
}