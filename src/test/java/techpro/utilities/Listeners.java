package techpro.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED : "+result.getName());
        ReusableMethods.getScreenshot("Test-Case-Pass-"+result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(" FAILED: "+result.getName());
      ReusableMethods.getScreenshot("Test-Case-Fail-"+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped: "+result.getName());
        ReusableMethods.getScreenshot("Test-Case-Skipped-"+result.getName());
    }
}
