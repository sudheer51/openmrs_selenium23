package org.h2k.openmrs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {
	 
	WebDriver driver;
	public HelperClass(WebDriver driver)
	{
		this.driver = driver;
		//this.i=i;
	}
	public void navigateToFindPatient()
	{
		driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
		 
	}
	public void navigateToActiveVisits()
	{
		driver.findElement(By.id("org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension")).click();
	}
	public void navigateToRegisterPatient()
	{
		driver.findElement(By.
				id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
	}
	public void launchBrowser(String url)
	{
		driver.get(url);
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);
	}
}
