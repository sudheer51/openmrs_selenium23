package org.h2k.openmrs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void login(String username,String password)
	{
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
	}

}
