package com.awb.test.core.testng.listener;

import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.awb.test.core.data.DataArchive;
import com.awb.test.core.data.PipeDelimitedAppendDataArchive;
import com.awb.test.core.data.XLSXDataArchive;
import com.awb.test.core.util.CommandList;
import com.awb.test.core.util.CommonProperties;
import com.awb.test.core.util.PerformanceCapture;
import com.awb.test.core.util.PerformanceCaptureBean;
import com.awb.test.core.util.ScreenshotCapture;
import com.awb.test.core.util.SummaryPerformance;
import com.awb.test.core.util.SummaryPerformanceBean;
import com.awb.test.core.util.Utils;

/**
 * This class is a utility class that can be used by TestNG listeners to 
 * help do stuff.
 * 
 * @author sshyamala
 */
public class TestNGUtils {
    
    /**
     *  logging object, logging conf is defined in conf/log4j.properties
     */
    protected static Logger log = Logger.getLogger(TestNGUtils.class);
    
    /**
     * Utils class instance
     */
    private Utils utils = new Utils();
    
    /**
     * Properties that can be used for any class extending this class
     */
    protected CommonProperties properties = CommonProperties.getInstance();
    
    /**
     * command log div prefix.
     */
    private final String COMMANDLOGDIV = "commandlogdiv";
    
    /**
     * [performance log div prefix.
     */
    private final String PERFORMANCELOGDIV = "performancelogdiv";
    
    /**
     * Data archive to use.
     */
    private final DataArchive dataArchive = new XLSXDataArchive();
    
    private final DataArchive csvDataArchive = new PipeDelimitedAppendDataArchive();
    
    /**
     * Default Constructor
     */
    public TestNGUtils() { }
    
