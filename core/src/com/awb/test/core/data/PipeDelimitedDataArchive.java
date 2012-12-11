package com.awb.test.core.data;


import com.awb.test.core.data.DataArchive;
import com.awb.test.core.data.DelimitedDataArchiveBase;
import com.awb.test.core.data.PipeDelimitedDataArchive;

/**
 * Data archive interface for archiving data in pipe-delimited "|"
 * output. 
 * 
 * This class always creates a new file, overwriting any pre-existing file.
 * 
 * @author sshyamala
 */
public class PipeDelimitedDataArchive extends DelimitedDataArchiveBase implements DataArchive {
    
    /**
     * The comma is used as the delimiter for csv files
     */
    protected final String DELIMITER = "|"; 
    
    
    /**
     * Default constructor.
     */
    public PipeDelimitedDataArchive() { }
    

    /**
     * Save the data to a file. Creates a new file, overwriting any 
     * pre-existing file
     * 
     * @param filename
     * 
     * @throws Exception 
     */
    public void saveData(String filename) throws Exception {
        
        try { saveDataCreateNewFile(filename, DELIMITER); }
        catch(Exception e) { throw e; }
        
    }
    
}

