package org.iitwforce.healthcare.selenium_23;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowExample {
	static WebDriver   driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		driver.findElement(By.name("alert")).click();
		Alert alrt = driver.switchTo().alert();
		System.out.println(alrt.getText());
		alrt.accept();
		
		driver.findElement(By.name("confirmation")).click();
		alrt = driver.switchTo().alert();
		System.out.println(alrt.getText());
		alrt.accept();
		
		
		driver.findElement(By.name("prompt")).click();
		alrt = driver.switchTo().alert();
		alrt.sendKeys("Hello World");
		System.out.println(alrt.getText());
		alrt.accept();
		
		
		
		


	}


}
