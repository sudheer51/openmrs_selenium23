package org.iitwforce.healthcare.selenium_23;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindowsFacebook {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.linkText("Learn more")).click();
		
		WebElement ele =   driver.findElement(By.linkText("Terms"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
		 
	 
		//1&2&3. Access the parent window and store in a string 
		String parentWName= driver.getWindowHandle();
		
		//4.fetch all windows [parent, child]
		Set<String> wSet = driver.getWindowHandles();
		System.out.println("Number of Windows Opened:" + wSet.size());
		for(String wName : wSet) //for Each loop
		{
			 System.out.println("in Set wName::" + wName);
			 driver.switchTo().window(wName);
			 System.out.println("Title::" + driver.getTitle());
			 if(driver.getCurrentUrl().contains("Terms"))
			 {
				 String termsServiceHeaderValue = driver.findElement(By.tagName("h2")).getText();
				 System.out.println("terms Header::" + termsServiceHeaderValue);
			 }
			 else
			 {
				 System.out.println("Not the child window which i wanted to switch");
			 } 
		}
		driver.switchTo().window(parentWName);
		
	}
}
