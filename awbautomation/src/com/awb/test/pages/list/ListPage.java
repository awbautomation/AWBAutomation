package com.awb.test.pages.list;

import com.awb.test.pages.base.AWBObjectPage;
import com.awb.test.core.pages.BasePage;


/**
 * This class model all list pages.
 * This provides list functionalities such as filtering, click New Link, check / click on Nth item in list..
 * 
 * @author sshyamala
 *
 */
public class ListPage extends AWBObjectPage{
	
		
	public ListPage(BasePage basePage) {
		
		inheritSession(basePage);
		waitForPageToLoad(getTimeout());
		
			
		
		validate();
	}

	/**
	 * Validate that we are on the List page
	 */
	public void validate() {

		super.validate();
		
		
		
	}
	

}
