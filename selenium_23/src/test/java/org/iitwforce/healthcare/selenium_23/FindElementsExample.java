package org.iitwforce.healthcare.selenium_23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsExample {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		List<WebElement> inputList = driver.findElements(By.tagName("input"));
		System.out.println("Number of input elements:::" + inputList.size());
	
		for(int i=0;i<inputList.size();i++)
		{
			//inputList.get(i).sendKeys("Selenium");
			
			WebElement e = inputList.get(i);
			e.sendKeys("Selenium");
		}
	
	}

}
