package org.iitwforce.healthcare.selenium_23;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY-HH-mm-ss-SS");
		String date = sdf.format(cal.getTime());
		System.out.println(date);
		cal = Calendar.getInstance();
		 
		date = sdf.format(cal.getTime());
		System.out.println(date);
		
    	File f  = new File("sample.txt");
		boolean result = f.createNewFile();
		System.out.println(result);
	 
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
    }
}
