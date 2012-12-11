package com.awb.test.core.util;

/**
 * 
 * This class facilitate access to ValidationResultHolder throughout the current
 * thread. Useful for results printing.
 * 
 * @author sshyamala
 */
public class ThreadLocalValidationResultsHolder {

    private static ThreadLocal<ValidationResultsHolder> instance = new ThreadLocal<ValidationResultsHolder>() {
	protected synchronized ValidationResultsHolder initialValue() {
	    return new ValidationResultsHolder();
	}
    };

    public static ValidationResultsHolder getValidationResultHolder() {
	return instance.get();
    }

}