    /**
     * This method adds screenshot and other information to the test report.
     * 
     * @param result The TestNG test result object
     * @param screenshotFile 
     */
    protected void appendToReport(ITestResult result, String screenshotFile, int divId) {
        
        Reporter.setCurrentTestResult(result);
         
        Object[] parameters = result.getParameters();
        
        createSeleniumCommandLog(divId);
        
        int index = screenshotFile.lastIndexOf(".");
        String performanceFile = screenshotFile.substring(0, index) + "_perf." + ScreenshotCapture.PNG;
        printPerformanceNumbers(performanceFile, divId, utils.getFirstToken(result.getName(), " "));
        
        Reporter.log("<p><font face=arial size=2 color=000099>");
        
        if(parameters.length > 0) Reporter.log("<p>Total number of input parameters: " + parameters.length + "<p>");         
        
        for(int i = 0; i < parameters.length; i++) Reporter.log("Parameter: " + parameters[i]);
  
        Reporter.log("<b>Screenshot</b><br>");
        
        String screenshotFileURL = null;
        
        if(useLocalFilePathForReporting()) { 
            
            screenshotFileURL = utils.LINKIMAGEFILEPREFIX + screenshotFile;
           
        }
        else {
            
            screenshotFileURL = getScreenshotsDirectory() + "/" + getFilenameWithoutPath(screenshotFile);
            
        }
        
        log.debug("useLocalFilePathForReporting: " + useLocalFilePathForReporting());
        log.debug("screenshotFileURL: " + screenshotFileURL);
            
        Reporter.log("<p><a href='" + screenshotFileURL + "'>" + "<img src='" + screenshotFileURL + "' height='100' width='100'/></a>");
                           
        Reporter.log("<p>");   
        
        Reporter.log("<font size=1><a href='" + screenshotFileURL + "'>Click on thumbnail image to view screenshot</a></font><p><br></font>");
               
        Reporter.setCurrentTestResult(null);
        
        savePerformanceToXLSXFile(screenshotFile + "_DataArchive.xlsx");
        
        savePerformanceToCSVFile(screenshotFile + "_DataArchive.txt");
        
        try { dataArchive.clearData(); }
        catch(Exception e) { log.error(e); }
        
    }
    /**
     * This method retrieves the page summary from the SummaryPerformance singleton class and
     * write the data in a Pipe Delimited format
     * @param path
     */
    protected void savePageSummaryPerformance(String performancePath) {
    	
    	if (capturePageLoadPerformance())
    	{    		
    		try { 
    			
	    		String totalTimeImageFile 	= performancePath + "totalTime.png";
	    		String averageTimeImageFile	= performancePath + "averageTime.png";
	    		String totalHitsImageFile	= performancePath + "totalHits.png";
	    		
		    	ArrayList<SummaryPerformanceBean> pageSummaries = SummaryPerformance.getInstance().getPageSummaries();
		    	ArrayList<String> individualPageLoadFile = new ArrayList<String>();
		    	
		    	DefaultPieDataset totalLoadTimeDataset = new DefaultPieDataset();
		    	DefaultPieDataset averageLoadTimeDataset = new DefaultPieDataset();
		    	DefaultPieDataset pageHitDataset = new DefaultPieDataset();
		    	
		    	DataArchive pageSummaryArchive = new XLSXDataArchive();
		    	DataArchive averageTimeOverThresholdArchive = new XLSXDataArchive();
		    	DataArchive maxTimeOverThresholdArchive = new XLSXDataArchive();
		    	
		    	// Add Header Row
		    	pageSummaryArchive.addData(new String[]{"Page", "Total Load Time (milli sec)", "Max Load Time (milli sec)", "Average Load Time (milli sec)", "Page Hit"});
		    	averageTimeOverThresholdArchive.addData(new String[]{"Page", "Average Load Time (milli sec)> " + getAveragePageLoadTimeThreshold()});
		    	maxTimeOverThresholdArchive.addData(new String[]{"Page", "Max Load Time (milli sec)> " + getMaxPageLoadTimeThreshold()});
		    	
		    	// Retrieve data for each pages
		    	int pageCount = 0;
		    	for (SummaryPerformanceBean pageSummary : pageSummaries)
		    	{
		    		String performanceFile = pageSummary.generatePagePerformanceFile(performancePath);
		    		String performanceFileURL = null;		            
		            if(useLocalFilePathForReporting())
		            	performanceFileURL = utils.LINKIMAGEFILEPREFIX + performanceFile;
		            else
		                performanceFileURL = getPerformanceDataDirectory() + "/" + getFilenameWithoutPath(performanceFile);		                
		            
		    		individualPageLoadFile.add( performanceFileURL );
		    		
		    		
		    		totalLoadTimeDataset.setValue(pageSummary.getPageName(), pageSummary.getTotalPageLoadTime());
		    		averageLoadTimeDataset.setValue(pageSummary.getPageName(), pageSummary.getAveragePageLoadTime());
		    		pageHitDataset.setValue(pageSummary.getPageName(), pageSummary.getPageHit());
		    		
		    		String[] data = { pageSummary.getPageName(), 
		    						  String.valueOf(pageSummary.getTotalPageLoadTime()), 
		    						  String.valueOf(pageSummary.getMaxPageLoadTime()),
		    						  String.valueOf(pageSummary.getAveragePageLoadTime()),
		    						  String.valueOf(pageSummary.getPageHit()) };
		    				    				    		
		    		
	    			pageSummaryArchive.addData(data);
	
	    			if (getAveragePageLoadTimeThreshold() > 0 && pageSummary.isAverageTimeOverThreshold(getAveragePageLoadTimeThreshold()))
	    			{
	    				String[] data1 = { pageSummary.getPageName(), String.valueOf(pageSummary.getAveragePageLoadTime()) };
	    				averageTimeOverThresholdArchive.addData(data1);
	    			}
	    			if (getMaxPageLoadTimeThreshold() > 0 && pageSummary.isMaxTimeOverThreshold(getMaxPageLoadTimeThreshold()))
	    			{
	    				String[] data1 = { pageSummary.getPageName(), String.valueOf(pageSummary.getMaxPageLoadTime()) };
	    				maxTimeOverThresholdArchive.addData(data1);
	    			}
	    			
	    			pageCount++;
		    	}
		    	        	    	
		    	// Generate the Pie Charts
		    	generatePieChart(totalLoadTimeDataset, pageCount, totalTimeImageFile, "Total Page Load Time (in milli sec)");
		    	generatePieChart(averageLoadTimeDataset, pageCount, averageTimeImageFile, "Average Page Load Time (in milli sec)");
		    	generatePieChart(pageHitDataset, pageCount, totalHitsImageFile, "Page Hits");
		    		    
		    	// Generate overall page summary
	    		pageSummaryArchive.saveData(performancePath + "PerformanceSummary.xlsx");
	    	
	    		// Generate page over Threshold
	    		String avgLoadThresholdFile = null;
	    		String maxLoadThresholdFile = null;
	    		if (getAveragePageLoadTimeThreshold() > 0)
	    		{
	    			avgLoadThresholdFile = performancePath + "AverageTimeOverThreshold.xlsx";
	    			averageTimeOverThresholdArchive.saveData(avgLoadThresholdFile);
	    		}
	    		if (getMaxPageLoadTimeThreshold() > 0)
	    		{
	    			maxLoadThresholdFile = performancePath + "MaxTimeOverThreshold.xlsx";
	    			maxTimeOverThresholdArchive.saveData(maxLoadThresholdFile);
	    		}
	    			
	    		
		    	// Generate HTML report
	    		Collections.sort(individualPageLoadFile);
		    	generatePageSummaryReport(performancePath+"PagePerformanceSummary.html", 
		    							  totalTimeImageFile, 
		    							  averageTimeImageFile, 
		    							  totalHitsImageFile,
		    							  avgLoadThresholdFile,
		    							  maxLoadThresholdFile,
		    							  individualPageLoadFile);
	    	}
	        catch(Exception e) { log.error(e); }
    	}
        
    }
    
