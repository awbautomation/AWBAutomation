package com.awb.test.pages.base;
import com.awb.test.core.pages.BasePage;

/**
 * This page is the login page of the cmc application.
 * The url of the login can be configured in the properties file (baseURL)
 * 
 * @author mchow
 */
public class LoginPage extends BasePage  {
	
	
    /**
     * Default Constructor
     */
    public LoginPage() throws Exception {
        
        try { 
            
            super.init();            
            
        }
        catch(Exception e) { throw e; }
	
    }
    
    /**
     * Use this constructor from logout
     * @param basePage
     */
    public LoginPage(BasePage basePage) {
		
		inheritSession(basePage);		
	}
}
   


