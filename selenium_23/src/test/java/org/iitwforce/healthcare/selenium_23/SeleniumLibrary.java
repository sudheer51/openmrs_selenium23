package org.iitwforce.healthcare.selenium_23;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumLibrary {

	public  String getDate()
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY-HH-mm-ss-SS");
		String date = sdf.format(cal.getTime());
		System.out.println(date);
		return date;
	}

	public static void captureScreenshot(String fileName,WebDriver driver) throws IOException  
	{

		//TakesScreenshot is an interface implemented by the class chromeDriver
		//Typecasting
		TakesScreenshot tsh =(TakesScreenshot) driver;
		File srcFile = tsh.getScreenshotAs(OutputType.FILE);
		File destFile = new File(fileName);
		FileUtils.copyFile(srcFile, destFile);

	}
}
