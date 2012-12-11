package com.awb.test.core.util;

public enum AuthorName {

    SUMAN("Suman Reddy Shyamala"), UNSPECIFIED(
	    "Unspecified"), TEAM("Team");

    private String authorName;

    AuthorName(String authorName) {
	this.authorName = authorName;
    }

    public String toString() {
	return this.authorName;
    }
}