    /**
     * Log the selenium command output to testNG report area
     * 
     * @param divId 
     */
    private void createSeleniumCommandLog(int divId) {
        
        log.debug("Is selenium command list empty: " + CommandList.getInstance().isEmpty());
        
        if(CommandList.getInstance().isEmpty() || !captureSeleniumCommands()) {
            
            CommandList.getInstance().clear();
            return;
        
        }
        
        String newId = COMMANDLOGDIV + divId;
       
        String[] list = CommandList.getInstance().getAllInList();
        
        log.debug("Writing the selenium command log with : " + list.length + " commands");
                
        // note: toggleElement is a javascript function provided by ReportsNG
        Reporter.log("<p><input type=\"button\" onclick=\"javascript:toggleElement('" + newId  + "', 'block');\" value=\"Show/Hide Selenium commands\" /><p><br>");
        
        Reporter.log("<div class=\"mid\" id=\"" + newId + "\" style=\"DISPLAY: none\">");
        
        Reporter.log("<p><font face=arial size=1.7 color=2e8b57>");
        
        for(int i = 0; i < list.length; i++) {
            
            Reporter.log("<p>");
            Reporter.log(list[i]);
        
        }
        
        Reporter.log("</font><p><br>");
        
        Reporter.log("</div>");
        
        CommandList.getInstance().clear();
    
    }
    
    /**
     * Log the page load performance number output to testNG report area
     * 
     * @param filename - file path to store the performance chart for this test case
     * @param divId 
     */
    private void printPerformanceNumbers(String filename, int divId, String testMethod) {
        
        if(PerformanceCapture.getInstance().isEmpty() || !capturePageLoadPerformance()) {
            
            PerformanceCapture.getInstance().clear();
            
            return;
        
        }
        
        List<PerformanceCaptureBean> list = PerformanceCapture.getInstance().getAllInList();
        
        log.debug("Writing the performance log with : " + list.size() + " entries");
        
        String newId = PERFORMANCELOGDIV + divId;
                
        // note: toggleElement is a javascript function provided by ReportsNG
        Reporter.log("<p><input type=\"button\" onclick=\"javascript:toggleElement('" + newId + "', 'block');\" value=\"Show/Hide Page Load times (ms)\" /><p><br>");
        
        Reporter.log("<div class=\"mid\" id=\"" + newId + "\" style=\"DISPLAY: none\">");
        
        Reporter.log("<p><font face=arial size=1.7 color=2e8b57>");
        
        // dataset for bar chart
        DefaultCategoryDataset barChartDataset = new DefaultCategoryDataset();
        
        int datarowcount = 0;
        for(int i = 0; i < list.size(); i++) {
            
        	datarowcount = i;
            Reporter.log("<p>");
            
            PerformanceCaptureBean bean = list.get(i);
            Reporter.log(bean.getTime() + " - " + bean.getPageName());
            
            barChartDataset.addValue(bean.getTime(), "Label", (i+1) + "."+bean.getPageName());            
            
            String[] dataToArchive = { bean.getFromPageName(), bean.getPageName(), String.valueOf(bean.getTime()) };                        
            try { 
                
                dataArchive.addData(dataToArchive); 
                csvDataArchive.addData(dataToArchive);
                SummaryPerformance.getInstance().add(bean);
            }
            catch(Exception e) { log.error(e); }
        
        }
        
        generateBarChart(barChartDataset, datarowcount, filename, testMethod);
        
        
        String performanceFileURL = null;
        if(useLocalFilePathForReporting())              
        	performanceFileURL = utils.LINKIMAGEFILEPREFIX + filename;                   
        else             
        	performanceFileURL = getScreenshotsDirectory() + "/" + getFilenameWithoutPath(filename);                    

        Reporter.log("</font>");
        Reporter.log("<p><a href='" + performanceFileURL + "'>" + "<img src='" + performanceFileURL + "' height='100' width='100'/></a><p><br>");
        Reporter.log("<font size=1>Click on thumbnail image to view page performance chart</font><p><br></font>");
        
        Reporter.log("</div>");               
        
        PerformanceCapture.getInstance().clear();
        
    }
    
