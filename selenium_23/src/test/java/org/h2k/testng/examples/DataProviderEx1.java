package org.h2k.testng.examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	@DataProvider(name = "DP")
	public Object[][] createData1() 
	{
		Object o1 [][] = new  Object[][] 
			{
				{ "Cedric", "Student1" },
				{ "Anne", "Student2"},
			};
		return o1;
	}


	@Test(dataProvider = "DP")
	public void verifyData1(String n1, String n2) {
		System.out.println(n1 + " " + n2);
	}

}
