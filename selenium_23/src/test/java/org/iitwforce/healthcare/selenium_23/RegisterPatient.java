package org.iitwforce.healthcare.selenium_23;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPatient {
	
	@Test//TestNG Annotation
	public void validateRegisterPatient() throws InterruptedException
	{
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		 
		
		HashMap<String,String> actualHMap = new HashMap<String,String>();
		actualHMap.put("id","");
		actualHMap.put("name","");
		actualHMap.put("gender","");
		actualHMap.put("age","");
		actualHMap.put("dob","");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(1280, 672));

		//login
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		
		//Register a patient
		driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
						 
		String randomString = generateRandomString();
		driver.findElement(By.name("givenName")).sendKeys("Given"+randomString);
		String expected = driver.findElement(By.name("givenName")).getAttribute("value");
		driver.findElement(By.name("middleName")).sendKeys("Middl"+randomString);
		driver.findElement(By.name("familyName")).sendKeys("Surname"+randomString);
		
		expectedHMap.put("name",driver.findElement(By.name("givenName")).getAttribute("value")+" "+
								driver.findElement(By.name("middleName")).getAttribute("value")+" "+
								driver.findElement(By.name("familyName")).getAttribute("value"));
		
		driver.findElement(By.id("next-button")).click();
		
 
		Select genderSelect = new Select(driver.findElement(By.id("gender-field")));
		String genderValue="Male";
		genderSelect.selectByVisibleText(genderValue);
		if(genderValue.equals("Male"))
		{
			expectedHMap.put("gender","M");
		}
		else
		{
			expectedHMap.put("gender","F");
		}
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("birthdateDay-field")).sendKeys("01");

		WebElement birthMonthWE = driver.findElement(By.id("birthdateMonth-field"));
		Select monthSelect = new Select(birthMonthWE);
		int monthTobeSelected = generateRandomMonth();
		monthSelect.selectByIndex(monthTobeSelected);
		 
		
		//birthMonthWE.findElement(By.xpath("//option[. = 'January']")).click();
		
		driver.findElement(By.id("birthdateYear-field")).click();
		driver.findElement(By.id("birthdateYear-field")).sendKeys(generateRandomYear(1980));
		expectedHMap.put("age",getDifferenceinYears(1980));
		
		List<WebElement> list = monthSelect.getAllSelectedOptions();
		System.out.println(list.get(0).getText());
		expectedHMap.put("dob",
								driver.findElement(By.id("birthdateDay-field")).getAttribute("value")+" "+
										list.get(0).getText()+" "+"1980");
	 
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).sendKeys("Address1");
		driver.findElement(By.id("address2")).sendKeys("Addres2");
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("1231231231");
		driver.findElement(By.id("next-button")).click();

		WebElement dropdown = driver.findElement(By.id("relationship_type"));
		Select relationShipSelect = new Select(dropdown);
		relationShipSelect.selectByVisibleText("Doctor");

		driver.findElement(By.cssSelector(".person-typeahead")).click();
		driver.findElement(By.cssSelector(".person-typeahead")).sendKeys("123awdgsa");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("submit")).submit();//click on confirm
		
//		//Navigate to homePage
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/em[text()='Patient ID']/following-sibling::span")));
	    expected =driver.findElement(By.xpath("//div/em[text()='Patient ID']/following-sibling::span")).getText();
		expectedHMap.put("id",expected);
		System.out.println(expectedHMap);
		driver.findElement(By.cssSelector("ul#breadcrumbs>li")).click();
		
		//driver.navigate().to("https://demo.openmrs.org/openmrs/login.htm");
		
		//click on findA patient record
		driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
		//I search with expectedGiven name
		driver.findElement(By.id("patient-search")).sendKeys(expected);
	 	//Fetch the displayed given name in the table first row
		String actualID = driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[1]")).getText();
		actualHMap.put("id",actualID);
		actualHMap.put("name","");
		actualHMap.put("gender","");
		actualHMap.put("age","");
		actualHMap.put("dob","");
		Assert.assertTrue(actualID.contains(expected));
	 
	}
	public static String getDifferenceinYears(Integer dobYear)
	{
		Calendar cal = Calendar.getInstance();
		Date d  = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String currentYear = sdf.format(d);
		Integer output = Integer.parseInt(currentYear)-dobYear;
		return output+"";
		
	}
	public static String generateRandomString()
	{
		Random rand = new Random();
		int i = rand.nextInt(100);
		System.out.println(i);
		
		int j = 65+rand.nextInt(26);
		System.out.println(j);
		char upperCaseCh = (char)j;
		System.out.println(upperCaseCh);
		
		int k = 97+rand.nextInt(26);
		System.out.println(k);
		char lowerCaseCh = (char)k;
		System.out.println(lowerCaseCh);
		
		String randomString=upperCaseCh+""+lowerCaseCh+""+i+"";
		
		System.out.println(randomString);
		return randomString;
	}
	public static String generateRandomYear(int startYear)
	{
		
		Random rand = new Random();
		int year = startYear+rand.nextInt(10);
		//Integer i = new Integer(year);
		return year+"";
	}
	// LL + rand.nextInt(UL-LL+1)
	public static int generateRandomMonth()
	{
		Random rand = new Random();
		int i = 1 + rand.nextInt(12);//0 to 12// UL - LL+1 = 12-1+1=12
		System.out.println(i);
		return i;
	}

}
//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//WebElement givenNameWE= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("PersonName-givenName")));
//
//
////String actual = givenNameWE.getText();
