package com.awb.test.core.data;


import com.awb.test.core.data.PipeDelimitedAppendDataArchive;
import com.awb.test.core.data.PipeDelimitedDataArchive;

/**
 * Data archive interface for archiving data in pipe-delimited "|"
 * output.  
 * 
 * This class always writes to a pre-existing file.
 * 
 * @author sshyamala
 */
public class PipeDelimitedAppendDataArchive extends PipeDelimitedDataArchive {
    
    
    /**
     * Default constructor.
     */
    public PipeDelimitedAppendDataArchive() { }
    

    /**
     * Save the data to a file. Append to a pre-existing file.
     * 
     * @param filename
     * 
     * @throws Exception 
     */
    @Override
    public void saveData(String filename) throws Exception {
        
        try { saveDataAppendToFile(filename, DELIMITER); }
        catch(Exception e) { throw e; }
        
    }
    
}

