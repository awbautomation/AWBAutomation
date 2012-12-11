package com.awb.test.core.data;
import java.util.List;
import java.util.LinkedList;

        
/**
 * Data archive base class. All data archive classes should extend this class.
 * 
 * @author sshyamala
 */
public class DataArchiveBase {
    
    /**
     * Queue object for collecting commands
     */
    protected List<String[]> list = new LinkedList<String[]>();
    
       /**
     * Add data to be archived.
     * 
     * @param data
     * 
     * @throws Exception 
     */
    public void addData(String[] data) throws Exception { list.add(data); }
    
    /**
     * Clear/remove all data collected.
     * 
     * @throws Exception 
     */
    public void clearData() throws Exception { list.clear(); }

    
}