    /**
     * Determine if we should print the list of selenium commands.
     * 
     * @return 
     */
    private boolean captureSeleniumCommands() {
        
        // set the captureSeleniumCommands    
        if((properties.getProperty("captureSeleniumCommands") != null) && "true".equals(properties.getProperty("captureSeleniumCommands"))) return true;
        else return false;
       
    }
    
    /**
     * Determine if we should print the list of page load numbers.
     * 
     * @return 
     */
    public boolean capturePageLoadPerformance() {
        
        // set the captureSeleniumCommands    
        if((properties.getProperty("capturePageLoadPerformance") != null) && "true".equals(properties.getProperty("capturePageLoadPerformance"))) return true;
        else return false;
       
    }
    
    /**     
     * @return average page load time threshold (in milli-second)
     */
    private long getAveragePageLoadTimeThreshold()
    {
    	long threshold = 0;
    	String thresholdStr = properties.getProperty("averagePageLoadTimeThreshold");
    	
    	if (thresholdStr != null)
    		threshold = Long.parseLong(thresholdStr);
    	
    	return threshold;
    }
    
    /**     
     * @return max page load time threshold (in milli-second)
     */
    private long getMaxPageLoadTimeThreshold()
    {
    	long threshold = 0;
    	String thresholdStr = properties.getProperty("maxPageLoadTimeThreshold");
    	
    	if (thresholdStr != null)
    		threshold = Long.parseLong(thresholdStr);
    	
    	return threshold;
    }
    
    public void savePerformanceToXLSXFile(String filename) {
        
        try { dataArchive.saveData(filename); }
        catch(Exception e) { log.error(e); }
        
    }
    
    public void savePerformanceToCSVFile(String filename) {
        
        try { csvDataArchive.saveData(filename); }
        catch(Exception e) { log.error(e); }
        
    }
    
    /**
     * This method generates a pie chart by the given dataset
     * @param dataset
     * @param datarowcount
     * @param filename
     * @param chartTitle
     */
    private void generatePieChart(DefaultPieDataset dataset, int datarowcount, String filename, String chartTitle) {
    	
    	JFreeChart chart = ChartFactory.createPieChart(chartTitle, dataset, true, true, true);
    	
    	// format the legend label to be { key = value (percentage) }
    	PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}= {1} ({2})"));
		
