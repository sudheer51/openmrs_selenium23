package org.iitwforce.healthcare.selenium_23;

import java.util.Random;

public class Practise {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		System.out.println("path    "+ path);
		Random rand = new Random();
		int i = 1 + rand.nextInt(12);//0 to 12// UL - LL+1 = 12-1+1=12
		System.out.println(i);
	}
	
	public String generateRandomString()
	{
		Random rand = new Random();
		int i = 50+rand.nextInt(50);//0 to 49
		System.out.println(i);

		//Range of values between two number
		//LL = 65
		//UL=90
		//LL + rand.nextInt(UL-LL+1);

		int j = 65+rand.nextInt(26);
		System.out.println(j); 
		char upperCaseCh = (char) j ;
		System.out.println(upperCaseCh);

		int k = 97+rand.nextInt(26); 
		System.out.println(k); 
		char lowerCaseCh = (char)k; 
		System.out.println(lowerCaseCh);

		String randomString="AT_MRS_"+upperCaseCh+""+lowerCaseCh+""+i+"";

		System.out.println("Random String:::"+ randomString);
		return randomString;

	}

}
