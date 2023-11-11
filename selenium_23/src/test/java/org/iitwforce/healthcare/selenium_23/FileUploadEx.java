package org.iitwforce.healthcare.selenium_23;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadEx {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30) );
		driver.get("https://the-internet.herokuapp.com/upload");
		boolean result = uploadFile("BangaloreCity.jpg",driver);
		if(result==true)
		{
			System.out.println("jpg file format is uploaded successfully");
		}
		
		result = uploadFile("BangaloreCity.txt",driver);
		if(result==true)
		{
			System.out.println("txt file format is uploaded successfully");
		}
		uploadFile("BangaloreCity.doc",driver);
		uploadFile("BangaloreCity.zip",driver);
		uploadFile("BangaloreCity.pptx",driver);
		uploadFile("BangaloreCity.sh",driver);
		
	}
	public static boolean uploadFile(String fileName,WebDriver driver)
	{
		File f = new File(fileName);
		//driver.findElement(By.id("file-upload")).sendKeys(f.getAbsolutePath());
		driver.findElement(By.xpath("//input[#id='file-upload']")).sendKeys(f.getAbsolutePath());
		driver.findElement(By.id("file-submit")).submit();
		String expected="File Uploaded!";
		String actual = driver.findElement(By.tagName("h3")).getText();
		boolean result = false;
		if(actual.equals(expected))
		{
			result = true;
		}
		return result;
		
	}


}




