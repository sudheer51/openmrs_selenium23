package org.h2k.openmrs.tests;

import org.h2k.openmrs.BaseClass;
import org.h2k.openmrs.HelperClass;
import org.h2k.openmrs.pageobjects.FindAPatientRecordPage;
import org.h2k.openmrs.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FindAPatientRecordTests extends BaseClass {
	@Parameters({"patientName","username","password"})
	@Test
	public void validateFindAPatientRecord(String patientName,String username,String password)
	{
		HelperClass helperObj = new HelperClass(driver);
		helperObj.launchBrowser(pro.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username,password);
		FindAPatientRecordPage findAPatientObj = new FindAPatientRecordPage(driver);
		boolean result = findAPatientObj.findAPatientRecord(patientName);
		Assert.assertTrue(result);
	}

	@Test
	@Parameters({"invalidpatientName","username","password"})
	public void validateFindAPatientRecordwithInvalidData(String invalidpatientName,String username,String password)
	{
		HelperClass helperObj = new HelperClass(driver);
		helperObj.launchBrowser(pro.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username,password);
		FindAPatientRecordPage findAPatientObj = new FindAPatientRecordPage(driver);
		boolean result = findAPatientObj.findAPatientRecordInvalidData(invalidpatientName);
		Assert.assertTrue(result);
	}

}
