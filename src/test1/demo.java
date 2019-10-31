/////// SECOMND CLASS - ITESTLISTENER IMPLEMTATION

package test1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.fc.Credentialing.base.TestBase;
import com.fc.Credentialing.report.ExtentReport;
import com.fc.Credentialing.report.LogStatus;


public class demo implements ITestListener
{

	public void onFinish(ITestContext context) 
	{
		ExtentReport.report.endTest(ExtentReport.logger);
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		ExtentReport.logger= ExtentReport.report.startTest(arg0.getName());
	}

	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		ExtentReport.logger= ExtentReport.report.startTest(arg0.getName());
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
   //   TODO Auto-generated method stub
		/*String screenshot_path = ExtentReport.captureScreenshot(TestBase.driver, arg0.getName());
		String image = ExtentReport.logger.addScreenCapture(screenshot_path);
		
		LogStatus.fail("Test Case description: \""+arg0.getMethod().getDescription()+"\"  has failed."+image);*/
	//	LogStatus.fail("The page where the test failed ");
		
		
			String screenshot_path = ExtentReport.captureScreenshot(TestBase.driver, arg0.getName());
			String image = ExtentReport.logger.addScreenCapture(screenshot_path);
			
			LogStatus.fail("Test Case description: \""+arg0.getMethod().getDescription()+"\"  has FAILED."+image);
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		LogStatus.fail("Test Case Skipped");
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		com.fc.Credentialing.report.LogStatus.pass("Test Case Method Name \""+arg0.getMethod().getMethodName()+"\" Started");
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		LogStatus.pass("Test Case description: \""+arg0.getMethod().getDescription()+"\"  has PASSED.");
	}

}



//////IMPLEMENT THIS IN TESTNG.XML

<listeners>
		<listener class-name="com.fc.Credentialing.listner.Listner"></listener>
	</listeners>


}