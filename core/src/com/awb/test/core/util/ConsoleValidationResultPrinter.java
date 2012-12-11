package com.awb.test.core.util;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
/**
 * 
 * Class  to print the consolidate validation results .
 *
 */
public class ConsoleValidationResultPrinter extends ValidationResultPrinter {

    private static Logger logger = Logger
	    .getLogger(ConsoleValidationResultPrinter.class);

    @Override
    protected void handleValidationResultPrinting(ValidationResult result,
	    Method method) {
	ValidationResultsHolder resObj = ThreadLocalValidationResultsHolder
		.getValidationResultHolder();
	logger
		.info("From ThreadLocal................. "
			+ resObj.getTestName());
	logger.info("Current Test Method is ...." + method.getName());
	logger.info("TestMethod is " + method.toString());
	logger.info("TestMethod Generic String is " + method.toGenericString());
	logger.info("Current Class is ...."
		+ method.getDeclaringClass().getName());
	logger.info(":Validation Results for locator with ID:"
		+ result.getElementId());
	logger.info(":Validation Message:"
			+ result.getMessages());
	if (result.isValid()) {
	    logger.info(result.toString());
	} else {
	    logger.error(result.toString());
	}
    }
}

