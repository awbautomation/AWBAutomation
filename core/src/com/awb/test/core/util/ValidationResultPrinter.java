package com.awb.test.core.util;

import java.lang.reflect.Method;
import java.util.List;

/**
 * This class follows the chain of responsibility pattern and handles printing
 * of the Validation Result
 * 
 * @author sshyamala
 * 
 */
public abstract class ValidationResultPrinter implements
	IValidationResultPrinter {

    private IValidationResultPrinter nextPrinter;
   
    public void printValidationResult(ValidationResult result, Method method) {
	handleValidationResultPrinting(result, method);
	if (this.getNextPrinter() != null) {
	    this.getNextPrinter().printValidationResult(result, method);
	}
    }
  
    public void printValidationResult(List<ValidationResult> resultsList,
	    Method method) {
	for (ValidationResult vres : resultsList) {
	    if (vres != null)
		handleValidationResultPrinting(vres, method);
	}
	if (this.getNextPrinter() != null) {
	    this.getNextPrinter().printValidationResult(resultsList, method);
	}
    }

   
    public void printValidationResult(List<ValidationResult> resultsList,
	    Method method, String setupLogger) {
	for (ValidationResult vres : resultsList) {
	    if (vres != null)
		handleValidationResultPrinting(vres, method);
	}
	if (this.getNextPrinter() != null) {
	    this.getNextPrinter().printValidationResult(resultsList, method,
		    setupLogger);
	}
    }

    /**
     * @param nextPrinter
     *            the nextPrinter to set
     */
    public void setNextPrinter(IValidationResultPrinter nextPrinter) {
	this.nextPrinter = nextPrinter;
    }

    /**
     * @return the nextPrinter
     */
    public IValidationResultPrinter getNextPrinter() {
	return nextPrinter;
    }

    protected void handleValidationResultPrinting(ValidationResult result,
	    Method method) {
	// Do nothing. Implemented in actual validation result printers.
    }

}
