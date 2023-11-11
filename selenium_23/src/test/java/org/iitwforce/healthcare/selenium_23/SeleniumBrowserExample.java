package org.iitwforce.healthcare.selenium_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBrowserExample {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//WebDriver is a interface implemented by class ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);
		//textbox/textarea
		driver.findElement(By.name("name")).sendKeys("FName");
		//radio/button/checkbox
		driver.findElement(By.name("gender")).click();
		
		//Select the value from listbox
		WebElement courseWE = driver.findElement(By.id("capp"));
		Select courseDropDown = new Select(courseWE);
		courseDropDown.selectByVisibleText("M.Sc Computer Science");
	}

}
//ctrl+shit+o