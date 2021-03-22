package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver intializeDriver () throws IOException {
		
	prop = new Properties();
	FileInputStream fis = new FileInputStream (System.getProperty("user.dir")+"//src//main//java//resources//dataProperties");
	
	
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	
	
	
	if (browserName.equals("chrome")) {
		
		//execute chrome driver
		System.setProperty("webdriver.chrome.driver", "//Users//lilmarkv//Downloads//Drivers//chromedriver_89");
		driver= new ChromeDriver ();
		driver.manage().window().maximize();
		
	}
	else if (browserName== "firefox") {
		//firefox code
	}
	
	else if (browserName == "IE") {
		//IE code
	}
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	return driver;
	
	}
	
	public String getScreenshotPath (String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	
		
	}
	

}
