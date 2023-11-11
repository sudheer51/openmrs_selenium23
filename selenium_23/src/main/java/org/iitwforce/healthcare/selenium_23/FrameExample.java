package org.iitwforce.healthcare.selenium_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameExample {
	static WebDriver   driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames");
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);
		driver.switchTo().frame("frame1");
		WebElement e = driver.findElement(By.cssSelector("input[type='text']"));
		e.sendKeys("In Frame1");
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame1");
		driver.findElement(By.cssSelector("input[type='text']")).clear();
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("In Frame111");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		Select animalList = new Select(driver.findElement(By.id("animals")));
		animalList.selectByVisibleText("Cat");
		driver.switchTo().defaultContent();
		title = driver.getTitle();
		System.out.println("Title of the page :::" + title);


	}


}
