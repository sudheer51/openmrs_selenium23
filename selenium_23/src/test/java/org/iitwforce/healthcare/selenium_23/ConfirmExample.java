package org.iitwforce.healthcare.selenium_23;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfirmExample {
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");

		driver.manage().window().maximize();

		//WebElement ele =   driver.findElement(By.cssSelector("p:nth-child(11) > a"));
		WebElement ele =   driver.findElement(By.linkText("See a sample confirm"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].focus()", ele);
//
//		Alert alert =  driver.switchTo().alert();
//
//		//Store the alert text in a variable
//		String text = alert.getText();
//		System.out.println("Confirm Text::: "+ text);
//
//		//Press the cancel button
//		alert.accept();



	}

}
