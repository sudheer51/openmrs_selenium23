package org.iitwforce.healthcare.selenium_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		
	    driver.switchTo().frame("moneyiframe");
		
		driver.findElement(By.id("query")).sendKeys("TCS");//NoSuchElementException
		
		driver.switchTo().defaultContent();
		
	 
		
	}

}
