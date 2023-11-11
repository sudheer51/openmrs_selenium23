package org.h2k.testng.examples;



import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ListenerExample implements ITestListener
{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Method method = result.getMethod().getConstructorOrMethod().getMethod();
		Test test = method.getAnnotation(Test.class);
		String testname = test.testName();
		System.out.println("Executing the TestCase::" + testname);

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Successfully executed the TestCase::" + result.getTestName() +"--"+result.getStatus());

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Executed the TestCase Successfully::" + context.getName());
	}



}
