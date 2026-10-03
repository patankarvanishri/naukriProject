package utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
//extent report 5.x

public class ExtentReport implements ITestListener {
	
	
		public ExtentSparkReporter sparkReporter; // responsible UI of the report --look and fill
		public ExtentReports extent; //responsible for common data like environment details,OS
		public ExtentTest test; //writing or creating the entries in the report like pass, fail,skipped entries
		
		String repName;
		
		public void onStart( ITestContext testContext) 
		{
			
			 String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//timeStamp
			 repName="Test-Report-"+timeStamp+".html";
			 String path=System.getProperty("user.dir")+File.separator+"reports"+File.separator + repName ;
			 System.out.println(path);
			 //C:\Users\patan\eclipse-workspace\petStoreAutomation\reports
			//sparkReporter =new ExtentSparkReporter(".//reports//"+repName); //specify location of the report"
			 sparkReporter =new ExtentSparkReporter(path);
			 sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); //title of report
			 sparkReporter.config().setReportName("Naukri Project"); //name of report
			 sparkReporter.config().setTheme(Theme.DARK);
			 
			 extent=new ExtentReports();
			 extent.attachReporter(sparkReporter);
			 extent.setSystemInfo("Application", "Naukri Project");
			 extent.setSystemInfo("Operating System", System.getProperty("os.name"));
			 extent.setSystemInfo("User Name",System.getProperty("user.name"));
			 extent.setSystemInfo("Environment", "QA");
			 extent.setSystemInfo("user", "Vanishri");
			 
		}
		
		
		public void onTestSuccess(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS,"Test Passed");
			
		}
		
		public void onTestFailure(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL,"Test Failed");
			
			//test.log(Status.FAIL,result.getThrowable().getMessage());
			if (result.getThrowable() != null) 
			{ 
				test.log(Status.FAIL, result.getThrowable().getMessage()); 
			}
			
		}
		
		public void onTestSkipped(ITestResult result) {
			test=extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP,"Test Failed");
			//test.log(Status.SKIP,result.getThrowable().getMessage());
			if (result.getThrowable() != null)
			{ 
				test.log(Status.FAIL, result.getThrowable().getMessage());
		    }
			
		}

		public void onFinish( ITestContext testContext) 
		{
			
	            extent.flush();
	         //make ready on report-write into report if we miss this report will not generate
		}
		
		
	}



