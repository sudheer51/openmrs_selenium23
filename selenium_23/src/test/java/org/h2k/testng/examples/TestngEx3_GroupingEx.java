package org.h2k.testng.examples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngEx3_GroupingEx {
	
	/*
	 * Grouping mechanism:
	 * UI/API
	 * APPNAME
	 * SANITY/REGRESSION
	 * USERSTORY_NO
	 * BACKLOG_NO
	 */
	
	@BeforeSuite
	public void beforeSuite()
	{
		
		System.out.println("In Before Suite");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("In After Suite");
		
	}
	@BeforeTest
	public void beforeTest()
	{
		
		
	}
	@AfterTest
	public void afterTest()
	{
		
		
	}
	@BeforeGroups(groups= {"US_123"})
	public void beforeGroups()
	{
		
		
	}
	@AfterGroups(groups= {"US_123"})
	public void afterGroups()
	{
		
		
	}
	 
	@BeforeClass
	public void beforeClass()
	{
		
		
	}
	@AfterClass
	public void afterClass()
	{
		
		
	}
	@BeforeMethod
	public void beforeMethod()
	{
		
		
	}
	@AfterMethod
	public void afterMethod()
	{
		
		
	}
	
	@Test(groups= {"ui","sanity"})
	public void a1()
	{
		
		
	}
	@Test(groups= {"ui","sanity","US_123"})
	public void a2()
	{
		
		
	}
	@Test(groups= {"ui","regression","US_123"})
	public void a3()
	{
		
		
	}

}
