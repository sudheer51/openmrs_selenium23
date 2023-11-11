package org.h2k.testng.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngEx1 {
	
	//https://testng.org/doc/documentation-main.html#test-groups
	//@Test is an TESTNG Annotation
	//priority is an attribute
	//description
	//enabled
	//dependsonMethods , alwaysRun=true
	//groups
	
	@Test(priority=-1,description="Executing the testcase to validate the title of the webpage")
	public void m1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected="OpenMRs";
		Assert.assertEquals(actual,expected);
		
		
		
	}
	@Test(priority=2,enabled=false)
	public void m2()
	{
		
	}
	@Test (priority=3)
	public void a1()
	{
		
	}

}
