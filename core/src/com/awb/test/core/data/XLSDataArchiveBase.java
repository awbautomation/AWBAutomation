package com.awb.test.core.data;

import java.io.FileOutputStream;

import org.apache.log4j.Logger;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;
        
/**
 * Data archive base class for archiving to XLS or XLSX (Excel) files.
 * 
 * @author sshyamala
 */
public class XLSDataArchiveBase extends DataArchiveBase {
    
    /**
     *  logging object
     */
    private static Logger log = Logger.getLogger(XLSDataArchiveBase.class);
    
    /**
     * Save the data to a file.
     * 
     * @param filename
     * 
     * @throws Exception 
     */
    public void saveData(Workbook workbook, String filename) throws Exception {
        
        try {
            
            CreationHelper createHelper = workbook.getCreationHelper();
    
            Sheet sheet = workbook.createSheet("Saved Data");
    
            for(int i = 0; i < list.size(); i++) {
                
                Row row = sheet.createRow((short)i);
                
                String[] data = list.get(i); 
    
                for (int j = 0; j < data.length; j++) {
                    
                    log.debug("For row: " + i + ", creating column: " + j + " with data: " + data[j]);
                    
                    row.createCell(j).setCellValue(createHelper.createRichTextString(data[j]));
            
                }
        
            }
            
            FileOutputStream fileOut = new FileOutputStream(filename);
            
            workbook.write(fileOut);
            
            fileOut.close();
        
        }
        catch(Exception e) { log.error(e); throw e; }
        
    }
    
}
