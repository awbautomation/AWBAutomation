package com.awb.test.core.util;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 
 * Interface for validations result printing.
 * 
 */
public interface IValidationResultPrinter {

    public abstract void printValidationResult(ValidationResult result,
	    Method method);

    public abstract void printValidationResult(
	    List<ValidationResult> resultsList, Method method);

    public abstract void printValidationResult(
	    List<ValidationResult> resultsList, Method method,
	    String setupLogger);

}