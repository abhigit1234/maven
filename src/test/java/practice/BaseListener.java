package practice;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class BaseListener extends BaseTest implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		capture(result.getTestContext().getName()+" "+result.getMethod().getMethodName()+".png");
		
	}
	
	
}