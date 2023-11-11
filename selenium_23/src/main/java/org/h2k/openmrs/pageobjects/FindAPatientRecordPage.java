package org.h2k.openmrs.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindAPatientRecordPage {
	
	WebDriver driver;
	private By patientSearchID = By.id("patient-search");
	private By findAPatientID = By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension");
	private By patientSearchTableFirstRow = By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[2]");
	private By patientSearchTableInvalidRow= By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td");
	int i =10;
	
	public FindAPatientRecordPage(WebDriver driver)
	{
		this.driver=driver;	
	}
	public boolean findAPatientRecord(String patientName)
	{
		driver.findElement(findAPatientID ).click();
		driver.findElement(patientSearchID).sendKeys(patientName);
		String expected = driver.findElement(patientSearchID).getAttribute("value");
		String actual = driver.findElement(patientSearchTableFirstRow ).getText();
		return actual.equals(expected);
	}
	public boolean findAPatientRecordInvalidData(String invalidPatientName)
	{
		driver.findElement(findAPatientID).click();
		driver.findElement(patientSearchID).sendKeys(invalidPatientName);
		String expected =  "No matching records found";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBe(patientSearchTableInvalidRow , "No matching records found"));
	 	String actual= driver.findElement(patientSearchTableInvalidRow).getText(); 
		System.out.println("Actual Msg::: "+ actual);
		return actual.equals(expected);
	}

}
