package org.iitwforce.healthcare.selenium_23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectExample {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);
		WebElement e = driver.findElement(By.id("animals"));
		Select sel = new Select(e);
		sel.selectByIndex(2);
		List<WebElement> list = sel.getAllSelectedOptions();
		System.out.println(list.get(0).getText());
	 
	}
}
