package com.awb.test.core.data;


/**
 * Data archive interface for archiving data in CSV (comma separated value) 
 * output. 
 * 
 * This class always creates a new file, overwriting any pre-existing file.
 * 
 * @author sshyamala
 */
public class CSVDataArchive extends DelimitedDataArchiveBase implements DataArchive {
    
    /**
     * The comma is used as the delimiter for csv files
     */
    protected final String DELIMITER = ","; 
    
   
    /**
     * Default constructor.
     */
    public CSVDataArchive() { }
    

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

