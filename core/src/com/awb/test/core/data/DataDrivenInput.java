package com.awb.test.core.data;
import java.util.Map;

/**
 * Data driven input interface. All data driven input implementation classes 
 * need to implement this interface.
 * 
 * @author sshyamala
 */
public interface DataDrivenInput {
    
    /**
     * Return a set of input data for a given <code>dataId</code> integer.
     * 
     * @param dataId The data Id of type <code>integer</code>
     * 
     * @return The data set for the given <code>dataId</code>
     * 
     * @throws Exception 
     */
    public Map returnInputDataForDataId(int dataId) throws Exception;
    
    /**
     * Return a set of input data for a given <code>dataId</code>.
     * 
     * @param dataId The data Id of type <code>String</code>
     * 
     * @return The data set for the given <code>dataId</code>
     * 
     * @throws Exception 
     */
    public Map returnInputDataForDataId(String dataId) throws Exception;
    
    /**
     * Convenience method for obtaining a single reference to data.
     * 
     * @param dataId
     * @param columnNumber
     * 
     * @return The reference to data (not a set of data)
     * 
     * @throws Exception 
     */
    public String returnInputDataForDataIdAndColumnNumber(int dataId, int columnNumber) throws Exception; 
    
    /**
     * Convenience method for obtaining a single reference to data.
     * 
     * @param dataId
     * @param columnNumber
     * 
     * @return The reference to data (not a set of data)
     * 
     * @throws Exception 
     */
    public String returnInputDataForDataIdAndColumnNumber(String dataId, int columnNumber) throws Exception; 
    
    /**
     * Return true if the dataId exist, otherwise false
     * @param dataId
     * @return
     */
    public boolean hasDataId(int dataId);
    
    /**
     * Return true if the dataId exist, otherwise false
     * @param dataId
     * @return
     */
    public boolean hasDataId(String dataId);
    /**
     * Print out all input
     * 
     * @throws Exception 
     */
    public void printAllInput() throws Exception; 
    
}

