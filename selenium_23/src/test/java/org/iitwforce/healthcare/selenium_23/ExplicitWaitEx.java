package org.iitwforce.healthcare.selenium_23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitEx {

	public static void main(String[] args) {
		
		 
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.openmrs.org/openmrs/login.htm");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30) );
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("Admin123");
			driver.findElement(By.id("Inpatient Ward")).click();
			driver.findElement(By.id("loginButton")).click();

           //Logged in as Super User (admin) at Inpatient Ward.
			WebElement textWebElement = driver.findElement(By.tagName("h4"));
			String successfulMsg ="Logged in as Super User (admin) at Inpatient Ward.";
            
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            Boolean result = wait.until(ExpectedConditions.textToBePresentInElement(textWebElement,successfulMsg));
            System.out.println("Result is "+ result);
            
            
            WebElement registerButton =  driver.findElement(By.xpath("//a[normalize-space()='Register a patient']"));
            wait.until(ExpectedConditions.elementToBeClickable(registerButton));
            registerButton.click();
            
            
            
		}
		
	 
}

//1. Register the patient
//2. LAnds on the page ->Firstname and surname
//
//validate the Firstname provided during registration should be displayed after registration 
//navigate to HomePage
//wait until the REgister Patient is displayed 
//	>> ExplicitWait
//FindA Patient Record 