    	try {
    		int size = 400;
    		if (datarowcount>10)
    			size = 800;
    		ImageIO.write(chart.createBufferedImage(size,size), "png", new File(filename)); 
    	}    	
        catch(Exception e) { log.error(e); }
    }
    
    /**
     * This method generates a pie chart by the given dataset
     * @param dataset
     * @param datarowcount
     * @param filename
     * @param chartTitle
     */
    private void generateBarChart(DefaultCategoryDataset dataset, int datarowcount, String filename, String chartTitle) {
    	
    	JFreeChart chart = ChartFactory.createBarChart(chartTitle,			// chart title	 
														"Page", 						// domain axis label
														"Time (milli sec)", 		// range axis label
														dataset,                  	// data
														PlotOrientation.HORIZONTAL, 	// orientation
														false,                     	// include legend
														true,                     	// tooltips?
														false                     	// URLs?
													);
    	
    	CategoryPlot plot = chart.getCategoryPlot();

        
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setVisible(false);
       
//        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        rangeAxis.setUpperMargin(1.25);
       
        CategoryItemRenderer renderer = plot.getRenderer();
        CategoryItemLabelGenerator generator
            = new StandardCategoryItemLabelGenerator("{1}",
                    NumberFormat.getInstance());
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setBaseItemLabelFont(new Font("SansSerif", Font.BOLD, 14));
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE8, TextAnchor.BOTTOM_LEFT, TextAnchor.BOTTOM_RIGHT, 0));
    		
        BarRenderer br = (BarRenderer) plot.getRenderer();
		br.setMaximumBarWidth(.10); // set maximum width to 10% of chart
		
		
		int width = 400;
		if (datarowcount > 7)
			width += ((datarowcount - 7) * 25);
				
		
    	try {    		
    		ImageIO.write(chart.createBufferedImage(width,400), "png", new File(filename)); 
    	}    	
        catch(Exception e) { log.error(e); }
    }
    
    
    /**
     * This method generates page performance report using the conf/PagePerformanceSummary.html.vm template
     * 
     * @param filename				- name of the generated report
     * @param totalTimeImageFile	- file path of the image file for total page load time
     * @param averageTimeImageFile	- file path of the image file for average page load time
     * @param totalHitsImageFile	- file path of the image file for total page hits
     * @param avgLoadThresholdFile	- file path of average page load threshold
     * @param maxLoadThresholdFile	- file path of max page load threshold
     * @param pageLoadFiles			- list of individual page loads
     */
    private void generatePageSummaryReport(String filename, 
    									   String totalTimeImageFile,
    									   String averageTimeImageFile,
    									   String totalHitsImageFile,
    									   String avgLoadThresholdFile,
    									   String maxLoadThresholdFile,
    									   ArrayList<String> pageLoadFiles) {
	    
    	
    	String totalTimeImageURL = null;
    	String averageTimeImageURL = null;
    	String totalHitsImageURL = null;
    	String avgLoadThresholdURL = null;
    	String maxLoadThresholdURL = null;
    	String fileseparator = File.separator;
    	
        if(useLocalFilePathForReporting()) {
        	totalTimeImageURL = utils.LINKIMAGEFILEPREFIX + totalTimeImageFile;
        	averageTimeImageURL = utils.LINKIMAGEFILEPREFIX + averageTimeImageFile;
        	totalHitsImageURL = utils.LINKIMAGEFILEPREFIX + totalHitsImageFile;
        	avgLoadThresholdURL = utils.LINKIMAGEFILEPREFIX + avgLoadThresholdFile;
        	maxLoadThresholdURL = utils.LINKIMAGEFILEPREFIX + maxLoadThresholdFile;
        }
        else{        	
            totalTimeImageURL = getPerformanceDataDirectory() + "/" + getFilenameWithoutPath(totalTimeImageFile);
            averageTimeImageURL = getPerformanceDataDirectory() + "/" + getFilenameWithoutPath(averageTimeImageFile);
            totalHitsImageURL = getPerformanceDataDirectory() + "/" + getFilenameWithoutPath(totalHitsImageFile);
            avgLoadThresholdURL = getPerformanceDataDirectory() + "/" + getFilenameWithoutPath(avgLoadThresholdFile);
            maxLoadThresholdURL = getPerformanceDataDirectory() + "/" + getFilenameWithoutPath(maxLoadThresholdFile);
            fileseparator = "/";
        }
        
		VelocityContext context = new VelocityContext();
	    context.put("browser", "Firefox");		// TODO: where?
	    context.put("build", "2.1.1");			// TODO: where?
	    context.put("environment", "QA 02");	// TODO: where?
	    context.put("totalTimeImageFile", totalTimeImageURL);
	    context.put("averageTimeImageFile", averageTimeImageURL);
	    context.put("totalHitsImageFile", totalHitsImageURL);
	    context.put("avgLoadThresholdFile", avgLoadThresholdURL);
	    context.put("maxLoadThresholdFile", maxLoadThresholdURL);
	    context.put("pageLoadFiles", pageLoadFiles);
	    context.put("pathseparator", fileseparator);
	    
	    	  
	    VelocityEngine ve = new VelocityEngine();
	    ve.setProperty("file.resource.loader.class", ClasspathResourceLoader.class.getName());
	    try {
	    	ve.init();
	    		    		    
	    	Template t = ve.getTemplate("PagePerformanceSummary.html.vm");
		    StringWriter writer = new StringWriter();
		    t.merge(context, writer);
		    FileWriter fileWriter = new FileWriter(filename, false);
		    fileWriter.write(writer.toString());
		    fileWriter.flush();
		    fileWriter.close();
		    
	    } catch (Exception e) { }
	}

	
    /**
     * Determine if we should use local file path for reporting. 
     * 
     * This property is set in seleniumconfiguration.properties file.
     * 
     * @return 
     */
    public boolean useLocalFilePathForReporting() {
        
        if((properties.getProperty("useLocalFilePathForReporting") != null) && "true".equals(properties.getProperty("useLocalFilePathForReporting"))) return true;
        else return false;
       
    }
    
    /**
     * This property is set in seleniumconfiguration.properties file.
     * 
     * screenshotsDirectory
     * 
     * @return 
     */
    public String getScreenshotsDirectory() { return properties.getProperty("screenshotsDirectory"); }
    
    /**
     * This property is set in seleniumconfiguration.properties file.
     * 
     * performanceDataDirectory
     * 
     * @return 
     */
    public String getPerformanceDataDirectory() { return properties.getProperty("performanceDataDirectory"); }
    
    /**
     * Get the filename without the string.
     * 
     * @param filename
     * @return 
     */
    public String getFilenameWithoutPath(String filename) { return (new File(filename)).getName(); }
    
}



