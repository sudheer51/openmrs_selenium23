package org.iitwforce.healthcare.selenium_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenMRSExample
{
	static WebDriver   driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);
		
		//Login to open mrs
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		String actualLoginMsg = driver.findElement(By.xpath("//h4[contains(text(),'Logged in as Super User (admin) at Inpatient Ward.')]")).getText();
		String expectedLoginMsg="Logged in as Super User (admin) at Inpatient Ward.";
		if(actualLoginMsg.equals(expectedLoginMsg))
		{
			System.out.println("Login Successful");
		}
		else
		{
			System.out.println("login unsuccessful");
		}
		
		//Register a Patient
		
		
		//Find a Patient
		//driver.findElement(By.xpath("(//a[normalize-space()='Register a patient'])[1]")).click();
		driver.findElement(By.xpath("(//a[normalize-space()='Find Patient Record'])[1]")).click();
		String expectedPatientID="100PJ1";
		driver.findElement(By.id("patient-search")).sendKeys(expectedPatientID);
		String actualPatientID = driver.findElement(By.xpath(" //table[@id='patient-search-results-table']/tbody/tr[1]/td[1]")).getText();
		if(actualPatientID.contains(expectedPatientID))
		{
			System.out.println("Find a patient record is successful");
		}
		else
		{
			System.out.println("Find a patient record is unsuccessful");
		}
	}
	 
}



//login();
//registerPatient();
//findPatientRecord();
//logout();
//public static void login()
//{
//	driver.findElement(By.id("username")).sendKeys("Admin");
//	driver.findElement(By.id("password")).sendKeys("Admin123");
//	driver.findElement(By.id("Inpatient Ward")).click();
//	driver.findElement(By.id("loginButton")).click();
//	String actualLoginMsg = driver.findElement(By.xpath("//h4[contains(text(),'Logged in as Super User (admin) at Inpatient Ward.')]")).getText();
//	String expectedLoginMsg="Logged in as Super User (admin) at Inpatient Ward.";
//	if(actualLoginMsg.equals(expectedLoginMsg))
//	{
//		System.out.println("Login Successful");
//	}
//	else
//	{
//		System.out.println("login unsuccessful");
//	}
//}
//public static void registerPatient()
//{
//	
//}
//public static void findPatientRecord()
//{
//	
//}

