package org.iitwforce.healthcare.selenium_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethod {
	
	static WebDriver   driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);
		
		WebElement fullName = driver.findElement(By.name("name"));
		
		//navigation methods
		//driver.navigate().to("https://www.selenium.dev/");
		
		//driver.navigate().back();//openmrs
		
		//driver.navigate().forward();//selenium.dev
		
		driver.navigate().refresh();
		fullName = driver.findElement(By.name("name"));
		fullName.sendKeys("FirstName");
		
	}

}
