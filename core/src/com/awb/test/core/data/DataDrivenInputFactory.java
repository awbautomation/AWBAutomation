package com.awb.test.core.data;

import com.awb.test.core.data.DataDrivenExcel;
import com.awb.test.core.data.DataDrivenInput;

/**
 * This class is a lightweight factory that returns an obsfuscated instance of 
 * a <code>DataDrivenInput</code> implementation.
 * 
 * @author sshyamala
 */
public class DataDrivenInputFactory {
   
    /**
     * Excel spreadsheet.
     */
    public static final int EXCEL = 0;
    
    /**
     * Comma separated values.
     */
    public static final int CSV = 1;
    
    /**
     * Pipe-delimited file.
     */
    public static final int PIPEDELIMITED = 2;
    
    /**
     * Default Constructor.
     */
    public DataDrivenInputFactory() { }

    /**
     * Get an implementation <code>DataDrivenInput</code>.
     * 
     * @param filename The file of input parameter values
     * @param id The id of the implementation to use
     * 
     * @return A DataDrivenInput instance
     * 
     * @throws Exception 
     */
    public DataDrivenInput getDataDrivenInput(String filename, int id) throws Exception {
        
        try {
        
            switch (id) {
           
                case EXCEL:
                
                    return new DataDrivenExcel(filename);
            
                default:
                        
                    return new DataDrivenExcel(filename);
        
            }
            
        }
        catch(Exception e) { throw e; }
    
    }    

}