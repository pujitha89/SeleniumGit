package pujithaselenium.MavenProject;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;

import resources.Extentreports;

public class Listeners extends InitilizeDrivers implements ITestListener{
	ExtentTest test;
	Extentreports report=new Extentreports();//object creation
	ExtentReports output=report.getReports();//calling the method and storing in variable

	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=output.createTest(result.getMethod().getMethodName());
		
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
	   String failTestCase=result.getMethod().getMethodName();
	   try {
		   test.addScreenCaptureFromPath(Screenshots(failTestCase), failTestCase);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		output.flush();
	}
	

}
