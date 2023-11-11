package org.iitwforce.healthcare.selenium_23;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoradActions {
	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		WebElement e = driver.findElement(By.linkText("IQAC"));
		WebElement nameWE = driver.findElement(By.name("name"));
		Actions builder = new Actions(driver);
		builder.moveToElement(e); 
		builder.build().perform();
		Thread.sleep(5000);
		builder.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(5000);
		builder.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(5000);
		builder.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(5000);
		builder.sendKeys(Keys.ARROW_DOWN).perform(); 


		//		Actions action = new Actions(driver);
		//		action.moveToElement(e); // mouse hover
		//		action.perform();
		//
		//		
		//		e.sendKeys(Keys.ARROW_DOWN);
		//		e.sendKeys(Keys.ARROW_DOWN);
		//		e.sendKeys(Keys.ARROW_DOWN);
		//		action.sendKeys(Keys.ENTER);
		//		action.sendKeys(Keys.RETURN);

		//		Thread.sleep(2000);
		//		action.keyDown(Keys.SHIFT);
		//		action.sendKeys(nameWE,"hello");
		//		action.keyUp(Keys.SHIFT);
		//		action.sendKeys(Keys.BACK_SPACE);
		//		action.sendKeys(nameWE,Keys.chord(Keys.CONTROL, "a"));
		//		action.sendKeys(Keys.BACK_SPACE);
		//		 
		//		action.perform();


	}


}
