package com.awb.test.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.awb.test.tests.TestBase;
import com.awb.test.core.util.AuthorName;
import com.awb.test.core.util.TestAuthor;
import com.awb.test.core.util.ValidationResult;

@TestAuthor(name = AuthorName.SUMAN)
public class HomeTests extends TestBase {

	public void setup() throws Exception {

	}

	@Test(description = "test All Page Navigations", groups = { "smoketest2" })
	public void testAllNavigations() throws Exception {
		

		try {

			if (homePage == null) {
				login();
			}
			List<ValidationResult> vrList = homePage.VerifyAllNavigations();
			printValidationResults(vrList);
			Assert.assertTrue(isValid(vrList), getFailedValidations(vrList));

		} catch (Exception e) {
			throw e;
		} finally {
		}

	}

	@Test(description = "Test WCBenefitsByState Map", groups = { "smoketest1" })
	public void testWCBenefitsByStateMap() throws Exception {
		

		try {
			if (homePage == null) {
				login();
			}
			List<ValidationResult> vrList = homePage
					.VerifyWCBenefitsByStateLink();
			printValidationResults(vrList);
			Assert.assertTrue(isValid(vrList), getFailedValidations(vrList));

		} catch (Exception e) {
			throw e;
		} finally {
		}

	}

}
