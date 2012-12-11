package com.awb.test.core.data;
import com.awb.test.core.data.CSVAppendDataArchive;
import com.awb.test.core.data.CSVDataArchive;

/**
 * Data archive interface for archiving data in CSV (comma separated value) 
 * output. 
 * 
 * This class always writes to a pre-existing file.
 * 
 * @author mburnside
 */
public class CSVAppendDataArchive extends CSVDataArchive {
    
   
    /**
     * Default constructor.
     */
    public CSVAppendDataArchive() { }
    

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

