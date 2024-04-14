package com.github.base;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Common extends SeleniumBase { 

	public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(properties.getProperty("url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	  public void initializeReport(){
	        sparkReporter =  new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/extentSparkReport.html");
	        sparkReporter.config().setDocumentTitle("AutomationReport");
	        sparkReporter.config().setReportName("Automation Test Execution Report");
	        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	        extent =new ExtentReports();
	        extent.attachReporter(sparkReporter);
	  }
	
	@AfterTest
	public void quit() {
		driver.quit();
	}
}
