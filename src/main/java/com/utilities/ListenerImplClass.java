package com.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class contains implementation for ITestListener 
 * 
 * @author Harapriya
 *
 */
public class ListenerImplClass implements ITestListener {
	
	ExtentSparkReporter sparkreport;
	ExtentTest test;
	ExtentReports report;
	
	public void onStart(ITestContext context) {
		//Step-1: Extent report configuration
		sparkreport= new ExtentSparkReporter("./Extent/extentReport"+new JavaUtility().getTimeWithDate()+".html");		
		sparkreport.config().setReportName("Batch_execution_Report");
		sparkreport.config().setDocumentTitle("BatchExecution");
		sparkreport.config().setTheme(Theme.DARK);
	
		//Step-2 : Attach the Physical report and Do system configurations.
		report= new ExtentReports();
		report.attachReporter(sparkreport);
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("Reporter name", "Bibhudatta");
		report.setSystemInfo("URL", "http://localhost:8888");
		report.setSystemInfo("Environment", "Testing Environment");
		
	}
	
	public void onTestStart(ITestResult result) {
		//Step-3: Create a test method during the test execution starts.
		  test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		//Step-4: Provide condition"status.PASS and and log the pass method name"
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		//Step-6: Provide condition"status.FAIL and" 
		//log the fail method name //Take a screenshot, Throw an exception.
		
		test.log(Status.FAIL, result.getMethod().getMethodName());
			String path= null;
		try {
			 path= new WebDriverUtilities().takeScreenshot(BaseClass.driver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
		
	}

	public void onTestSkipped(ITestResult result) {
		//Step-5: Provide condition"status.SKIP" and and log the pass method name"
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}


	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
