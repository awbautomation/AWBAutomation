package com.awb.test.core.util;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * Root class to hold the vlidations results.
 * 
 */
public class ValidationResultsHolder {

    private String testName;
    private AuthorName author;

    private List<ValidationResultImageMapping> lvrim;

    public ValidationResultsHolder() {
	lvrim = new ArrayList<ValidationResultImageMapping>();
    }

    public String getTestName() {
	return testName;
    }

    public void setTestName(String testName) {
	this.testName = testName;
    }

    public List<ValidationResultImageMapping> getListOfVrim() {
	return lvrim;
    }

    public void addValidationResultImageMapping(ValidationResult vr,
	    File imageFile) {
	ValidationResultImageMapping vrim = new ValidationResultImageMapping(
		vr, imageFile.getAbsolutePath());
	lvrim.add(vrim);
    }

    public void clearAll() {
	this.setTestName("");
	this.lvrim.clear();
    }

    public void setAuthor(AuthorName author) {
	this.author = author;
    }

    public AuthorName getAuthor() {
	return author;
    }

    public class ValidationResultImageMapping {

	private ValidationResult validationResult;
	String imageFilePath;

	public ValidationResultImageMapping(ValidationResult vr, String image) {
	    this.validationResult = vr;
	    this.imageFilePath = image;
	}

	public ValidationResult getValidationResult() {
	    return validationResult;
	}

	public String getImageFilePath() {
	    return imageFilePath;
	}

	public String toXML() {
	    StringWriter sw = new StringWriter(1000);
	    PrintWriter out = new PrintWriter(sw);
	    out.println("<validationresultimagemapping>");
	    out.println("<imagepath>" + getImageFilePath() + "</imagepath>");
	    ValidationResult vr = getValidationResult();
	    out.println(vr.toXML());
	    out.println("</validationresultimagemapping>");
	    return sw.toString();
	}
    }

}
