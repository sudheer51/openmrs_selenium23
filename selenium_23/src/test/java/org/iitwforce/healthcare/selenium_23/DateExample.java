package org.iitwforce.healthcare.selenium_23;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
	
	 

		public static void main(String[] args) {
			Calendar cal = Calendar.getInstance();
			Date d  = cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String currentYear = sdf.format(d);
			Integer output = Integer.parseInt(currentYear)-1980;
			System.out.println(output);

		}
	 

}
