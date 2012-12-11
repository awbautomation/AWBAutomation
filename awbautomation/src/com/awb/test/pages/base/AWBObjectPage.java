package com.awb.test.pages.base;

import com.awb.test.core.pages.BasePage;

/**
 * This is the super class of all page classes other than HomePage and ListPage.
 * This class provides common functionalities such as clicking on a button, expanding lists, adding a comment..
 *   
 * @author sshyamala 
 */
public class AWBObjectPage extends AWBBasePage {
	
	public AWBObjectPage() { }

	public AWBObjectPage(BasePage basePage) {
		
		inheritSession(basePage);
		waitForPageToLoad(getTimeout());
						
		validate();
	}
	
	/**
	 * Validate that we are on the Home page
	 */
	public void validate() {

		super.validate();
						
	}


}
