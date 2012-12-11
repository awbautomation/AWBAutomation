package com.awb.test.core.util;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 
 * Root class to generate the validation results.
 * 
 */
public class ValidationResult {

   private final String elementId;

    private String elementName;
    private String message;

    private boolean valid;

    /**
     * Total validations performed across all validators
     */
    private int totalValidations;

    /**
     * Total number of failed validation in this ValidationResult across all
     * validators
     */
    private int failedValidations;

  
    public ValidationResult(String elementId) {
	this.elementId = elementId;
	this.valid = true;
	this.message = "";	
    }

    public ValidationResult(String elementId, String elementName) {
	this(elementId);
	this.elementName = elementName;
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
	return valid;
    }

    /**
     * @return the messages
     */
    public String getMessages() {
	return message;
    }

        /**
     * @return the elementId
     */
    public String getElementId() {
	return elementId;
    }

    /**
     * Returns the validation messages as String
     * 
     * @return The messages as a String. null if no messages exist.
     */
    public String toString() {
	StringWriter sw = new StringWriter(1000);
	PrintWriter pw = new PrintWriter(sw);	
	pw.print("VALIDATION -");
	pw.println(isValid() ? "PASSED" : "FAILED");
	pw.println(message);
	return sw.toString();
    }

    /**
     * Returns the Failed validation messages as String
     * 
     * @return The Failed messages as a String. null if no messages exist.
     */
    public String failedValidationsToString() {
	StringWriter sw = new StringWriter(1000);
	PrintWriter pw = new PrintWriter(sw);
	pw.println(message);
	return sw.toString();
    }

      public void addValidation(boolean condition, 
	    String message) {
	this.totalValidations++;
	if (!condition)
	    failedValidations++;
	this.valid &= condition;
	this.message=message;
	  }    
  
   
    
    public String toXML() {
    	StringWriter sw = new StringWriter(1000);
    	PrintWriter pw = new PrintWriter(sw);    	
    	pw.println(String
    		.format("<validationresult pass=\"%b\" totalvalidations=\"%d\" failedvalidations=\"%d\" >",
    			this.isValid(), this.totalValidations,
    			this.failedValidations));     	
    	return sw.toString();
        }

    /**
     * @return Total validations across validators.
     */
    public int getTotalValidations() {
	return totalValidations;
    }

    /**
     * Failed validations across validators
     * 
     * @return Returns count of failed validations across validators
     */
    public int getFailedValidations() {
	return failedValidations;
    }

    /**
     * @return The name of the element.
     */
    public String getElementName() {
	return elementName;
    }

}
