package org.iitwforce.healthcare.selenium_23;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PromptExample {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
		driver.manage().window().maximize();
		WebElement ele =   driver.findElement(By.linkText("See a sample prompt"));
		
		//clicking on the link using javascript
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);

		Alert alert =  driver.switchTo().alert();
		
		alert.sendKeys("Linux");
		
		//1000 milliseconds = 1 seconds
		//5000 milliseconds = 5 seconds
		
		Thread.sleep(5000);
		
		
		//Store the alert text in a variable
		String text = alert.getText();
		System.out.println("Prompt Text::: "+ text);

		//Press the cancel button
		alert.dismiss();
	}
}
