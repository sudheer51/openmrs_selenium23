package org.iitwforce.healthcare.selenium_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropExample {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		//1. Identify the webElement of smaller rectangle
		WebElement draggable=driver.findElement(By.id("draggable"));
		WebElement droppable=driver.findElement(By.id("droppable"));
		
		//2. Clickandhold smaller rectangle
		Actions action = new Actions(driver);
		action.clickAndHold(draggable);
		
		//3. Move to the bigger rectangle
		action.moveToElement(droppable);
		
		//4. Release the smaller rectangle
		action.release(draggable);
		
		//mandatorily statement to be called
		action.perform();
		
		String text= driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
		System.out.println(text);
		String expectedColor="rgba(255, 250, 144, 1)";
		
		//Fetching the color yellow for the droppable box
		String actualColor = droppable.getCssValue("background-color");
		System.out.println("the color displayed is " + actualColor);
		if(expectedColor.equals(actualColor))
		{
			System.out.println("TC Pass");
		}
		else
		{
			System.out.println("TC fails");
		}
		
		
		
	}

}
