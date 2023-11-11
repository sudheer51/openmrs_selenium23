package org.iitwforce.healthcare.selenium_23;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClick {//Right click for mouse actions
	
	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement button = driver.findElement(By.xpath("//span[text()='right click me']"));
	
		Actions action = new Actions(driver);
		action.moveToElement(button);//mouse hover
		action.contextClick();//right click
		action.perform();
		
		driver.findElement(By.xpath("//span[text()='Edit']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

}
